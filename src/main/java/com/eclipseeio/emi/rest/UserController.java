package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.UserDto;
import com.eclipseeio.emi.model.Authority;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.model.User;
import com.eclipseeio.emi.model.response.UserResponse;
import com.eclipseeio.emi.model.response.UserResponseFactory;
import com.eclipseeio.emi.model.specifications.UserSpecification;
import com.eclipseeio.emi.repository.AuthorityRepository;
import com.eclipseeio.emi.repository.UserRepository;
import com.eclipseeio.emi.security.TokenHelper;
import com.eclipseeio.emi.service.EmailService;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.UserService;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by fan.jin on 2016-10-15.
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenHelper tokenHelper;


    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Value("${app.url}")
    private String aUrl;

    @Value("${jwt.header}")
    private String tokenHeader;




    @RequestMapping(method = GET, value = "/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @RequestMapping(method = GET, value = "/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }


    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @RequestMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }




    @RequestMapping(value = "/users/authorities", method = RequestMethod.GET)
    public Result update() {
        Result result = new Result();
        result.setSuccess(true);
        List<Authority> authorities = authorityRepository.findAll();
        //authorities.forEach(authority -> authority.setUsers(null));
        result.setAuthorities(authorities);
        return result;
    }

    
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Result create(@RequestBody UserDto userDto) {
        Result result = Validator.validateNewUser(userDto, userRepository);
        if (result.isSuccess()) {
            try {
                User user = new User();

                if (userDto.getAuthorities() == null) {
                    List<Authority> authorities = new ArrayList<>();
                    Authority authority = authorityRepository.findById(userDto.getRoleId());
                    authorities.add(authority);
                    user.setAuthorities(authorities);
                }
                user.setUsername(userDto.getUsername());
                user.setFirstName(userDto.getFirstname());
                user.setLastName(userDto.getLastname());
                user.setEmail(userDto.getEmail());
                user.setLastPasswordResetDate(new Timestamp(new Date().getTime()));
                user.setEnabled(false);
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userRepository.save(user);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setMessage(e.getMessage());
            }
        }
        return result;
    }




    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result users(@Param("pageable") Pageable pageable, @RequestParam Map<String, String> queryParameters) {
        Result result = new Result();
        try {
            if (pageable == null)
                pageable = new PageRequest(0,10);

            String query = queryParameters.get("query");
            Page<User> page;
            if (query != null && query.trim().length() > 0) {
                page = userRepository.findAll(new UserSpecification(query), pageable);
            } else {
                page = userRepository.findAll(pageable);
            }
            List<UserResponse> jwtUsers = new ArrayList<>();
            page.getContent().forEach(user -> jwtUsers.add(UserResponseFactory.create(user)));
            com.eclipseeio.emi.model.Page p = new com.eclipseeio.emi.model.Page();
            p.setTotalElements(page.getTotalElements());
            p.setNumberOfElements(page.getNumberOfElements());
            p.setTotalPages(page.getTotalPages());
            result.setPage(p);
            result.setUsers(jwtUsers);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/users/forgot", method = RequestMethod.POST)
    public Result forgotPassword(@RequestBody User user) {
        Result result = new Result();
        result.setSuccess(true);
        User _user = userRepository.findByEmail(user.getEmail());
        if (_user == null) {
            result.setSuccess(false);
            result.setMessage(MessageResource.MESSAGE_EMAIL_NOT_EXIST);
        } else {
            UserDetails userDetails = userDetailsService.loadUserByUsername(_user.getUsername());
            String token = tokenHelper.generateToken(userDetails);
            String url =  aUrl + "/change-password?token=" + token;
            String message = "Click here to change new password <a href='" + url + "'>Change Password</a>";
            emailService.sendHtmlMail(user.getEmail(), "HR MANG. - New Password", message);
            result.setMessage(MessageResource.MESSAGE_FORGOT_PASSWORD_EMAIL_SENT);
        }
        return result;
    }



    @RequestMapping(value = "/users/change-password", method = RequestMethod.PUT)
    public Result changePassword(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        try {
            String token = null;
            try {
                token = request.getHeader(tokenHeader).substring(7);
            } catch (Exception e) {
            }
            if (token != null) {
                String username = null;
                try {
                    username = tokenHelper.getUsernameFromToken(token);
                } catch (Exception e) {
                }
                if (username != null) {
                    User _user = userRepository.findByUsername(username);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(_user.getUsername());

                    if (tokenHelper.validateToken(token, userDetails)) {
                        result.setSuccess(true);
                        _user.setPassword(passwordEncoder.encode(user.getPassword()));
                        userRepository.save(_user);
                        result.setMessage(MessageResource.MESSAGE_UPDATE);
                    } else {
                        result.setMessage(MessageResource.MESSAGE_TOKEN_EXPIRED);
                    }
                } else {
                    result.setMessage("Not a valid user");
                }
            } else {
                result.setMessage("Not a valid link");
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
        }
        return result;
    }
}

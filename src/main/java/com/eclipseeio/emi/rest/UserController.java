package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.UserDto;
import com.eclipseeio.emi.model.Authority;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.model.User;
import com.eclipseeio.emi.repository.AuthorityRepository;
import com.eclipseeio.emi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
    private AuthorityRepository authorityRepository;


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


    @RequestMapping(value = "users", method = RequestMethod.POST)
    public Result create(@RequestBody UserDto userDto) {
        Result result = new Result();
        return result;
    }

    @RequestMapping(value = "users/authorities", method = RequestMethod.GET)
    public Result update() {
        Result result = new Result();
        result.setSuccess(true);
        List<Authority> authorities = authorityRepository.findAll();
        //authorities.forEach(authority -> authority.setUsers(null));
        result.setAuthorities(authorities);
        return result;
    }


}

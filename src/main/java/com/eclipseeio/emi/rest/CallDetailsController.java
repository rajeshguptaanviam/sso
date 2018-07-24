package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.CallDetainsDTO;
import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.model.User;
import com.eclipseeio.emi.model.response.CallDetailsResponeFactory;
import com.eclipseeio.emi.model.response.CallDetailsResponse;
import com.eclipseeio.emi.model.specifications.CallDetailsSpecification;
import com.eclipseeio.emi.repository.*;
import com.eclipseeio.emi.service.EmailService;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/")
public class CallDetailsController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private IndustryRepository industryRepository;

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private BenefitsRepository benefitsRepository;
    @Autowired
    private AssignToRepository assignToRepository;
    @Autowired
    private AdditionalRequirementsRepository additionalRequirementsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CallDetailsRepository callDetailsRepository;

    @Autowired
    private CallTopicRepository callTopicRepository;


    @Autowired
    private EmailService emailService;

    @RequestMapping(method = RequestMethod.POST, value = "addCallDetails")
    @PreAuthorize("hasAnyRole('HR','ADMIN')")
    public Result createCompany(@RequestBody CallDetainsDTO callDetailDto) {
        Result result = Validator.validateCallDetails(callDetailDto,companyRepository,userRepository,callTopicRepository);
        CallDetail callDetail1 = new CallDetail();
        if (result.isSuccess()) {
            try {
                callDetail1.setConversationContent(callDetailDto.getConversationContent());
                callDetail1.setCompany(companyRepository.findById(callDetailDto.getCompanyId()));
                callDetail1.setCallTopic(callTopicRepository.findById(callDetailDto.getCalltopicId()));
                callDetail1.setUser(userRepository.findById(callDetailDto.getUserId()));
                callDetail1.setStatus(true);
                callDetailsRepository.save(callDetail1);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping(value = "deleteCallDetail/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Long id) {
        Result result = new Result();
        result.setSuccess(true);
        try {
            CallDetail callDetail = callDetailsRepository.findById(id);
            if (callDetail != null) {
                callDetail.setStatus(false);
                callDetailsRepository.save(callDetail);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_DELETE);
            } else {
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_ADMIN_DELETE);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
    @RequestMapping(value = "callDetails", method = RequestMethod.GET)
    public Result users(@Param("pageable") Pageable pageable, @RequestParam Map<String, String> queryParameters) {
        Result result = new Result();
        try {
            if (pageable == null)
                pageable = new PageRequest(0, 10);

            String query = queryParameters.get("query");
            Page<CallDetail> page;
            if (query != null && query.trim().length() > 0) {
                page = callDetailsRepository.findAll(new CallDetailsSpecification(query), pageable);
            } else {
                page = callDetailsRepository.findAllByStatusIsTrue(pageable);
            }
            List<CallDetailsResponse> callDetailsResponses = new ArrayList<>();
            page.getContent().forEach(callDetail -> callDetailsResponses.add(CallDetailsResponeFactory.create(callDetail)));
            com.eclipseeio.emi.model.Page p = new com.eclipseeio.emi.model.Page();
            p.setTotalElements(page.getTotalElements());
            p.setNumberOfElements(page.getNumberOfElements());
            p.setTotalPages(page.getTotalPages());
            result.setPage(p);
            result.setCallDetailsResponses(callDetailsResponses);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "downloadCallDetailCSV", method = RequestMethod.GET)
    public ModelAndView downloadCSV(Model model, HttpServletResponse response) throws Exception {
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\calldetails.csv", false);
        Result result = new Result();
        result.setSuccess(true);
        try {
            String FILE_HEADER = "id,company_name,employee Name,created,updated";
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            List<CallDetail> callDetails = callDetailsRepository.findAll();
            if (callDetails != null) {
                for (CallDetail callDetail : callDetails) {
                    fileWriter.append(String.valueOf(callDetail.getId()));
                    fileWriter.append(COMMA_DELIMITER);
                    Company company_ = callDetail.getCompany();
                    fileWriter.append(company_.getCompanyName());
                    User user = callDetail.getUser();
                    fileWriter.append(user.getFirstName() + " " + user.getLastName());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(callDetail.getCreatedAt()));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(callDetail.getUpdatedAt()));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/api/callDetailsCSV");
    }

    @GetMapping(value = "/callDetailsCSV")
    public void callDeatails(HttpServletResponse response) throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\callDetails.csv");
        if (file.exists()) {
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());

        }
    }


}

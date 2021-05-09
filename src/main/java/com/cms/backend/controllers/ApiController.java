package com.cms.backend.controllers;

import com.cms.backend.data.InquiryRepository;
import com.cms.backend.models.Inquiry;
import com.cms.backend.models.Response;
import com.cms.backend.models.Result;
import com.cms.backend.service.InquiryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ApiController {

    @Autowired
    InquiryService inquiryService;

    @Value("${server.api}")
    private String serverApi;

    Logger logger = LogManager.getLogger(ApiController.class);

    @PutMapping("/api/v1/inquiries/{id}")
    public Result updateInquiry(@PathVariable  String id, @RequestBody Inquiry inquiry) throws JsonProcessingException {
        inquiryService.update(inquiry);
        Result result = new Result(true, "status changed to " + inquiry.getStatus() );
        return result;
    }

    @DeleteMapping("/api/v1/inquiries/{id}")
    public Result deleteInquiry(@PathVariable  String id) throws JsonProcessingException {
        boolean status = inquiryService.delete(id);
        Result result = new Result(status, "Inquiry deleted with _id " + id );
        return result;
    }

    @PostMapping("/api/v1/inquiries")
    public Result createInquiry(@RequestBody Inquiry inquiry) throws JsonProcessingException {
        inquiryService.create(inquiry);
        return new Result(true, "Saved to H2");
    }

     @GetMapping("/api/v1/inquiries")
     public Response getInquiries(Model model, @RequestHeader String host) throws JsonProcessingException {
        return new Response(true, inquiryService.all());
    }
}

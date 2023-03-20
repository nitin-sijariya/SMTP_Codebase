package com.cts.qea.marketplace.mail.server.SMTPService.controller;


import com.cts.qea.marketplace.mail.server.SMTPService.helper.EmailHelper;
import com.cts.qea.marketplace.mail.server.SMTPService.model.Email;
import com.cts.qea.marketplace.mail.server.SMTPService.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * author : nitin.sijariya@cognizant.com
 */
@RestController
@RequestMapping("/smtp")
public class EmailController extends CommonController{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @GetMapping("/testing")
    private Email testing() {
        Email email = new Email();
        email.setTo("nitin.sijariya@cognizant.com");
        email.setCc("nitin.sijariya@cognizant.com");
        email.setBcc("nitin.sijariya@cognizant.com");
        email.setSubject("My Subject");
        email.setBody("My Body");
        return email;
    }

    /*
    {
        "to": "nitin.sijariya@cognizant.com",   If more-then one then separated by semicolon
        "cc": "nitin.sijariya@cognizant.com",   If more-then one then separated by semicolon
        "bcc": "nitin.sijariya@cognizant.com",  If more-then one then separated by semicolon
        "subject": "My Subject",
        "body": "My Body"
    }
     */
    @GetMapping("/sendMail")
    private ResponseEntity<?> sendMail() {
        Email email = new Email();
        email.setTo("nitin.sijariya@cognizant.com");
        email.setCc("nitin.sijariya@cognizant.com");
        email.setBcc("nitin.sijariya@cognizant.com");
        email.setSubject("PDF Validator");
        email.setQuery("How to use bot");
        email.setTemplateName("contact_us");
        email.setUserName("Nitin Sijariya");

        Map<String, Object> output = new HashMap<String, Object>();
        output.put("timeStamp", Instant.now());
        try {
            String mailResponse = emailService.sendEmail(email);
            if(EmailHelper.isEmpty(mailResponse)) {
                output.put("success", true);
                output.put("result", "mail sent successFully");
                LOGGER.info("mail sent successFully");
            } else {
                output.put("success", false);
                output.put("result", "Error Occurred. Error:"+mailResponse);
                LOGGER.info("Error Occurred. Error:"+mailResponse);
            }
        } catch (Exception e) {
            output.put("success", false);
            output.put("result", "Error Occurred. Error:"+e.getMessage());
            return buildFailureResponse(output);
        }
        return buildSuccessResponse(output);
    }

}

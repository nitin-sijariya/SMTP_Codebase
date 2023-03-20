package com.cts.qea.marketplace.mail.server.SMTPService.controller;

import com.cts.qea.marketplace.mail.server.SMTPService.model.MailResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



/**
 * author : nitin.sijariya@cognizant.com
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonController {

	Map <String, MailResponse> response ;

	public ResponseEntity<?> buildSuccessResponse(Object param) {
		response = new HashMap<>();
		response.put("Response", new MailResponse("true", param));
		return ResponseEntity.ok(response);
	}


	public ResponseEntity<?> buildFailureResponse(Object param) {
		response = new HashMap<>();
		response.put("Response", new MailResponse("false", param));
		return ResponseEntity.ok(response);

	}

}

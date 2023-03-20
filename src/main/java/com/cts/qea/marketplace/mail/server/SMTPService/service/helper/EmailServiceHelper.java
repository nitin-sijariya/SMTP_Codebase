package com.cts.qea.marketplace.mail.server.SMTPService.service.helper;

import com.cts.qea.marketplace.mail.server.SMTPService.model.Email;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import static com.cts.qea.marketplace.mail.server.SMTPService.constant.Constants.*;


/**
 * author : nitin.sijariya@cognizant.com
 */
@Service
public class EmailServiceHelper {

	@Autowired
	private Configuration configuration;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceHelper.class);


	public String getEmailBody(Email email) throws IOException, TemplateException {
		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();

		/*
			contact_us.ftlh template use for contact us.
		 */
		if(email.getTemplateName().equals(CONTACT_US)){
			model.put(USERNAME, email.getUserName());
			model.put(QUERY, email.getQuery());
			configuration.getTemplate(CONTACT_US_TEMPLATE).process(model, stringWriter);
		}
		return stringWriter.getBuffer().toString();
	}

	public String getEmailSubject(Email email){

		if(email.getTemplateName().equals(CONTACT_US)){
			return "QUERY ON " + email.getSubject()+" Bot";
		}

		return null;
	}





}




package com.cts.qea.marketplace.mail.server.SMTPService.service;

import com.cts.qea.marketplace.mail.server.SMTPService.model.Email;
import com.cts.qea.marketplace.mail.server.SMTPService.service.helper.EmailServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;


/**
 * author : nitin.sijariya@cognizant.com
 */
@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmailServiceHelper emailServiceHelper;
	
	@Value("${app.mail.fromId}")
	private String fromId;
	
	@Value("${spring.mail.host}")
	private String host;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	public String sendEmail(final Email email)throws Exception {
		
		String output = null;
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		PrintStream ps = new PrintStream(os);
		
		LOGGER.trace("Inside EmailService class : sendMail method started ...");
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				/*
				 * Properties props = new Properties(); props.put("mail.smtp.host",
				 * "apacsmtp.cts.com"); props.put("mail.smtp.port", "25");
				 * props.put("mail.debug",true);
				 * 
				 * Session session = Session.getInstance(props);
				 * 
				 * mimeMessage = new MimeMessage(session);
				 */
				
				JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
				
		        mailSender.setHost(host);
		        mailSender.setPort(25);
				
				Properties props = mailSender.getJavaMailProperties();
				
				props.put("mail.transport.protocol", "smtp");
		        props.put("mail.debug", "true");
				
				Session mailSession = Session.getDefaultInstance(props);
				
				mailSession.setDebug(true);
				
				mailSession.setDebugOut(ps);
				
				//mimeMessage = new MimeMessage(mailSession);
				
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
					
				if(email.getTo() != null && !email.getTo().isEmpty()){
					StringTokenizer st = new StringTokenizer(email.getTo(),";");
					List<InternetAddress> list = new ArrayList<InternetAddress>();
					
					while (st.hasMoreElements()) {
						String to = st.nextToken();
						LOGGER.info("TO email Id :"+to);
						list.add(new InternetAddress(to));
					}
					messageHelper.setTo(list.toArray(new InternetAddress[]{}));
				}
				
				if(email.getCc() != null && !email.getCc().isEmpty()){
					StringTokenizer st = new StringTokenizer(email.getCc(),";");
					List<InternetAddress> list = new ArrayList<InternetAddress>();
					
					while (st.hasMoreElements()) {
						String cc = st.nextToken();
						LOGGER.info("CC email Id :"+cc);
						list.add(new InternetAddress(cc));
					}
					messageHelper.setCc(list.toArray(new InternetAddress[]{}));
				}
				
				if(email.getBcc() != null && !email.getBcc().isEmpty()){
					StringTokenizer st = new StringTokenizer(email.getBcc(),";");
					List<InternetAddress> list = new ArrayList<InternetAddress>();
					
					while (st.hasMoreElements()) {
						String bcc = st.nextToken();
						LOGGER.info("BCC email Id :"+bcc);
						list.add(new InternetAddress(bcc));
					}
					messageHelper.setBcc(list.toArray(new InternetAddress[]{}));
				}

				messageHelper.setFrom(new InternetAddress(fromId));

				String subject = emailServiceHelper.getEmailSubject(email);
				LOGGER.info("Subject :"+subject);
				mimeMessage.setSubject(subject);

				String body = emailServiceHelper.getEmailBody(email);
				LOGGER.info("Body :"+body);
				messageHelper.setText(body, true);
			}
		};
			
		try {
			this.mailSender.send(preparator);
			LOGGER.info(os.toString());
			LOGGER.trace("Mail sent successfully");
		}catch (MailException ex) {
			LOGGER.error(ex.getMessage());
			output = ex.getMessage();
		}
		return output;
	}

}

package com.cts.qea.marketplace.mail.server.SMTPService.model;

/**
 * author : nitin.sijariya@cognizant.com
 */
public class Email {
	
	private String to;
	
	private String cc;
	
	private String bcc;
	
	private String subject;
	
	private String body;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	private String templateName;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	private String query;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}


	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}


	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}


	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("TO: " + this.to);
		builder.append("\n");
		builder.append("CC: " + this.cc);
		builder.append("\n");
		builder.append("BCC: " + this.bcc);
		builder.append("\n");
		builder.append("Subject: " + this.subject);
		builder.append("\n");
		builder.append("Body: " + this.body);
		builder.append("\n");

		return builder.toString();
	}
}

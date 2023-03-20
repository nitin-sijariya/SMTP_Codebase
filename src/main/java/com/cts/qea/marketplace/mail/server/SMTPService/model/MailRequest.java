package com.cts.qea.marketplace.mail.server.SMTPService.model;

import java.util.Map;

/**
 * author : nitin.sijariya@cognizant.com
 */
public class MailRequest{

	/** The param. */
	private Map<String, Object> param;

/**
 * Instantiates a new crowd request.
 */
/*
 * 
 */
	public MailRequest()
	{
	}
	
	/**
	 * Instantiates a new crowd request.
	 *
	 * @param param the param
	 */
	public MailRequest(Map<String, Object> param)
	{
		this.param = param;
	}
	
	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	public Map<String,Object> getParam(){
		return param;
	}

	/**
	 * Sets the param.
	 *
	 * @param param the param
	 */
	public void setParam(Map<String,Object> param) {
		this.param = param;
	}
}

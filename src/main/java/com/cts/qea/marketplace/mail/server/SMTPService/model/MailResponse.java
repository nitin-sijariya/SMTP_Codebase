package com.cts.qea.marketplace.mail.server.SMTPService.model;



/**
 * author : nitin.sijariya@cognizant.com
 */
public class MailResponse {

	/** The status. */
	private String status;
	
	/** The error code. */
	private String errorCode;
	
	/** The error msg. */
	private String errorMsg;
	
	/** The response param. */
	private Object responseParam ;
	
	/** The response param as bytes. */
	private byte[] responseParamAsBytes;
	
	/**
	 * Instantiates a new crowd response.
	 */
	public MailResponse(){
		super();
	}
		
	
	/**
	 * Instantiates a new crowd response.
	 *
	 * @param status the status
	 * @param errorCode the error code
	 * @param errorMsg the error msg
	 */
	public MailResponse(String status,String errorCode,String errorMsg)
	{
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	/**
	 * Instantiates a new crowd response.
	 *
	 * @param status the status
	 * @param responseParam the response param
	 */
	public MailResponse(String status, Object responseParam)
	{
		this.status = status;
		this.responseParam = responseParam;
	}
	
	/**
	 * Instantiates a new crowd response.
	 *
	 * @param status the status
	 * @param responseParamAsBytes the response param as bytes
	 */
	public MailResponse(String status, byte[] responseParamAsBytes)
	{
		this.status = status;
		this.responseParamAsBytes = responseParamAsBytes;
	}
	
	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	public Object getParam() {
		return responseParam;
	}

	/**
	 * Sets the param.
	 *
	 * @param responseParam the new param
	 */
	public void setParam(Object responseParam) {
		this.responseParam = responseParam;
	}


	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}


	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}


	/**
	 * Sets the error msg.
	 *
	 * @param errorMsg the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	/**
	 * Gets the response param as bytes.
	 *
	 * @return the response param as bytes
	 */
	public byte[] getResponseParamAsBytes() {
		return responseParamAsBytes;
	}


	/**
	 * Sets the response param as bytes.
	 *
	 * @param responseParamAsBytes the new response param as bytes
	 */
	public void setResponseParamAsBytes(byte[] responseParamAsBytes) {
		this.responseParamAsBytes = responseParamAsBytes;
	}
	
	

	
}

package com.cts.qea.marketplace.mail.server.SMTPService.helper;


import com.cts.qea.marketplace.mail.server.SMTPService.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.Collection;
import java.util.Map;


public class EmailHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailHelper.class);
	
	/**
	 * Base 64 encoder.
	 *
	 * @param source the source
	 * @return the string
	 */
	public static String base64Encoder(byte[] source){
		return new String(Base64.getEncoder().encode(source));
	}
	
	/**
	 * Base 64 decoder.
	 *
	 * @param encodedValue the encoded value
	 * @return the string
	 */
	public static String base64Decoder(String encodedValue) {
		String sourceValue = "";
		try {
			sourceValue = new String(Base64.getDecoder().decode(encodedValue), "utf-8");
		} catch (Exception e) {
			LOGGER.error("UnsupportedEncodingException : {} \n Stack Trace : {}" + e.getMessage() + String.valueOf(e.getStackTrace()));
		}
		return sourceValue;
	}
	
	/**
	 * Returns true if the given value is null or is empty.
	 *
	 * @param value the value
	 * @return true, if is empty
	 */

	public static boolean isEmpty(Object value) {
		if (value == null) {
			return true;
		} else if (value instanceof String) {
			return ((String) value).trim().length() == 0;
		} else if (value instanceof Object[]) {
			return ((Object[]) value).length == 0;
		} else if (value instanceof Collection<?>) {
			return ((Collection<?>) value).size() == 0;
		} else if (value instanceof Map<?, ?>) {
			return ((Map<?, ?>) value).size() == 0;
		} else {
			return value.toString() == null
					|| value.toString().trim().length() == 0;
		}
	}
}

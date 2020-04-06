package br.com.microservice.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String messager;
	private String datails;

	/**
	 * @param timestamp
	 * @param messeger
	 * @param datails
	 */
	public ExceptionResponse(Date timestamp, String messager, String datails) {
		super();
		this.timestamp = timestamp;
		this.messager = messager;
		this.datails = datails;
	}

	
	
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMesseger() {
		return messager;
	}

	public String getDatails() {
		return datails;
	}

}

package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ABSAMessageRequest.class)
public class ABSAMessageRequest {

	private String message;
	private String code;

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public String getCode() {

		return code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	@Override
	public String toString() {

		return "ABSAMessageRequest [message=" + message + ", code=" + code + "]";
	}
}

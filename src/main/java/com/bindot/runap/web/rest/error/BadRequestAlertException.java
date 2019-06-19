package com.bindot.runap.web.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadRequestAlertException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String entityName;

	private String errorKey;

	public BadRequestAlertException(String exception) {
		super(exception);
	}

	public BadRequestAlertException(String exception, String entityName, String errorKey) {
		super(exception);
		this.entityName = entityName;
		this.errorKey = errorKey;
	}

	public String getEntityName() {
		return entityName;
	}

	public String getErrorKey() {
		return errorKey;
	}

}

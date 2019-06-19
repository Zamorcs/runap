package com.bindot.runap.web.rest.error;

import java.io.Serializable;
import java.util.Date;

public class FieldError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;
    private String entityName;
    private String errorKey;

    public FieldError(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public FieldError(Date timestamp, String message, String details, String entityName, String errorKey) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

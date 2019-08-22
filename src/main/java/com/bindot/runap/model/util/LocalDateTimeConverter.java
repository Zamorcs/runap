package com.bindot.runap.model.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
    	try {
    		return Timestamp.valueOf(ldt);
    	}catch (Exception e) {
			return null;
		}
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
    	try {
    		return ts.toLocalDateTime();
    	}catch (Exception e) {
			return null;
		}
    }
}
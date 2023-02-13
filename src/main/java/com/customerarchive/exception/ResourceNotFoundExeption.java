package com.customerarchive.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{

    private static final long serialVersionUID=1;
    private String reosurceName;
    private String fieldName;
    private Object fieldValue;


    public String getReosurceName() {
        return reosurceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }


    public ResourceNotFoundExeption(String message, String reosurceName, String fieldName, Object fieldValue) {
        super(message);
        this.reosurceName = reosurceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }
}
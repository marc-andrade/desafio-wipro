package com.wipro.desafiowipro.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }
    public ValidationError() {
        super();
    }
    public void addError(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }
    public List<FieldMessage> getErrors() {
        return errors;
    }
}

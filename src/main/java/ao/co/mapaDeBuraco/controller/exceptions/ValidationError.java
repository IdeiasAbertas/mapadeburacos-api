package ao.co.mapaDeBuraco.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

   private List<FieldMessages>  errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer statusCode, String errorMessage) {
        super(timestamp, statusCode, errorMessage);
    }

    public List<FieldMessages> getErrors() {
        return errors;
    }

    public void addErrors(String field, String message) {
        this.errors.add(new FieldMessages(field, message));
    }
}

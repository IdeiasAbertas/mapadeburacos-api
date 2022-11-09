package ao.co.mapaDeBuraco.controller.exceptions;

import java.io.Serializable;

public class FieldMessages implements Serializable {
    private static final long serialVersionUID = 1L;
    private String field;
    private String message;

    public FieldMessages() {
        super();
    }
    public FieldMessages(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

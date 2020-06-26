package imburse.model.response.error;


import java.util.List;

public class ErrorMessage {
    private long timestamp;

    private String correlationId;

    private List<Errors> errors;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setErrors(List<Errors> error) {
        this.errors = error;
    }

    public List<Errors> getErrors() {
        return this.errors;
    }

}


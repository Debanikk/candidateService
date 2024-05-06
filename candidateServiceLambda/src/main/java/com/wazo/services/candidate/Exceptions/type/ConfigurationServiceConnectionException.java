package com.wazo.services.candidate.Exceptions.type;

public class ConfigurationServiceConnectionException extends CandidateServiceException {
    public ConfigurationServiceConnectionException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConfigurationServiceConnectionException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ConfigurationServiceConnectionException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ConfigurationServiceConnectionException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

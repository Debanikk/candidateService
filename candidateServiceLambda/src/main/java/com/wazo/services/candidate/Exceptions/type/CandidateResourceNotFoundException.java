package com.wazo.services.candidate.Exceptions.type;

public class CandidateResourceNotFoundException extends CandidateServiceException {
    public CandidateResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CandidateResourceNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public CandidateResourceNotFoundException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public CandidateResourceNotFoundException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

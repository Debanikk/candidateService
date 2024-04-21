package com.wazo.services.candidate.Exceptions.type;

public class CandidateNotSavedException extends CandidateServiceException{
    public CandidateNotSavedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public CandidateNotSavedException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public CandidateNotSavedException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public CandidateNotSavedException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

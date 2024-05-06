package com.wazo.services.candidate.Exceptions.type;

public class ContactNotPresentException extends CandidateServiceException {
    public ContactNotPresentException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ContactNotPresentException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ContactNotPresentException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ContactNotPresentException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

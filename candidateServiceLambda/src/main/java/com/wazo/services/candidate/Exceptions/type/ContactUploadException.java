package com.wazo.services.candidate.Exceptions.type;

public class ContactUploadException extends CandidateServiceException {

    public ContactUploadException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ContactUploadException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ContactUploadException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public ContactUploadException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

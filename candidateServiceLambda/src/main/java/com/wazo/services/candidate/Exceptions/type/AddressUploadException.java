package com.wazo.services.candidate.Exceptions.type;

public class AddressUploadException extends CandidateServiceException {

    public AddressUploadException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AddressUploadException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public AddressUploadException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public AddressUploadException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

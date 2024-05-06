package com.wazo.services.candidate.Exceptions.type;

public class AddressNotPresentException extends CandidateServiceException {
    public AddressNotPresentException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AddressNotPresentException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public AddressNotPresentException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public AddressNotPresentException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

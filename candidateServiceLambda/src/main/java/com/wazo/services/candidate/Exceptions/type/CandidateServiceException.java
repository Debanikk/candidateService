package com.wazo.services.candidate.Exceptions.type;

public class CandidateServiceException extends RuntimeException {
    private final ErrorCode errorCode;

    public CandidateServiceException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public CandidateServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CandidateServiceException(String message, Throwable cause, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CandidateServiceException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return super.getMessage();
    }
}

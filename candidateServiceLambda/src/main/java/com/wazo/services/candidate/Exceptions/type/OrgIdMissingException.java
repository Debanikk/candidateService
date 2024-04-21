package com.wazo.services.candidate.Exceptions.type;

public class OrgIdMissingException extends CandidateServiceException {
    public OrgIdMissingException(ErrorCode errorCode) {
        super(errorCode);
    }

    public OrgIdMissingException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public OrgIdMissingException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public OrgIdMissingException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

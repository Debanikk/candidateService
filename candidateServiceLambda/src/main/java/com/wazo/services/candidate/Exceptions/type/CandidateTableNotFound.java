package com.wazo.services.candidate.Exceptions.type;

public class CandidateTableNotFound extends CandidateServiceException{
    public CandidateTableNotFound(ErrorCode errorCode) {
        super(errorCode);
    }

    public CandidateTableNotFound(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public CandidateTableNotFound(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public CandidateTableNotFound(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

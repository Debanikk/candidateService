package com.wazo.services.candidate.Exceptions.type;

public class UpdateCandidateDetailsException extends CandidateServiceException {
    public UpdateCandidateDetailsException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UpdateCandidateDetailsException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public UpdateCandidateDetailsException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }

    public UpdateCandidateDetailsException(Throwable cause, ErrorCode errorCode) {
        super(cause, errorCode);
    }
}

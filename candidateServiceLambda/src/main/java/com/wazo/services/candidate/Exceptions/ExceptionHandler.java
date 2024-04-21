package com.wazo.services.candidate.Exceptions;

import com.wazo.services.candidate.Exceptions.type.CandidateServiceException;
import dagger.internal.Preconditions;

public class ExceptionHandler {

    public CandidateServiceException handleActivityThrowable(Throwable cause) {
        cause = Preconditions.checkNotNull(cause, "Exception Cause can not be null");
        return (CandidateServiceException) cause;
    }
}

package com.wazo.services.candidate.Exceptions.type;

import lombok.Getter;
import org.apache.http.HttpStatus;

public enum ErrorCode {
    INVALID_REQUEST("INVALID_REQUEST_EXCEPTION", "Invalid request provided in input - %s", HttpStatus.SC_BAD_REQUEST),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND_EXCEPTION", "Resource not found - %s", HttpStatus.SC_NOT_FOUND),
    CONTACT_NOT_SAVED("CONTACT_NOT_SAVED_EXCEPTION", "Contact was not saved - %s", HttpStatus.SC_BAD_GATEWAY),
    ADDRESS_NOT_SAVED("ADDRESS_NOT_SAVED_EXCEPTION", "AddressEntity was not saved - %s", HttpStatus.SC_BAD_GATEWAY),
    CANDIDATE_NOT_SAVED("CANDIDATE_NOT_SAVED_EXCEPTION", "Candidate was not saved - %s", HttpStatus.SC_SERVICE_UNAVAILABLE),
    CANDIDATE_TABLE_NOT_FOUND("CANDIDATE_TABLE_NOT_FOUND_EXCEPTION", "Resource not found - %s", HttpStatus.SC_NOT_FOUND),
    ORGID_NOT_PRESENT("ORGID_NOT_PRESENT_EXCEPTION", "OrgId was not present in requestUrl - %s", HttpStatus.SC_BAD_REQUEST);

    @Getter
    private String errorCode;

    @Getter
    private String errorMessage;

    @Getter
    private int httpStatus;

    ErrorCode(String errorCode, String errorMessage, int httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}

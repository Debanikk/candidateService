package com.wazo.services.candidate.Exceptions.type;

import lombok.Getter;
import org.apache.http.HttpStatus;

public enum ErrorCode {
    INVALID_REQUEST("INVALID_REQUEST_EXCEPTION", "Invalid request provided in input - %s", HttpStatus.SC_BAD_REQUEST),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND_EXCEPTION", "Resource not found - %s", HttpStatus.SC_NOT_FOUND),
    CONTACT_NOT_CREATED("CONTACT_NOT_CREATED_EXCEPTION", "Configuration_Contact api is not reachable - %s", HttpStatus.SC_BAD_GATEWAY),
    CONTACT_NOT_FOUND("CONTACT_NOT_SAVED_EXCEPTION", "Contact was not saved - %s", HttpStatus.SC_BAD_GATEWAY),
    ADDRESS_NOT_SAVED("ADDRESS_NOT_SAVED_EXCEPTION", "Address was not saved - %s", HttpStatus.SC_BAD_GATEWAY),
    ADDRESS_NOT_FOUND("ADDRESS_NOT_FOUND_EXCEPTION", "Address was not found in data source - %s", HttpStatus.SC_BAD_GATEWAY),
    CANDIDATE_NOT_SAVED("CANDIDATE_NOT_SAVED_EXCEPTION", "Candidate was not saved - %s", HttpStatus.SC_SERVICE_UNAVAILABLE),
    CANDIDATE_TABLE_NOT_FOUND("CANDIDATE_TABLE_NOT_FOUND_EXCEPTION", "Resource not found - %s", HttpStatus.SC_NOT_FOUND),
    CANDIDATE_DETAILS_NOT_UPDATED("CANDIDATE_DETAILS_NOT_UPDATED_EXCEPTION", "Candidate details not updated - %s", HttpStatus.SC_BAD_REQUEST),
    CANDIDATE_UNDER_PROCESS_UPDATE_FAILED("CANDIDATE_UNDER_PROCESS_NOT_UPDATED_EXCEPTION", "candidate status not updated - %s", HttpStatus.SC_BAD_REQUEST),
    CANDIDATE_REMARKS_UPDATE_FAILED("CANDIDATE_REMARKS_UPDATE_FAILED_EXCEPTION", "candidate remarks not updated - %s", HttpStatus.SC_BAD_REQUEST),
    DYNAMODB_CONNECTION_ERROR("DYNAMODB_CONNECTION_ERROR_EXCEPTION", "Not able to reach datasource - %s", HttpStatus.SC_BAD_REQUEST),
    CONFIG_SERVICE_CONNECTION_ERROR("CONFIG_SERVICE_CONNECTION_ERROR_EXCEPTION", "Not able to reach configuration service to save data - %s", HttpStatus.SC_BAD_GATEWAY),
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

package com.wazo.services.candidate.utils;

import software.amazon.awssdk.regions.Region;

public class Constants {
    public static final String CANDIDATE_TABLE_NAME = "Candidate";
    public static final String UPDATE_DETAILS_VALIDATION_ERROR = "update for candidate details failed for validation errors.";
    public static final String UPDATE_REMARKS_VALIDATION_ERROR = "update for candidate comments failed with validation errors.";
    public static final String UPDATE_STATUS_VALIDATION_ERROR = "update for candidate status with requisition failed with validation errors.";
    public static final String UPDATE_ADDRESS_VALIDATION_ERROR = "update for candidate details failed for validation errors.";
    public static final String UPDATE_DOCUMENTS_VALIDATION_ERROR = "update for candidate comments failed with validation errors.";
    public static final String UPDATE_CONTACT_VALIDATION_ERROR = "update for candidate status with requisition failed for validation errors.";
    public static final String GET_ALL_CANDIDATE_SUCCESS = "Successfully fetched all candidate records.";
    public static final String GET_CANDIDATE_BY_ID_SUCCESS = "Successfully fetched candidate record.";
    public static final String ERROR_MESSAGE = "Error encountered, contact admin with action details";
    public static final String GET_SUCCESS = "Successfully fetched the candidate record.";
    public static final String DELETE_SUCCESS = "Successfully deleted the candidate record.";
    public static final String UPDATE_DETAILS_SUCCESS = "Successfully updated candidate details.";
    public static final String UPDATE_REMARKS_SUCCESS = "Successfully updated candidate details data.";
    public static final String UPDATE_STATUS_SUCCESS = "Successfully updated candidate status.";
    public static final String CREATE_CANDIDATE_SUCCESS = "Successfully created new candidate record.";
    public static final String CREATE_CANDIDATE_ERROR = "Failed to create a new candidate record.";
    public static final String CONFIG_SERVICE_IAM_ACCESS_KEY = "AWS ACCESS KEY FOR IAM";
    public static final String CONFIG_SERVICE_SECRET_ACCESS_KEY = "AWS ACCESS KEY FOR IAM";
    public static final String CONFIG_SERVICE_REGION = Region.US_EAST_2.toString();
    public static final String CONFIG_SERVICE_ENDPOINT_BASE_URL = "https://ohgw9o00yd.execute-api.us-east-1.amazonaws.com/prod/org/";
    public static final String CONFIG_SERVICE_ENDPOINT_CONFIG = "config/";
    public static final String CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_ADDRESS = "ADDRESS/";
    public static final String CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_CONTACT = "CONTACT/";
    public static final String CONFIG_SERVICE_ENDPOINT_VERSIONS = "versions/";
    //public static final String CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE = "CONTACT";
    public static final String CREATE_CANDIDATE_VALIDATION_ERROR = "Invalid request data! Please check candidate data as it does not meet required fields for a candidate record";
    public static final String UPDATE_SUCCESS_MSG_REMARKS = "Candidate comments updated";
    public static final String UPDATE_SUCCESS_MSG_DOCUMENTS = "Candidate document updated";
}

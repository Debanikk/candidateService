package com.wazo.services.candidate.utils;

import software.amazon.awssdk.regions.Region;

public class Constants {
    public static final String TABLE_NAME = System.getenv("TABLE_NAME");
    public static final String ADDRESS_PRESENT = "PRESENT";
    public static final String GET_ALL_CANDIDATE_SUCCESS = "Successfully fetched all candidate records.";
    public static final String GET_CANDIDATE_BY_ID_SUCCESS = "Successfully fetched candidate record.";
    public static final String GENERIC_CANDIDATE_ERROR_MESSAGE = "Something went wrong, try again!";
    public static final String GET_CANDIDATE_SUCCESS = "Successfully fetched the candidate record.";
    public static final String UPDATE_CANDIDATE_SUCCESS = "Successfully updated candidate record.";
    public static final String AWS_IAM_ACCESS_KEY = "AWS ACCESS KEY FOR IAM";
    public static final String AWS_IAM_SECRET_ACCESS_KEY = "AWS ACCESS KEY FOR IAM";
    public static final String AWS_REGION = Region.US_EAST_2.toString();
    public static final String AWS_API_GATEWAY_ENDPOINT_CONFIG_ADDRESS_CREATE = "endpoint address";
    public static final String AWS_API_GATEWAY_ENDPOINT_CONFIG_CONTACT_CREATE = "endpoint contact";
}

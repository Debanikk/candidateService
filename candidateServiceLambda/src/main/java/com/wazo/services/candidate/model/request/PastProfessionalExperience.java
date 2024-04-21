package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class PastProfessionalExperience {
    private String jobTitle;
    private String employer;
    private String duration;
    private String fromDate;
    private String toDate;
}

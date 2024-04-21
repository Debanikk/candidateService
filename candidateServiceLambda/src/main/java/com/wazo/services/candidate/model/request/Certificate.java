package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class Certificate {
    private String certificateId;
    private String certificateName;
    private String certificateIssuer;
    private String yearObtained;
}

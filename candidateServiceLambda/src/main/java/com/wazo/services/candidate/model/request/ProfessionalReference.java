package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class ProfessionalReference {
    private String referenceName;
    private String phone;
    private String email;
    private String company;
    private String relation;
}

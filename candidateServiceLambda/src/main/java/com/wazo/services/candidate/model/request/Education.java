package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class Education {
    private String nameOfInstitute;
    private String nameOfUniversityBoard;
    private String fromYear;
    private String toYear;
    private String cgpa;
    private Boolean isHighestEducation;
}

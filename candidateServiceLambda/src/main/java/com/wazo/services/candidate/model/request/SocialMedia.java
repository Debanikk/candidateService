package com.wazo.services.candidate.model.request;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
public class SocialMedia {
    private String socialMediaName;
    private String link;
}

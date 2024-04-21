package com.wazo.services.candidate.clients;


import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class DynamoDb {
    public DynamoDbClient getClient() {
        try {
            return DynamoDbClient.builder()
                    .region(Region.US_EAST_1)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public DynamoDbEnhancedClient getEnhanceClient() {
        try {
            // add this to use the dynamodb from local
            // .endpointOverride(URI.create("https://dynamodb.us-east-2.amazonaws.com"))
            //                            .credentialsProvider(DefaultCredentialsProvider.create())
            return DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(DynamoDbClient.builder().endpointOverride(URI.create("https://dynamodb.us-east-2.amazonaws.com"))
                            .credentialsProvider(DefaultCredentialsProvider.create())
                            .region(Region.US_EAST_2)
                            .build())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
package com.wazo.services.candidate.ConfigurationServiceClient.impl;

import com.google.gson.Gson;
import com.wazo.services.candidate.ConfigurationServiceClient.IConfigurationRestClient;
import com.wazo.services.candidate.Exceptions.type.ConfigurationServiceConnectionException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.CONFIG_SERVICE_CONNECTION_ERROR;

public class ConfigurationRestClientImpl implements IConfigurationRestClient {

    //TODO :  Need to introduce logger to use and log exact error code in cloudwatch logs which is returned from config service
    private static final Gson gson = new Gson();

    @Override
    public String executeRequestConfigurationServiceClient(String urlString, String requestBody, String requestMethod) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = getRequest(urlString, requestMethod, requestBody);

        try {
            HttpResponse<String> response = null;
            if(request != null) {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            if(response != null) {
                if (response.statusCode() > 199 && response.statusCode() < 300) {
                    return response.body();
                } else {
                    //TODO :  log exact error code for cloudwatch
                    throw new ConfigurationServiceConnectionException(CONFIG_SERVICE_CONNECTION_ERROR);
                }
            }
            else {
                throw new ConfigurationServiceConnectionException(CONFIG_SERVICE_CONNECTION_ERROR);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new ConfigurationServiceConnectionException(CONFIG_SERVICE_CONNECTION_ERROR);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new ConfigurationServiceConnectionException(CONFIG_SERVICE_CONNECTION_ERROR);
        }
    }

    private HttpRequest getRequest(String urlString, String requestMethod, String requestBody) {

        HttpRequest request;

        switch (requestMethod) {
            case "GET" :
                request = HttpRequest.newBuilder()
                        .uri(URI.create(urlString))
                        .GET()
                        .build();
                return request;
            case "POST" :
                request = HttpRequest.newBuilder()
                        .uri(URI.create(urlString))
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();
                return request;
            case "PUT" :
                request = HttpRequest.newBuilder()
                        .uri(URI.create(urlString))
                        .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();
                return request;
            case "DELETE" :
                request = HttpRequest.newBuilder()
                        .uri(URI.create(urlString))
                        .DELETE()
                        .build();
                return request;
            default:
                return null;
        }
    }
}

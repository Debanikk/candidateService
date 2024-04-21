package com.wazo.services.candidate.model.response;

import com.amazonaws.http.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;

@Data
@AllArgsConstructor
public class ApiGatewayResponse {
    InputStream content;
    public ApiGatewayResponse(HttpResponse httpResponse) {
        this.content = httpResponse.getContent();
    }
}

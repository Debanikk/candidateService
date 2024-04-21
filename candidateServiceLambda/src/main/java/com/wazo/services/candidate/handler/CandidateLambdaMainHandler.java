
package com.wazo.services.candidate.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.wazo.services.candidate.Exceptions.type.OrgIdMissingException;
import com.wazo.services.candidate.dagger.CandidateComponent;
import com.wazo.services.candidate.dagger.DaggerCandidateComponent;
import com.wazo.services.candidate.model.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.utils.StringUtils;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.ORGID_NOT_PRESENT;

public class CandidateLambdaMainHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Logger log = LoggerFactory.getLogger(CandidateLambdaMainHandler.class);
    private static CandidateComponent candidateComponent;

    public static void initializeDagger() {
        candidateComponent = DaggerCandidateComponent.builder().build();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        initializeDagger();

        String orgId = input.getPathParameters() != null ? input.getPathParameters().get("orgId") : null;

        if(StringUtils.isEmpty(orgId) || StringUtils.isBlank(orgId)) {
            throw new OrgIdMissingException(ORGID_NOT_PRESENT);
        }
        String candidateId = input.getPathParameters() != null ? input.getPathParameters().get("candidateId") : null;
        String requestBody = input.getBody() != null ? input.getBody() : "{}";
        String apiName = input.getHttpMethod().concat(":").concat(input.getResource());

        switch (apiName) {
            case "GET:/org/{orgId}/candidate":
                log.info("getAllCandidates API is called");
                return candidateComponent.getAllCandidatesActivity().run(orgId).proxyResponse();
            case "GET:/org/{orgId}/candidate/{candidateId}/details":
                log.info("getCandidateDetailsById API is called");
                return candidateComponent.getCandidateDetailsByIdActivity().run(orgId, candidateId).proxyResponse();
            case "GET:/org/{orgId}/candidate/{candidateId}":
                log.info("getCandidateById API is called");
                return candidateComponent.getCandidateByIdActivity().run(orgId, candidateId).proxyResponse();
            case "POST:/org/{orgId}/candidate":
                log.info("createCandidate API is called");
                return candidateComponent.createCandidateActivity().run(orgId, requestBody).proxyResponse();
            case "PUT:/org/{orgId}/candidate/{candidateId}":
                log.info("updateCandidate API is called");
                return candidateComponent.updatecandidateActivity().run(orgId, candidateId, requestBody).proxyResponse();
            case "DELETE:/org/{orgId}/candidate/{candidateId}":
                log.info("deletecandidate API is called");
                return candidateComponent.deletecandidateActivity().run(orgId, candidateId).proxyResponse();
            default:
                log.info("default is called, Invalid Request Method will be response with 400 error code");
                return ApiResponse.builder().status(400).message("Invalid request method!").data(input).build().proxyResponse();

        }
    }
}
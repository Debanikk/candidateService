import * as cdk from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as dynamodb from 'aws-cdk-lib/aws-dynamodb';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as apigateway from 'aws-cdk-lib/aws-apigateway';
import * as s3 from 'aws-cdk-lib/aws-s3';

export class candidateServiceCdkStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const table = new dynamodb.TableV2(this, 'candidateServiceId', {
          tableName : 'Candidate',
          partitionKey: {
            name: 'orgId',
            type: dynamodb.AttributeType.STRING
          },
          sortKey: {
            name: 'candidateId',
            type: dynamodb.AttributeType.STRING
          },
          removalPolicy: cdk.RemovalPolicy.DESTROY
        });

    const lambdaFunction = new lambda.Function(this, 'candidateServiceLambdaId', {
      code: lambda.Code.fromAsset('../candidateServiceLambda/target/candidateServiceLambda-1.0-SNAPSHOT.jar'),
      handler: 'com.wazo.services.candidate.handler.CandidateLambdaMainHandler::handleRequest',
      runtime: lambda.Runtime.JAVA_11,
      memorySize: 2048,
      ephemeralStorageSize: cdk.Size.mebibytes(2048),
      timeout: cdk.Duration.minutes(15),
      environment: {
        TABLE_NAME: table.tableName
      }
    });

    table.grantReadWriteData(lambdaFunction);

    const api = new apigateway.RestApi(this, 'candidateServiceApigatewayId', {
      defaultCorsPreflightOptions: {
        allowOrigins: apigateway.Cors.ALL_ORIGINS,
        allowMethods: apigateway.Cors.ALL_METHODS,
      }
    });

    const integration = new apigateway.LambdaIntegration(lambdaFunction);

    // Add the root org resource
    const orgResource = api.root.addResource('org');
    // Add the base {orgId} resource with root orgResource
    const orgIdResource = orgResource.addResource('{orgId}');
    // Add the candidate resource with orgIdResource
    const candidateResource = orgIdResource.addResource('candidate');
        candidateResource.addMethod('POST', integration);
        candidateResource.addMethod('GET', integration);
    // Add the {candidateId} resource along with candidateResource
    const candidateIdResource = candidateResource.addResource('{candidateId}');
        candidateIdResource.addMethod('GET', integration);
        //candidateIdResource.addMethod('PUT', integration);
        candidateIdResource.addMethod('DELETE', integration);
    // Add the details resource with candidateIdResource
    const candidateDetailsResource = candidateIdResource.addResource('details');
        candidateDetailsResource.addMethod('GET', integration);
        candidateDetailsResource.addMethod('PUT', integration);
    const candidatePortfolioResource = candidateIdResource.addResource('documents');
        candidatePortfolioResource.addMethod('PUT', integration);
    const candidateDocumentsResource = candidateIdResource.addResource('address');
        candidateDocumentsResource.addMethod('PUT', integration);
    const candidateContactResource = candidateIdResource.addResource('contact');
        candidateContactResource.addMethod('PUT', integration);
    const candidateCommentsResource = candidateIdResource.addResource('comment');
        candidateCommentsResource.addMethod('PUT', integration);
    const candidateStatusResource = candidateIdResource.addResource('status');
        candidateStatusResource.addMethod('PUT', integration);

  }
}
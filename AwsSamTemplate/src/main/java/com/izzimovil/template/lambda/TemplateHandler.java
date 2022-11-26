package com.izzimovil.template.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.izzimovil.template.model.AdpCoreResponse;
import com.izzimovil.template.model.SyncSiebelRequest;

/**
 * Handler for requests to Lambda function.
 */
public class TemplateHandler implements RequestHandler<Map<String, String>, AdpCoreResponse> {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public AdpCoreResponse handleRequest(final Map<String, String> input, final Context context) {
        AdpCoreResponse response = new AdpCoreResponse();
        try {
        	 LambdaLogger logger = context.getLogger();
             String myVariable = System.getenv("MY_VARIABLE");
             String cognitoUserPoolId = System.getenv("MY_COGNITO_USER_POOL_ID");
             logger.log("\n*** Lambda Version: 2022-11-23_v1.0  on DEV Branch");
             logger.log("\n*** MY_VARIABLE = "+myVariable); 
             logger.log("\n*** MY_COGNITO_USER_POOL_ID ***= "+cognitoUserPoolId);
             
             logger.log("\n EVENT: " + gson.toJson(input));
             /*
             logger.log("\n*** Cuenta = "+input.getAccountNumber());
             logger.log("\n*** Tel = "+input.getTelephone());
             logger.log("\n*** Email = "+input.getEmail());
             */
             logger.log("\n*** Cuenta = "+input.get("accountNumber"));
             logger.log("\n*** Tel = "+input.get("telephone"));
             logger.log("\n*** Email = "+input.get("email"));
             
            final String pageContents = this.getPageContents("https://checkip.amazonaws.com");
            String output = String.format("{ \"message\": \"Test AWS Lambda\", \"location\": \"%s\" }", pageContents);
            logger.log("\n*** output > " + output);
            
            response.setErrcode(UUID.randomUUID().toString());
            response.setErrmsg("SUCCESS: "+output);
            return response;
            
        } catch (IOException e) {
        	response.setErrcode("409");
            response.setErrmsg("ERROR CASE");
            return response;
        }
    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
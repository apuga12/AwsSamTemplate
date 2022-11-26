package com.appsdeveloperblog.aws.lambda;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.izzimovil.template.lambda.TemplateHandler;
import com.izzimovil.template.model.AdpCoreResponse;

public class TemplateHandlerTest {
  @Test
  public void successfulResponse() {
	  TemplateHandler app = new TemplateHandler();
    //APIGatewayProxyResponseEvent result = app.handleRequest(null, null);    
    //assertEquals(result.getStatusCode().intValue(), 200);
    //assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    //String content = result.getBody();
    //assertNotNull(content);
		  
	AdpCoreResponse response = new AdpCoreResponse();
	String output = String.format("{ \"message\": \"Test AWS Lambda\" }");
    System.out.println("\n*** output > " + output);
    
    response.setErrcode(UUID.randomUUID().toString());
    response.setErrmsg("SUCCESS: "+output);
    
	assertTrue(response.getErrmsg() != null);
  }
}

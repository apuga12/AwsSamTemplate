package com.appsdeveloperblog.aws.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.izzimovil.template.lambda.TemplateHandler;
import com.izzimovil.template.model.AdpCoreResponse;

public class TemplateHandlerTest {
  @Test
  public void successfulResponse() {
	  TemplateHandler app = new TemplateHandler();
    //APIGatewayProxyResponseEvent result = app.handleRequest(null, null);
	AdpCoreResponse response = new AdpCoreResponse(); 
    
    //assertEquals(result.getStatusCode().intValue(), 200);
    //assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    //String content = result.getBody();
    //assertNotNull(content);
    
	assertTrue(response.getErrmsg().contains("\"SUCCESS\""));
  }
}

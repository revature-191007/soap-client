package com.revature.clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.revature.models.generated.GetHeroRequest;
import com.revature.models.generated.GetHeroResponse;

/**
 * WebServiceGatewaySupport is a Spring class that provides some
 * basic abstract definitions regarding how to send requests to
 * a web service (SOAP WS)
 *
 */
public class SuperHeroClient extends WebServiceGatewaySupport {

	public GetHeroResponse getHero(String name) {
		GetHeroRequest request = new GetHeroRequest();
		request.setName(name);
		
		GetHeroResponse response = (GetHeroResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws", request,
						new SoapActionCallback("http://www.example.org/SuperHero"));
		return response;
	}

}

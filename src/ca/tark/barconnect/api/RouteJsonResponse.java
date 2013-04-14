package ca.tark.barconnect.api;

import java.util.HashMap;
import java.util.Map;

import ca.tark.barconnect.RouteResponse;

public class RouteJsonResponse extends RouteResponse {
	public RouteJsonResponse(String json) {
		super(200, json);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-type", "application/json");
		
		this.setHeaders(headers);
	}
}

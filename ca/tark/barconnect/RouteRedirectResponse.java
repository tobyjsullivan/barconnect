package ca.tark.barconnect;

import java.util.HashMap;

import ca.tark.barconnect.config.Configuration;
import ca.tark.barconnect.utils.RouterUtils;

public class RouteRedirectResponse extends RouteResponse {
	public RouteRedirectResponse(String location) {
		super(302, RouterUtils.getHttpCodeDescription(302));
		
		String fullLocation = location.startsWith("/") ? Configuration.read("Hostname") + location : location;
		HashMap<String, String> headers = new HashMap<String,String>();
		headers.put("Location", fullLocation);
		
		this.setHeaders(headers);
	}
}

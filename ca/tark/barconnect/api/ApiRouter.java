package ca.tark.barconnect.api;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;

public class ApiRouter {
	public static IRoute determineRoute(Request request) {
		String controllerPath = request.getSplitPath()[1];
		
		if(controllerPath.equals("establishment")) {
			return new EstablishmentRoute();
		} else if(controllerPath.equals("connection")) {
			return new ConnectionRoute();
		}
		
		return null;
	}
}

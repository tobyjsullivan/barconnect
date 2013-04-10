package ca.tark.barconnect.api;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;

public class ApiRouter {
	public static IRoute determineRoute(Request request) {
		if(request.getSplitPath()[1].equals("establishments")) {
			
			return new EstablishmentRoute();
		}
		
		return null;
	}
}

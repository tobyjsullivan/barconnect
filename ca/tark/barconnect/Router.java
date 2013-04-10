package ca.tark.barconnect;

import ca.tark.barconnect.api.ApiRouter;
import ca.tark.barconnect.files.FileRoute;

public class Router {
	public static IRoute determineRoute(Request request) {
		if(request.getSplitPath()[0].equals("api")) {			
			return ApiRouter.determineRoute(request);
		}
		
		// For everything else, assume file
		return new FileRoute();
	}
}

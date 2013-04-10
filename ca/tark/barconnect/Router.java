package ca.tark.barconnect;

import ca.tark.barconnect.api.ApiRouter;
import ca.tark.barconnect.connect.ConnectRoute;
import ca.tark.barconnect.files.FileRoute;

public class Router {
	public static IRoute determineRoute(Request request) {
		String trunk = request.getSplitPath()[0];
		
		if(trunk.equals("api")) {			
			return ApiRouter.determineRoute(request);
		} else if(trunk.equals("connect")) {
			return new ConnectRoute();
		}
		
		// For everything else, assume file
		return new FileRoute();
	}
}

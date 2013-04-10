package ca.tark.barconnect.connect;

import java.util.Map;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;
import ca.tark.barconnect.RouteRedirectResponse;
import ca.tark.barconnect.RouteResponse;
import ca.tark.barconnect.utils.RouterUtils;

public class ConnectRoute implements IRoute {	
	@Override
	public RouteResponse handle(Request request) {
		Map<String, String> query = request.getQueryMap();
		
		String estToken = null, tableToken = null;
		if(query.containsKey("establishment")) {
			estToken = query.get("establishment");
		}
		if(query.containsKey("table")) {
			tableToken = query.get("table");
		}
		
		if(estToken == null || tableToken == null) {
			return new RouteResponse(400, RouterUtils.getHttpCodeDescription(400));
		}
		
		// TODO Generate access tokens
		String redirect = "/index.html?accessToken=alkjsdbc981745";
		
		return new RouteRedirectResponse(redirect);
	}

}

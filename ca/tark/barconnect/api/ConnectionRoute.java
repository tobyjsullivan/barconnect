package ca.tark.barconnect.api;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;
import ca.tark.barconnect.RouteResponse;
import ca.tark.barconnect.controller.ConnectionController;
import ca.tark.barconnect.model.Connection;

public class ConnectionRoute implements IRoute {

	@Override
	public RouteResponse handle(Request request) {
		String[] pathParts = request.getSplitPath();
		
		if(pathParts.length > 2) {
			Connection conn = ConnectionController.findByToken(pathParts[2]);
			
			RouteResponse resp = new RouteJsonResponse(ConnectionController.viewJson(conn));
			return resp;
		}
		
		return null;
	}

}

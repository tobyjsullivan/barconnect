package ca.tark.barconnect.api;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;
import ca.tark.barconnect.RouteResponse;
import ca.tark.barconnect.controller.EstablishmentController;
import ca.tark.barconnect.model.Establishment;

public class EstablishmentRoute implements IRoute {

	@Override
	public RouteResponse handle(Request request) {
		String[] pathParts = request.getSplitPath();
		
		if(pathParts.length > 2) {
			Establishment est = EstablishmentController.findById(pathParts[2]);
			
			RouteResponse resp = new RouteResponse(200, EstablishmentController.viewJson(est));
			return resp;
		}
		
		return null;
	}

}

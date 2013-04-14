package ca.tark.barconnect.controller;

import ca.tark.barconnect.model.Establishment;
import ca.tark.barconnect.view.json.EstablishmentJsonView;

public class EstablishmentController {
	public static Establishment findById(String estId) {
		return Establishment.findById(estId);
	}
	
	public static String viewJson(Establishment establishment) {
		EstablishmentJsonView view = new EstablishmentJsonView(establishment);
		
		return view.render();
	}
}

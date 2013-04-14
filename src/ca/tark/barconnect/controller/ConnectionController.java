package ca.tark.barconnect.controller;

import ca.tark.barconnect.model.Connection;
import ca.tark.barconnect.view.json.ConnectionJsonView;

public class ConnectionController {
	public static Connection findByToken(String connToken) {
		// TODO
		return new Connection();
	}
	
	public static String viewJson(Connection connection) {
		ConnectionJsonView view = new ConnectionJsonView(connection);
		
		return view.render();
	}
}

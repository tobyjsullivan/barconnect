package ca.tark.barconnect.view.json;

import java.util.Hashtable;
import java.util.Map;

import org.json.JSONObject;

import ca.tark.barconnect.model.Connection;

public class ConnectionJsonView extends JsonView {
	private Connection _connection;
	
	public ConnectionJsonView(Connection conn) {
		this._connection = conn;
	}
	
	@Override
	public String render() {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("establishment", this._connection.getEstablishment().getId());
		map.put("table", Integer.toString(this._connection.getTable()));
		
		JSONObject json = new JSONObject(map);
		
		return json.toString();
	}

}

package ca.tark.barconnect.model;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;

public class MenuItem {
	private String _name;
	private UUID _id;
	
	public MenuItem(String name) {
		this._name = name;
		this._id = UUID.randomUUID();
	}
	
	public String getId() {
		return this._id.toString();
	}
	
	public String getName() {
		return this._name;
	}
	
	public String toJSON() {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("name", this._name);
		map.put("id", this._id.toString());
		
		JSONObject json = new JSONObject(map);
		
		return json.toString();
	}
	
	public static MenuItem fromJSON(String json) {
		JSONObject jsonObj = new JSONObject(json);
		
		String name = jsonObj.getString("name");
		UUID id = UUID.fromString(jsonObj.getString("id"));
		
		MenuItem menuItem = new MenuItem(null);
		menuItem._name = name;
		menuItem._id = id;
		
		return menuItem;
	}
}

package ca.tark.barconnect.model;

import java.util.*;

import org.json.JSONObject;

public class Menu {
	private String _name;
	private UUID _id;
	private List<MenuItem> _items;
	
	public Menu(String name) {
		this._name = name;
		this._id = UUID.randomUUID();
		this._items = new ArrayList<MenuItem>();
	}
	
	public String getId() {
		return this._id.toString();
	}
	
	public String getName() {
		return this._name;
	}
	
	public MenuItem[] getItems() {
		MenuItem[] items = new MenuItem[this._items.size()];
		this._items.toArray(items);
		return items;
	}
	
	public String toJSON() {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("name", this._name);
		map.put("id", this._id.toString());
		
		JSONObject json = new JSONObject(map);
		
		for(MenuItem item : this._items) {
			json.append("items", item.getId());
		}
		
		return json.toString();
	}
}

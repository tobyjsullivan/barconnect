package ca.tark.barconnect.model;

import java.util.*;

import org.json.JSONObject;

public class Establishment {
	private String _name;
	private UUID _id;
	private List<Menu> _menus;
	
	public static Establishment findById(String id) {
		// TODO
		
		return new Establishment("Brass Bell Pub");
	}
	
	public Establishment(String name) {
		this._name = name;
		this._id = UUID.randomUUID();
		this._menus = new ArrayList<Menu>();
	}
	
	public String getId() {
		return this._id.toString();
	}
	
	public String getName() {
		return this._name;
	}
	
	public Menu[] getMenus() {
		Menu[] menus = new Menu[this._menus.size()];
		this._menus.toArray(menus);
		return menus;
	}
	
	public String toJSON() {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("name", this._name);
		map.put("id", this._id.toString());
		
		JSONObject json = new JSONObject(map);
		
		for(Menu menu : this._menus) {
			json.append("menus", menu.getId());
		}
		
		return json.toString();
	}
}

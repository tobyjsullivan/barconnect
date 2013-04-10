package ca.tark.barconnect.view.json;

import java.util.Hashtable;
import java.util.Map;

import org.json.JSONObject;

import ca.tark.barconnect.model.Establishment;
import ca.tark.barconnect.model.Menu;

public class EstablishmentJsonView extends JsonView {
	private Establishment _establishment;
	
	public EstablishmentJsonView(Establishment establishment) {
		this._establishment = establishment;
	}
	
	@Override
	public String render() {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("name", this._establishment.getName());
		map.put("id", this._establishment.getId());
		
		JSONObject json = new JSONObject(map);
		
		for(Menu menu : this._establishment.getMenus()) {
			json.append("menus", menu.getId());
		}
		
		return json.toString();
	}

}

function Establishment(id) {
	this._id = id;
	this._name = null;
	this._menuIds = null;

	this._dataFetched = false;
}

Establishment.prototype.fetchData = function(callback) {
	est = this;
	
	$.getJSON('/api/establishment/'+this._id, function(estData) {
		est._name = estData.name;
		
		// TODO menuIds
		this._menuIds = null;
		
		this._menus = null;

		est._dataFetched = true;
	
		if(callback != undefined) {
			callback();
		}
	});
}

Establishment.prototype.ensureDataFetched = function(callback) {
	if(!this._dataFetched) {
		this.fetchData(callback);
	} else {
		if(callback != undefined) {
			callback();
		}
	}
}

Establishment.prototype.getName = function() {
	return this._name;
}

Establishment.prototype.getMenus = function() {
	if(!this._dataFetched) {
		return null;
	}
	
	if(this._menus == null) {		
		var menus = new Array();
		for(var i = 0; i < this._menuIds.length; i++) {
			menus[menus.length] = new Menu(this._menuIds[i]);
		}
		
		this._menus = menus;
	}
	
	return this._menus;
}
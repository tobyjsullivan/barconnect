function Menu(id) {
	this._id = id;
	this._name = null;
	
	this._dataFetched = false;
}

Menu.prototype.fetchData = function(callback) {
	// TODO ajax call to fetch data
	
	this._name = null; // TODO
	
	this._dataFetched = true;
	
	if(callback != undefined) {
		callback();
	}
}

Menu.prototype.ensureDataFetched = function () {
	if(this._dataFetched) {
		if(callback != undefined) {
			callback();
		}
	} else {
		this.fetchData(callback);
	}
}

Menu.prototype.getName = function() {	
	return this._name;
}
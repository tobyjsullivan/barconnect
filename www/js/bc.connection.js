function Connection(token) {
	this._token = token;
	
	this._establishmentId = null;
	this._table = null;
	
	this._dataFetched = false;
}

Connection.prototype.fetchData = function(callback) {
	conn = this;
	
	// TODO Ajax call to fetch data
	$.getJSON('/api/connection/'+this._token, function(connData) {
		conn._establishmentId = connData.establishment;
		conn._table = connData.table;

		conn._dataFetched = true;
	
		if(callback != undefined) {
			callback();
		}
	});
}

Connection.prototype.ensureDataFetched = function(callback) {
	if(this._dataFetched) {
		if(callback != undefined) {
			callback();
		}
	} else {
		this.fetchData(callback);
	}
}

Connection.prototype.getEstablishmentId = function() {
	return this._establishmentId;
}

Connection.prototype.getTable = function() {
	return this._table;
}
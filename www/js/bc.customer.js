function parseConnectionToken() {
	// TODO parse from GET query
	
	var token = "alsjdh98732";
	
	return token;
}

function updateEstablishmentName(connection) {
	connection.ensureDataFetched(function() {
		var est = new Establishment(connection.getEstablishmentId());
		
		est.ensureDataFetched(function() {
			$("#est-name").html(est.getName());
		});
	});
}

function updateTableNumber(connection) {
	connection.ensureDataFetched(function() {
		$('#table-num').html(connection.getTable());
	});
}

function initPage() {
	var token = parseConnectionToken();
	
	var conn = new Connection(token);
	
	updateEstablishmentName(conn);
	updateTableNumber(conn);
}

$(document).ready(initPage);
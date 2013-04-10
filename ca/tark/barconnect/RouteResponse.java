package ca.tark.barconnect;

public class RouteResponse {
	private String _data;
	private int _responseCode;
	
	public RouteResponse(int responseCode, String data) {
		this._data = data;
		this._responseCode = responseCode;
	}
	
	public int getResponseCode() {
		return this._responseCode;
	}
	
	public String getData() {
		return this._data != null ? this._data : "";
	}
}

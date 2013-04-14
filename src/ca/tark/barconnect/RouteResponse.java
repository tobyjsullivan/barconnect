package ca.tark.barconnect;

import java.util.HashMap;
import java.util.Map;

public class RouteResponse {
	private String _data;
	private int _responseCode;
	private Map<String, String> _headers;
	
	public RouteResponse(int responseCode, String data) {
		this(responseCode, data, null);
	}
	
	public RouteResponse(int responseCode, String data, Map<String, String> headers) {
		this._data = data;
		this._responseCode = responseCode;
		this._headers = headers;
	}
	
	protected void setResponseCode(int responseCode) {
		this._responseCode = responseCode;
	}
	
	public int getResponseCode() {
		return this._responseCode;
	}
	
	protected void setHeaders(Map<String,String> headers) {
		this._headers = headers;
	}
	
	public Map<String, String> getHeaders() {
		return this._headers != null ? this._headers : new HashMap<String,String>();
	}
	
	protected void setData(String data) {
		this._data = data;
	}
	
	public String getData() {
		return this._data != null ? this._data : "";
	}
}

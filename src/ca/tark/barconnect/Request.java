package ca.tark.barconnect;

import java.util.HashMap;
import java.util.Map;

import ca.tark.barconnect.utils.RouterUtils;

public class Request {
	private String _path;
	private String _query;
	private String _data;
	private RequestMethods _method;
	
	public Request(String path, String query, String data, RequestMethods method) {
		this._path = path.toLowerCase();
		this._query = query;
		this._data = data;
		this._method = method;
	}
	
	public String getPath() {
		return this._path;
	}
	
	public String[] getSplitPath() {
		return RouterUtils.parsePath(this._path);
	}
	
	public String getQuery() {
		return this._query;
	}
	
	public Map<String,String> getQueryMap() {
		Map<String,String> retVal = new HashMap<String, String>();
		if(this._query == null) {
			// Empty
			return retVal;
		}
		
		String[] pairs = this._query.split("[&]");
		
		for(String curPair : pairs) {
			String[] set = curPair.split("[=]", 2);
			retVal.put(set[0], set[1]);
		}
		
		return retVal;
	}
	
	public String getData() {
		return this._data;
	}
	
	public RequestMethods getMethod() {
		return this._method;
	}
}

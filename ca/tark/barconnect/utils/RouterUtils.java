package ca.tark.barconnect.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ca.tark.barconnect.RequestMethods;

public final class RouterUtils {
	public static String[] parsePath(String path) {
		if(path.startsWith("/")) {
			path = path.substring(1);
		}
		
		return path.split("/");
	}
	
	public static RequestMethods parseMethod(String method) {
		method = method.toUpperCase();
		
		if(method == "GET") {
			return RequestMethods.Get;
		} else if(method == "POST") {
			return RequestMethods.Post;
		} else if(method == "PUT") {
			return RequestMethods.Put;
		} else if(method == "DELETE") {
			return RequestMethods.Delete;
		}
		
		return null;
	}
	
	public static String readData(InputStream reqData, int length) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(reqData));
		
		StringBuilder sb = new StringBuilder(length);
		
		String line;
		try {
			while((line = rd.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
}

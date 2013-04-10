package ca.tark.barconnect.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ca.tark.barconnect.IRoute;
import ca.tark.barconnect.Request;
import ca.tark.barconnect.RouteResponse;
import ca.tark.barconnect.config.Configuration;

public class FileRoute implements IRoute {

	@Override
	public RouteResponse handle(Request request) {
		System.out.println("Handling FILE request...");
		
		String filename = request.getPath();
		if(filename.endsWith("/")) {
			filename += Configuration.read("DefaultFilename");
		}
		
		filename = Configuration.read("DocsPath") + filename.replace('/', File.separatorChar);

		System.out.println("File path: " + filename);
		
		File file = new File(filename);
		
		if(!file.exists()) {
			System.out.println("File does not exist");
			return null;
		}
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			return null;
		}
		
		StringBuilder sb = new StringBuilder((int)file.length());
		
		try {
			char[] buffer = new char[1024];
			int length = 0;
			while((length = fr.read(buffer, 0, buffer.length)) > 0) {
				sb.append(String.valueOf(buffer, 0, length));
			}
			fr.close();
		} catch (IOException e) {
			System.out.println("Error reading file.");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		System.out.println("File found.");
		
		String mimeType = determineMimeType(filename);

		Map<String, String> headers = new HashMap<String, String>();
		if(mimeType != null) {
			headers.put("Content-type", mimeType);
		}
		
		return new RouteResponse(200, sb.toString(), headers);
	}
	
	private static String determineMimeType(String filename) {
		int dot = filename.lastIndexOf('.');
		String ext = filename.substring(dot + 1);
		
		if(ext.equals("css")) {
			return "text/css";
		} else if (ext.equals("html")) {
			return "text/html";
		} else if (ext.equals("js")) {
			return "text/javascript";
		}
		
		return "text/plain";
	}

}

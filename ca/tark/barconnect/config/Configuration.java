package ca.tark.barconnect.config;

public final class Configuration {
	private final static String _docsPath = "/Users/tobyjsullivan/projects/barconnect/www";
	private final static String _defaultFilename = "index.html";
	
	public static String read(String key) {
		if(key.equals("DocsPath")) {
			return Configuration._docsPath;
		} else if(key.equals("DefaultFilename")) {
			return Configuration._defaultFilename;
		}
		
		return null;
	}
}

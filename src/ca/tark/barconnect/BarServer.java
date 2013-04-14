package ca.tark.barconnect;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class BarServer {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		
		System.out.println("Configuring server...");
		
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/", new RequestHandler());
		server.setExecutor(null);
		
		System.out.printf("Server started on port %d.\n", port);
		server.start();
	}
}


package ca.tark.barconnect;

import java.io.IOException;
import java.io.OutputStream;

import ca.tark.barconnect.utils.RouterUtils;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RequestHandler implements HttpHandler {
	public final String METHOD_GET = "GET";
	
	@Override
	public void handle(HttpExchange t) throws IOException {
		System.out.println("Handling request...");
		
		String path = t.getRequestURI().getPath();
		RequestMethods method = RouterUtils.parseMethod(t.getRequestMethod());
		String query = t.getRequestURI().getQuery();
		String data = RouterUtils.readData(t.getRequestBody(), t.getRequestHeaders().size());
		
		Request request = new Request(path, query, data, method);

		System.out.println("Request path: " + request.getPath());
		
		IRoute route = Router.determineRoute(request);
		
		RouteResponse response = null;
		if(route == null) {
			response = new RouteResponse(404, "404: NOT FOUND");
		} else {
			response = route.handle(request);
		}
		
		String respData = response.getData();
		
		t.sendResponseHeaders(response.getResponseCode(), respData.length());
		OutputStream os = t.getResponseBody();
		os.write(respData.getBytes());
		os.close();
	}

}

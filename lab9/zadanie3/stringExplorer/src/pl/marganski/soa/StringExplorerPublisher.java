package pl.marganski.soa;

import javax.xml.ws.Endpoint;

public class StringExplorerPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8000/Explorer/StringExplorer", new StringExplorer());
	}

}

package pl.marganski.soa.webservice;

import javax.xml.ws.Endpoint;

public class HelloWorldWSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/lab9/JAXWSExample/HelloWorld", new HelloWorldImpl());
	}
}

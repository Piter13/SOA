package pl.marganski.soa.webservice.client;

import pl.marganski.soa.webservice.HelloWorld;
import pl.marganski.soa.webservice.HelloWorldImplService;

public class JAXWSClient {
	public static void main(String[] args) {
		HelloWorldImplService helloWorldService = new HelloWorldImplService();
		HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
		System.out.println(helloWorld.helloWorld("Grzegorza"));
	}
}

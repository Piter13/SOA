package pl.marganski.soa.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "pl.marganski.soa.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	public String helloWorld(String name) {
		return "Pozdrowienia od " + name;
	}
}

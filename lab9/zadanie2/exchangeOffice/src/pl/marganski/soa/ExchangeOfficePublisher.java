package pl.marganski.soa;

import javax.xml.ws.Endpoint;

public class ExchangeOfficePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8000/ExchangeOffice/exchanger", new ExchangeOffice());
	}

}

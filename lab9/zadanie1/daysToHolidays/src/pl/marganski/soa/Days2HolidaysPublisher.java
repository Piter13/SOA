package pl.marganski.soa;

import javax.xml.ws.Endpoint;

public class Days2HolidaysPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8000/Counter/ToHolidays", new Days2Holidays());
	}

}
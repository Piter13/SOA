package pl.marganski.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ExchangeOfficeInterface {
	
	@WebMethod
	String getCurrency(String currency);
	
	@WebMethod
	String sellCurrency(String currency, double money);

}
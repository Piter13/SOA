package pl.marganski.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ExchangeOffice implements ExchangeOfficeInterface {
	
	private double USD = 3.62;
    private double EUR = 4.28;
    private double GBP = 4.88;

    @WebMethod
    public String getCurrency(String currency){
    	
    	String statement = "";
    	switch (currency) {
		case "USD":
			statement = "USD currency rate: " + USD;
			break;
		case "EUR":
			statement = "EUR currency rate: " + EUR;
			break;
		case "GBP":
			statement = "GBP currency rate: " + GBP;
			break;
    	}
		System.out.println(statement);
		return statement;
    }

    @WebMethod
    public String sellCurrency(String currency, double money) {
    
        String statement = "";
    	switch (currency) {
		case "USD":
			statement = money + " " + currency + " sold for: " + USD*money + " PLN";
			break;
		case "EUR":
			statement = money + " " + currency + " sold for: " + EUR*money + " PLN";
			break;
		case "GBP":
			statement = money + " " + currency + " sold for: " + GBP*money + " PLN";
			break;
    	}
		System.out.println(statement);
		return statement;
    }

}

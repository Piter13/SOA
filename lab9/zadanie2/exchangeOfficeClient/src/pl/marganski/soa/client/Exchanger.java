package pl.marganski.soa.client;

import pl.marganski.soa.ExchangeOffice;
import pl.marganski.soa.ExchangeOfficeService;

public class Exchanger {

	public static void main(String[] args) {
		ExchangeOfficeService exchangeOfficeService = new ExchangeOfficeService();
		ExchangeOffice exchangeOffice = exchangeOfficeService.getExchangeOfficePort();
		System.out.println(exchangeOffice.getCurrency("USD"));
		System.out.println(exchangeOffice.getCurrency("EUR"));
		System.out.println(exchangeOffice.getCurrency("GBP"));
		System.out.println(exchangeOffice.sellCurrency("EUR", 200));
		System.out.println(exchangeOffice.sellCurrency("GBP", 106.83));
	}

}
package pl.marganski.soa;

import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Days2HolidaysInterface {

	@WebMethod
	public String getDaysToHolidays() throws ParseException;

}

package pl.marganski.soa.client;

import pl.marganski.soa.Days2Holidays;
import pl.marganski.soa.Days2HolidaysService;
import pl.marganski.soa.ParseException_Exception;

public class HolidaysCounterClient {

	public static void main(String[] args) throws ParseException_Exception {
		Days2HolidaysService days2HolidaysService = new Days2HolidaysService();
		Days2Holidays days2Holidays = days2HolidaysService.getDays2HolidaysPort();
		System.out.println(days2Holidays.getDaysToHolidays());
	}

}
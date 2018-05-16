
package pl.marganski.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.marganski.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDaysToHolidays_QNAME = new QName("http://soa.marganski.pl/", "getDaysToHolidays");
    private final static QName _ParseException_QNAME = new QName("http://soa.marganski.pl/", "ParseException");
    private final static QName _GetDaysToHolidaysResponse_QNAME = new QName("http://soa.marganski.pl/", "getDaysToHolidaysResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.marganski.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDaysToHolidays }
     * 
     */
    public GetDaysToHolidays createGetDaysToHolidays() {
        return new GetDaysToHolidays();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link GetDaysToHolidaysResponse }
     * 
     */
    public GetDaysToHolidaysResponse createGetDaysToHolidaysResponse() {
        return new GetDaysToHolidaysResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysToHolidays }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.marganski.pl/", name = "getDaysToHolidays")
    public JAXBElement<GetDaysToHolidays> createGetDaysToHolidays(GetDaysToHolidays value) {
        return new JAXBElement<GetDaysToHolidays>(_GetDaysToHolidays_QNAME, GetDaysToHolidays.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.marganski.pl/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysToHolidaysResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.marganski.pl/", name = "getDaysToHolidaysResponse")
    public JAXBElement<GetDaysToHolidaysResponse> createGetDaysToHolidaysResponse(GetDaysToHolidaysResponse value) {
        return new JAXBElement<GetDaysToHolidaysResponse>(_GetDaysToHolidaysResponse_QNAME, GetDaysToHolidaysResponse.class, null, value);
    }

}

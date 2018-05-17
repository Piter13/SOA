
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

    private final static QName _ExlopreResponse_QNAME = new QName("http://soa.marganski.pl/", "exlopreResponse");
    private final static QName _Exlopre_QNAME = new QName("http://soa.marganski.pl/", "exlopre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.marganski.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExlopreResponse }
     * 
     */
    public ExlopreResponse createExlopreResponse() {
        return new ExlopreResponse();
    }

    /**
     * Create an instance of {@link Exlopre }
     * 
     */
    public Exlopre createExlopre() {
        return new Exlopre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExlopreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.marganski.pl/", name = "exlopreResponse")
    public JAXBElement<ExlopreResponse> createExlopreResponse(ExlopreResponse value) {
        return new JAXBElement<ExlopreResponse>(_ExlopreResponse_QNAME, ExlopreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exlopre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.marganski.pl/", name = "exlopre")
    public JAXBElement<Exlopre> createExlopre(Exlopre value) {
        return new JAXBElement<Exlopre>(_Exlopre_QNAME, Exlopre.class, null, value);
    }

}

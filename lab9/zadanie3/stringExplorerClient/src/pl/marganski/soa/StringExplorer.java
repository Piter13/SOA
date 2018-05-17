
package pl.marganski.soa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StringExplorer", targetNamespace = "http://soa.marganski.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StringExplorer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "exlopre", targetNamespace = "http://soa.marganski.pl/", className = "pl.marganski.soa.Exlopre")
    @ResponseWrapper(localName = "exlopreResponse", targetNamespace = "http://soa.marganski.pl/", className = "pl.marganski.soa.ExlopreResponse")
    @Action(input = "http://soa.marganski.pl/StringExplorer/exlopreRequest", output = "http://soa.marganski.pl/StringExplorer/exlopreResponse")
    public String exlopre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

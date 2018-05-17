package pl.marganski.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface StringExplorerInterface {

	@WebMethod
	public String exlopre(String entry);

}

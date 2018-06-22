package pl.marganski.soa.rest.controllers.auth;

import java.util.Base64;
import java.util.Objects;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

import pl.marganski.soa.jpa.entities.User;

@Singleton
@Startup
public class Authentication {
	
	@PersistenceContext(unitName = "GameApp")
    private EntityManager entityManager;

	public boolean isAuthorized(String authToken) {
		authToken = authToken.replace("Basic", "");
		byte[] decodedBytes = Base64.getDecoder().decode(authToken);
		String decodedString = new String(decodedBytes);
		String []userCredential = decodedString.split(":");
		Query query = entityManager.createNamedQuery("user.specificUserByName");
    	query.setParameter("username", userCredential[0]);
    	try {
    		Object result = query.getSingleResult();
    		User user = (User) result;
    		if (!DigestUtils.sha256Hex(userCredential[1]).equals(user.getPassword()) || Objects.isNull(user)) {
                return false;
            }
    		return true;
    	} catch(NoResultException e) {
    		return false;
    	}
	}
	
}

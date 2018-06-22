package pl.marganski.soa.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.marganski.soa.jpa.entities.dto.MagDTO;

@Interceptor
public class BetterMag {
	
	@PersistenceContext(unitName = "GameApp")
	private EntityManager entityManager;
	
	@AroundInvoke
	  public Object invoke(InvocationContext context) throws Exception {
	    Object param = context.getParameters()[0];

	    if (param instanceof MagDTO) {
	    	MagDTO mag = (MagDTO) param;
	    	Query query = entityManager.createNamedQuery("mag.maxMana");
	        int maxMana = (int) query.getFirstResult();
	        if (mag.getMana() >= maxMana) {
	          mag.setMana(1);
	        }
	    }
	
	    Object result = context.proceed();
	    return result;
	  }

}

package pl.marganski.soa.util;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import pl.marganski.soa.ejb.services.MagService;
import pl.marganski.soa.events.BasicEvent;
import pl.marganski.soa.events.ChangeMagsEvent;
import pl.marganski.soa.jpa.entities.Mag;

@ApplicationScoped
public class BestMags {
	
	@EJB
	MagService magService;

	private Future<Void> future;
	private int bestMagsNumber = 2;
	List<Mag> mags;
	
	public List<Mag> getBestMags() {
		   mags = magService.findBestMags(bestMagsNumber);
		  return mags;
	}

	public void update(@Observes @ChangeMagsEvent BasicEvent event) {
		mags = magService.findBestMags(bestMagsNumber);
		EventBus eventBus = EventBusFactory.getDefault().eventBus();
		eventBus.publish("/notifications", new FacesMessage("", ""));
	}

}

package pl.marganski.soa.util;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import lombok.Delegate;
import pl.marganski.soa.jpa.entities.Mag;

@ViewScoped
@ManagedBean
public class ListBestMags implements Serializable {
	
	@SuppressWarnings("deprecation")
	@Inject
    @Delegate
    BestMags bestMags;

	public List<Mag> getMags() {
		return bestMags.getBestMags();
	}

	public void setMags(BestMags bestMags) {
		this.bestMags = bestMags;
	}
}

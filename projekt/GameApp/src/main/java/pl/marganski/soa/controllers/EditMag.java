package pl.marganski.soa.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pl.marganski.soa.ejb.services.CastleService;
import pl.marganski.soa.ejb.services.MagService;
import pl.marganski.soa.jpa.entities.Castle;
import pl.marganski.soa.jpa.entities.Mag.Element;
import pl.marganski.soa.jpa.entities.Mag.Power;
import pl.marganski.soa.jpa.entities.dto.MagDTO;

@ConversationScoped
@Named
public class EditMag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	MagService magService;

	@EJB
	CastleService castleService;

	@Inject
	Conversation conversation;

	private String elementId;
	private String categoryId;
	private String name;
	private String mana;
	private Power power;
	private Element element;

	@PostConstruct
	public void start() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public List<Castle> getCastles() {
        return castleService.getAllCastles();
    }
    
    public void saveMag() {
        MagDTO magDTO = new MagDTO();
		magDTO.setName(name);
		magDTO.setCastleId(Integer.parseInt(categoryId));
		magDTO.setMana(Integer.parseInt(mana));
		magDTO.setPower(power);
		magDTO.setElement(element);
		if(!Objects.isNull(elementId)) {
			magDTO.setId(Integer.valueOf(elementId));
			magService.updateMag(magDTO);
		} else {
			magService.saveMag(magDTO);
		}
		
		this.elementId = null;
		this.categoryId = null;
		this.name = null;
		this.mana = null;
		this.power = null;
		this.element = null;
		conversation.end();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GameApp/home.xhtml?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void cancel() {
        conversation.end();
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("GameApp/home.xhtml?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public String next() {
    	return "editMag-2.xhtml";
    }
    
    public String forwardToEditElement(String elementId) {

		this.elementId = elementId;
		MagDTO magDTO = magService.getMagDTO(Integer.parseInt(elementId));
		this.categoryId = String.valueOf(magDTO.getCastleId());
		this.name = magDTO.getName();
		this.mana = String.valueOf(magDTO.getMana());
		this.power = magDTO.getPower();
		this.element = magDTO.getElement();
		return "mags/editMag-1.xhtml";
	}

    public String back() {
        return "mags/editMag-1.xhtml";
    }

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		String s = categoryId.substring(categoryId.indexOf("id=")+3);
		s = s.substring(0, s.indexOf(", height"));
		this.categoryId = s.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMana() {
		return mana;
	}

	public void setMana(String mana) {
		this.mana = mana;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

}

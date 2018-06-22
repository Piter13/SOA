package pl.marganski.soa.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.marganski.soa.ejb.services.CastleService;
import pl.marganski.soa.ejb.services.CategoryService;
import pl.marganski.soa.ejb.services.MagService;
import pl.marganski.soa.jpa.entities.Castle;
import pl.marganski.soa.jpa.entities.Category;
import pl.marganski.soa.jpa.entities.Mag.Element;
import pl.marganski.soa.jpa.entities.Mag.Power;
import pl.marganski.soa.jpa.entities.dto.CastleDTO;
import pl.marganski.soa.jpa.entities.dto.MagDTO;
import pl.marganski.soa.util.SecurityUtils;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class JsfController {
	@EJB
	private CastleService castleService;

	@EJB
	private MagService magService;

	@EJB
	private CategoryService categoryService;

	private String elementId;
	private String categoryId;
	private String name;
	private int mana;
	private Element element;
	private Power power;

	private String category;
	private String height;
	private String userId;

	public List<Castle> getCastles() {
		return castleService.getAllCastles();
	}

	public List<Category> getCategories() {
		return categoryService.getAllCategories();
	}

	public void removeMag(String id) {
		magService.removeMag(Integer.parseInt(id));
	}

	public void removeCastle(String id) {
		magService.deleteMagsInCastle(Integer.parseInt(id));
		castleService.removeCastle(Integer.parseInt(id));

	}

	public void addElement() {
		MagDTO magDTO = new MagDTO();
		magDTO.setName(name);
		magDTO.setMana(mana);
		magDTO.setCastleId(Integer.parseInt(categoryId));
		magDTO.setElement(element);
		magDTO.setPower(power);
		if (!Objects.isNull(elementId)) {
			magDTO.setId(Integer.valueOf(elementId));
			magService.updateMag(magDTO);
		} else {
			magService.saveMag(magDTO);
		}

		this.elementId = null;
		this.categoryId = null;
		this.name = null;
		this.element = null;
		this.power = null;

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addCategory() {
		CastleDTO castleDTO = new CastleDTO();
		castleDTO.setCategory(Integer.parseInt(category));
		castleDTO.setHeight(Integer.parseInt(height));
		if (!Objects.isNull(categoryId)) {
			castleDTO.setId(Integer.valueOf(categoryId));
			castleDTO.setUser(Integer.valueOf(userId));
			castleService.updateCastle(castleDTO);
		} else {
			castleDTO.setUser(SecurityUtils.getLoggedUser().get().getId());
			castleService.addCastle(castleDTO);
		}
		this.categoryId = null;
		this.category = null;
		this.height = null;
		this.userId = null;

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void forwardToEditCategory(String categoryId) {
		this.categoryId = categoryId;
		CastleDTO castleDTO = castleService.getCastleDTO(Integer.parseInt(categoryId));
		this.category = String.valueOf(castleDTO.getCategory());
		this.height = String.valueOf(castleDTO.getHeight());
		this.userId = String.valueOf(castleDTO.getUser());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("category.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void forwardToEditElement(String elementId) {
		this.elementId = elementId;
		MagDTO magDTO = magService.getMagDTO(Integer.parseInt(elementId));
		this.categoryId = String.valueOf(magDTO.getCastleId());
		this.name = magDTO.getName();
		this.mana = magDTO.getMana();
		this.element = magDTO.getElement();
		this.power = magDTO.getPower();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("element.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		String s1 = categoryId.substring(categoryId.indexOf("id=") + 3);
		s1 = s1.substring(0, s1.indexOf(", height"));
		this.categoryId = s1.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		String s1 = category.substring(category.indexOf("id=") + 3);
		s1 = s1.substring(0, s1.indexOf(", name"));
		this.category = s1.trim();
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

}

package pl.marganski.soa.jpa.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="CATEGORY")
@XmlRootElement
@EqualsAndHashCode(exclude = {"castles"})
@ToString(exclude = {"castles"})
@NamedQueries({
	@NamedQuery(name="category.specificCategory", query="SELECT c FROM Category c where c.id =:id"),
	@NamedQuery(name="category.allCategories", query="SELECT c FROM Category c"),
}) 
public class Category {
	@Id
    @Column(name = "Category_ID")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Castle> castles;
	
	public Category() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Castle> getCastles() {
		return castles;
	}

	public void setCastles(Set<Castle> castles) {
		this.castles = castles;
	}
	
}

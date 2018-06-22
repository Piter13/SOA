package pl.marganski.soa.jpa.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CASTLE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode(exclude = {"mags", "category"})
@NamedQueries({
	@NamedQuery(name="castle.specificCastle", query="SELECT c FROM Castle c where c.id =:id"),
	@NamedQuery(name="castle.allCastles", query="SELECT c FROM Castle c"),
	@NamedQuery(name="castle.deleteCastle", query="DELETE FROM Castle c WHERE c.id = :id")
}) 
public class Castle {
	@Id
	@Column(name = "Castle_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Castle_height")
	private int height;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "castle")
	@JsonManagedReference
	private Set<Mag> mags;
	
	@ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

	@ManyToOne
    @JoinColumn(name = "category")
	private Category category;

	public Castle() {
	}

	public Castle(int height, User user, Category category) {
		this.height = height;
		this.user = user;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@XmlTransient
	public Set<Mag> getMags() {
		return mags;
	}

	public void setMags(Set<Mag> mags) {
		this.mags = mags;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Castle [id=" + id + ", height=" + height + ", category=" + category + "]";
	}
	
}

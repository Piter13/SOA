package pl.marganski.soa.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "MAG")
@XmlRootElement
 @EqualsAndHashCode(exclude = {"castle"})
@ToString(exclude = {"castle"})
@NamedQueries({
	@NamedQuery(name="mag.specificMag", query="SELECT e FROM Mag e WHERE e.id = :id"),
	@NamedQuery(name="mag.allMags", query="SELECT e FROM Mag e"),
	@NamedQuery(name="mag.allMagsInCastle", query="SELECT e FROM Mag e WHERE e.castle = :castle"),
	@NamedQuery(name="mag.deleteMag", query="DELETE FROM Mag e WHERE e.id = :id"),
	@NamedQuery(name="mag.deleteMagsInCastle", query="DELETE FROM Mag e WHERE e.castle = :castle")
}) 
public class Mag {
	@Id
	@Column(name = "Mag_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Mag_name")
	private String name;

	@Column(name = "Mag_mana")
	private int mana;

	@Column(name = "Mag_element", length=10)
	@Enumerated(EnumType.STRING)
	private Element element;

	@Column(name = "Mag_power", length=10)
	@Enumerated(EnumType.STRING)
	private Power power;

	@ManyToOne
	@JoinColumn(name = "castle")
	@JsonBackReference
	private Castle castle;

	public Mag() {
	}

	public Mag(String name, int mana, Element element, Power power, Castle castle) { 
		this.name = name;
		this.mana = mana;
		this.element = element;
		this.power = power;
		this.castle = castle;
	}

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

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Castle getCastle() {
		return castle;
	}

	public void setCastle(Castle castle) {
		this.castle = castle;
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

	public enum Element {
		Fire, Water, Earth, Air
	};

	public enum Power {
		Magnetize, Polarize, Crush
	};

}
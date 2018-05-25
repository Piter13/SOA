package pl.marganski.soa;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cat {
	
	private int id;
	private String name;
	private String race;
	
	public Cat() {}

	public Cat(int id, String name, String race) {
		this.setId(id);
		this.setName(name);
		this.setRace(race);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
}

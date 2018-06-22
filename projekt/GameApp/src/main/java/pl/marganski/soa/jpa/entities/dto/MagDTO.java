package pl.marganski.soa.jpa.entities.dto;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import pl.marganski.soa.jpa.entities.Mag.Element;
import pl.marganski.soa.jpa.entities.Mag.Power;

@Data
@XmlRootElement
public class MagDTO {
	private Integer id;
	private String name;
	private int mana;
	private Element element;
    private Power power;
    private int castleId;
    
	public MagDTO(String name, int mana, Element element, Power power, int castleId) {
		super();
		this.name = name;
		this.mana = mana;
		this.element = element;
		this.power = power;
		this.castleId = castleId;
	}
	
	public MagDTO() {}
       
}


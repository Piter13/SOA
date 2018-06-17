package pl.marganski.soa.jpa.entities.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class CastleDTO {
	private int id;
	private int height;
	private int category;
	private int user;
}

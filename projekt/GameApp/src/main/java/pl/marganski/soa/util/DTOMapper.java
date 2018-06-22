package pl.marganski.soa.util;

import java.util.Objects;

import pl.marganski.soa.jpa.entities.Castle;
import pl.marganski.soa.jpa.entities.Category;
import pl.marganski.soa.jpa.entities.Mag;
import pl.marganski.soa.jpa.entities.User;
import pl.marganski.soa.jpa.entities.dto.CastleDTO;
import pl.marganski.soa.jpa.entities.dto.MagDTO;

public class DTOMapper {

	public static MagDTO mapMagToMagDTO(Mag mag) {
		MagDTO magDTO = new MagDTO();

		magDTO.setId(mag.getId());
		magDTO.setName(mag.getName());
		magDTO.setMana(mag.getMana());
		magDTO.setElement(mag.getElement());
		magDTO.setPower(mag.getPower());
		magDTO.setCastleId(mag.getCastle().getId());

		return magDTO;
	}

	public static Mag mapMagDTOToMag(MagDTO magDTO) {
		Mag mag = new Mag();
		if(Objects.nonNull(magDTO.getId())) {
			mag.setId(magDTO.getId());
		}
		mag.setName(magDTO.getName());
		mag.setMana(magDTO.getMana());
		mag.setElement(magDTO.getElement());
		mag.setPower(magDTO.getPower());

		Castle castle = null;
		if (Objects.nonNull(magDTO.getCastleId())) {
			castle = new Castle();
			castle.setId(magDTO.getCastleId());
		}

		mag.setCastle(castle);

		return mag;
	}

	public static CastleDTO mapCastleToCastleDTO(Castle castle) {
		CastleDTO castleDTO = new CastleDTO();

		castleDTO.setId(castle.getId());
		castleDTO.setHeight(castle.getHeight());
		castleDTO.setCategory(castle.getCategory().getId());
		castleDTO.setUser(castle.getUser().getId());

		return castleDTO;
	}

	public static Castle mapCastleDTOToCastle(CastleDTO castleDTO) {
		Castle castle = new Castle();

		castle.setId(castleDTO.getId());
		castle.setHeight(castleDTO.getHeight());

		Category category = null;
		if (Objects.nonNull(castleDTO.getCategory())) {
			category = new Category();
			category.setId(castleDTO.getCategory());
		}
		System.out.println(castle.getId());
		User user = null;
		if (Objects.nonNull(castleDTO.getUser())) {
			user = new User();
			user.setId(castleDTO.getUser());
		}

		castle.setCategory(category);
		castle.setUser(user);
		return castle;
	}

}

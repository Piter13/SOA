package pl.marganski.soa.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import pl.marganski.soa.jpa.entities.Castle;
import pl.marganski.soa.jpa.entities.dto.CastleDTO;
import pl.marganski.soa.repositories.CastleRepository;
import pl.marganski.soa.util.DTOMapper;

	@LocalBean
	@Stateless
	@Transactional
	public class CastleService {
		@EJB
		private CastleRepository castleRepository;
		
		public List<CastleDTO> getAllCastlesDTOs() {
			return castleRepository.findAll()
								.stream()
								.map(DTOMapper::mapCastleToCastleDTO)
								.collect(Collectors.toList());
		}
		
		public List<Castle> getAllCastles(){
			return castleRepository.findAll()
					.stream()
					.collect(Collectors.toList());
		}
		
		public CastleDTO getCastleDTO(int id) {
			return castleRepository.findOne(id)
								.map(DTOMapper::mapCastleToCastleDTO)
								.orElse(null);
		}
		
		public void addCastle(CastleDTO castleDTO) {
			castleRepository.save(DTOMapper.mapCastleDTOToCastle(castleDTO));
		}
		
		public void updateCastle(CastleDTO castleDTO) {
			castleRepository.update(DTOMapper.mapCastleDTOToCastle(castleDTO));
		}
		
		public void removeCastle(int id) {
			castleRepository.delete(id);
		}

}

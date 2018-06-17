package pl.marganski.soa.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import pl.marganski.soa.ejb.services.MagService;
import pl.marganski.soa.jpa.entities.dto.MagDTO;
import pl.marganski.soa.repositories.MagRepository;
import pl.marganski.soa.util.DTOMapper;

@LocalBean
@Stateless
@Transactional
public class MagService {
	@EJB
	private MagRepository magRepository;
	
	public List<MagDTO> getAllMagsDTOs() {
		return magRepository.findAll()
							.stream()
							.map(DTOMapper::mapMagToMagDTO)
							.collect(Collectors.toList());
	}
	
	public MagDTO getMagDTO(int id) {
		return magRepository.findOne(id)
							.map(DTOMapper::mapMagToMagDTO)
							.orElse(null);
	}
	
	public void addMag(MagDTO magDTO) {
		magRepository.save(DTOMapper.mapMagDTOToMag(magDTO));
	}
	
	public void updateMag(MagDTO magDTO) {
		magRepository.update(DTOMapper.mapMagDTOToMag(magDTO));
	}
	
	public void removeMag(int id) {
		magRepository.delete(id);
	}
	
	public void deleteMagsInCastle(int castleId) {
		magRepository.deleteMagsInCastle(castleId);
	}
}
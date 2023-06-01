package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceOuvrage;
import projet.ejb.dao.IDaoOuvrage;
import projet.ejb.data.Ouvrage;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceOuvrage implements IServiceOuvrage {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoOuvrage daoOuvrage;

	// Actions

	@Override
	public int inserer(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		
		int id = daoOuvrage.inserer(mapper.map(dtoOuvrage));
		return id;
	}

	@Override
	public void modifier(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		
		daoOuvrage.modifier(mapper.map(dtoOuvrage));
	}

	@Override
	public void supprimer(int idOuvrage) throws ExceptionValidation {
		daoOuvrage.supprimer(idOuvrage);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoOuvrage retrouver(int idOuvrage) {
		return mapper.map(daoOuvrage.retrouver(idOuvrage));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoOuvrage> listerTout() {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage ouvrage : daoOuvrage.listerTout()) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}


	

}

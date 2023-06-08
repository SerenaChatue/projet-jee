package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoAmitie;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAmitie;
import projet.ejb.dao.IDaoAmitie;
import projet.ejb.data.Amitie;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceAmitie implements IServiceAmitie {
	
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAmitie daoAmitie;

	@Override
	public int inserer(DtoAmitie dtoAmitie) throws ExceptionValidation {
		int id = daoAmitie.inserer(mapper.map(dtoAmitie));
		return id;
	}

	@Override
	public void modifier(DtoAmitie dtoAmitie) throws ExceptionValidation {
		daoAmitie.modifier(mapper.map(dtoAmitie));
	}

	@Override
	public void supprimer(int idAmitie) throws ExceptionValidation {
		daoAmitie.supprimer(idAmitie);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAmitie retrouver(int idAmitie) {
		Amitie amitie = daoAmitie.retrouver(idAmitie);
		return mapper.map(amitie);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAmitie> listerTout() {
		List<DtoAmitie> liste = new ArrayList<>();
		for(Amitie amitie : daoAmitie.listerTout()) {
			liste.add(mapper.map(amitie));
		}
		return liste;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAmitie> listerAmis(int idUser) {
		List<DtoAmitie> liste = new ArrayList<>();
		for(Amitie amitie : daoAmitie.listerAmis(idUser)) {
			liste.add(mapper.map(amitie));
		}
		return liste;
	}

}

package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEmprunt;
import projet.ejb.dao.IDaoEmprunt;
import projet.ejb.data.Emprunt;
import projet.ejb.data.Ouvrage;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEmprunt implements IServiceEmprunt {
	
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEmprunt daoEmprunt;

	@Override
	public int inserer(DtoEmprunt dtoEmprunt) throws ExceptionValidation {
		int id = daoEmprunt.inserer(mapper.map(dtoEmprunt));
		return id;
	}

	@Override
	public void modifier(DtoEmprunt dtoEmprunt) throws ExceptionValidation {
		daoEmprunt.modifier(mapper.map(dtoEmprunt));
	}

	@Override
	public void supprimer(int idEmprunt) throws ExceptionValidation {
		daoEmprunt.supprimer(idEmprunt);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEmprunt retrouver(int idEmprunt) {
		Emprunt emprunt = daoEmprunt.retrouver(idEmprunt);
		return mapper.map(emprunt);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoOuvrage> listerOuvragesEmpruntes(int idEmprunteur) {
		List<DtoOuvrage> liste = new ArrayList<>();
		for(Ouvrage ouvrage : daoEmprunt.listerOuvragesEmpruntes(idEmprunteur)) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoOuvrage> listerOuvragesPretes(int idPreteur) {
		List<DtoOuvrage> liste = new ArrayList<>();
		for(Ouvrage ouvrage : daoEmprunt.listerOuvragesPretes(idPreteur)) {
			liste.add(mapper.map(ouvrage));
		}
		return liste;
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEmprunt> listerTout() {
		List<DtoEmprunt> liste = new ArrayList<>();
		for(Emprunt emprunt : daoEmprunt.listerTout()) {
			liste.add(mapper.map(emprunt));
		}
		return liste;
	}

}

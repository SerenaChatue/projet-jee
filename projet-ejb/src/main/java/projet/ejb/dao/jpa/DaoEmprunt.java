package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEmprunt;
import projet.ejb.data.Emprunt;
import projet.ejb.data.Ouvrage;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEmprunt implements IDaoEmprunt {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Emprunt emprunt) {
		em.persist(emprunt);
		em.flush();
		return emprunt.getId();
	}

	@Override
	public void modifier(Emprunt emprunt) {
		em.merge(emprunt);
	}

	@Override
	public void supprimer(int idEmprunt) {
		em.remove(retrouver(idEmprunt));
	}

	@Override
	public Emprunt retrouver(int idEmprunt) {
		return em.find(Emprunt.class, idEmprunt);
	}

	@Override
	public List<Emprunt> listerTout() {
		var jpql = "SELECT e FROM Emprunt e";
		var query = em.createQuery(jpql, Emprunt.class);
		return query.getResultList();
	}

	@Override
	public List<Ouvrage> listerOuvragesEmpruntes(int idEmprunteur) {
		var jpql = "SELECT e.ouvrage FROM Emprunt e WHERE e.emprunteur.id = :idEmprunteur";
		var query = em.createQuery(jpql, Ouvrage.class);
		query.setParameter("idEmprunteur", idEmprunteur);
		return query.getResultList();
	}

	@Override
	public List<Ouvrage> listerOuvragesPretes(int idPreteur) {
		var jpql = "SELECT e.ouvrage FROM Emprunt e WHERE e.preteur.id = :idPreteur";
		var query = em.createQuery(jpql, Ouvrage.class);
		query.setParameter("idPreteur", idPreteur);
		return query.getResultList();
	}

}

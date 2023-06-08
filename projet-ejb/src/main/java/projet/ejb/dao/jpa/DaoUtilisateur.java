package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUtilisateur implements IDaoUtilisateur {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int inserer(Utilisateur utilisateur) {
		em.persist(utilisateur);
		em.flush();
		return utilisateur.getId();
	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public void supprimer(int idUtilisateur) {
		em.remove(retrouver(idUtilisateur));
	}

	@Override
	public Utilisateur retrouver(int idUtilisateur) {
		return em.find(Utilisateur.class, idUtilisateur);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Utilisateur> listerTout() {
		// TODO Auto-generated method stub
		var jpql = "SELECT u FROM Utilisateur u ORDER BY u.nomUtilisateur";
		
		var query = em.createQuery(jpql, Utilisateur.class);
		return query.getResultList();
	}

}

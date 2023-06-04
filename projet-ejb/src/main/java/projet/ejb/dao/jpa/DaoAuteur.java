package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoAuteur;
import projet.ejb.data.Auteur;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAuteur implements IDaoAuteur {
	
	// Champs
	@PersistenceContext
	private EntityManager em;
	

	// Actions
	
	@Override
	public int inserer(Auteur auteur) {
//		auteur.setId( donnees.getProchainIdAuteur() );
//		affecterIdTelephones(auteur);
//		donnees.getMapAuteurs().put( auteur.getId(), auteur );
//		return auteur.getId();
		em.persist(auteur);
		em.flush();
		return auteur.getId();
	}

	@Override
	public void modifier(Auteur auteur) {
//		affecterIdTelephones(auteur);
//		donnees.getMapAuteurs().replace( auteur.getId(), auteur );
		em.merge(auteur);
	}

	@Override
	public void supprimer(int idAuteur) {
		//donnees.getMapAuteurs().remove( idAuteur );
		em.remove(retrouver(idAuteur));
	}

	@Override
	public Auteur retrouver(int idAuteur) {
		//return donnees.getMapAuteurs().get( idAuteur );
		return em.find(Auteur.class,idAuteur);
	}

	@Override
	public List<Auteur> listerTout() {
		//return  trierParNom( new ArrayList<>(donnees.getMapAuteurs().values() ) );
		return em.createQuery("SELECT p FROM Auteur p ORDER BY p.nom",Auteur.class).getResultList();
	}


	

}

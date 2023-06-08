package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEditeur;
import projet.ejb.data.Editeur;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEditeur implements IDaoEditeur {
	
	// Champs
	@PersistenceContext
	private EntityManager em;
	

	// Actions
	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED)
	public int inserer(Editeur editeur) {
//		editeur.setId( donnees.getProchainIdEditeur() );
//		affecterIdTelephones(editeur);
//		donnees.getMapEditeurs().put( editeur.getId(), editeur );
//		return editeur.getId();
		em.persist(editeur);
		em.flush();
		return editeur.getId();
	}

	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED)
	public void modifier(Editeur editeur) {
//		affecterIdTelephones(editeur);
//		donnees.getMapEditeurs().replace( editeur.getId(), editeur );
		em.merge(editeur);
	}

	@Override
	public void supprimer(int idEditeur) {
		//donnees.getMapEditeurs().remove( idEditeur );
		em.remove(retrouver(idEditeur));
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Editeur retrouver(int idEditeur) {
		//return donnees.getMapEditeurs().get( idEditeur );
		return em.find(Editeur.class,idEditeur);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Editeur> listerTout() {
		//return  trierParNom( new ArrayList<>(donnees.getMapEditeurs().values() ) );
		System.out.println("yyyyyyyooooo");
		return em.createQuery("SELECT p FROM Editeur p ORDER BY p.nomEditeur",Editeur.class).getResultList();
	}


	

}

package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "emprunt" )
public class Emprunt {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idemprunt")
	private int id;
	
}

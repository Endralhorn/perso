
package fr.m2i.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Test;

@Repository
@Transactional

public class TestDAO implements IDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Test t){
		
		em.persist(t);
		
	}
	
	

}
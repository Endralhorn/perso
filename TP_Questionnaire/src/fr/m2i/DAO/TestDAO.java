
package fr.m2i.DAO;

import java.util.List;

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

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	

}
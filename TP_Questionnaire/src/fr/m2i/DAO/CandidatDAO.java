package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Candidat;


@Repository
@Transactional
public class CandidatDAO implements ICandidatDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Candidat> findAll() {
		try {
			return this.entityManager.createQuery("from Candidat", Candidat.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Candidat find(Integer id) {
		try {
			return this.entityManager.find(Candidat.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Candidat save(Candidat candidat) {
		try {
			return this.entityManager.merge(candidat);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return candidat;
	}

	@Override
	public void delete(Candidat obj) {
		try {
			this.entityManager.remove(this.entityManager.merge(obj));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Candidat auth(String cleunique) {
		Candidat myCandidat = null;
		try {
			myCandidat =  entityManager.createQuery("FROM Cletest WHERE cleUnique = :cleUnique", Candidat.class)
					.setParameter("cleUnique", cleunique)
					.getSingleResult();
			
		}
		
		catch (Exception e)  {
			
		}
		
		
		
		return myCandidat;
	}

}

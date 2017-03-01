package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Administrateur;
import fr.m2i.validation.WrongUsernameOrPasswordException;

@Repository
@Transactional
public class AdministrateurDAO implements IAdministrateurDAO{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Administrateur> findAll() {
		try {
			return this.entityManager.createQuery("from Personne", Administrateur.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Administrateur find(Integer id) {
		try {
			return this.entityManager.find(Administrateur.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Administrateur save(Administrateur admin) {
		try {
			return this.entityManager.merge(admin);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public void delete(Administrateur admin) {
		try {
			this.entityManager.remove(this.entityManager.merge(admin));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Administrateur auth(String loginAdmin, String passAdmin) throws WrongUsernameOrPasswordException {
		Administrateur myAdmin = null;
		try {
			myAdmin =  entityManager.createQuery("FROM Administrateur WHERE loginAdmin = :user AND passAdmin = :pass " /*"SELECT u FROM Utilisateur u WHERE u.username = :user AND u.password = :pass"*/, Administrateur.class)
					.setParameter("user", loginAdmin)
					.setParameter("pass", passAdmin)
					.getSingleResult();
			
		}
		
		catch (Exception e)  {
			throw new WrongUsernameOrPasswordException();
		}
		
		if (myAdmin == null) 
			throw new WrongUsernameOrPasswordException();
		
		return myAdmin;
	}

}

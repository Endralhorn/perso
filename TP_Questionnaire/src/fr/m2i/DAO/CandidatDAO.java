package fr.m2i.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Candidat;
import fr.m2i.validation.WrongUsernameOrPasswordException;

@Repository
@Transactional
public class CandidatDAO implements ICandidatDAO{

	@Override
	public List<Candidat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidat find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidat save(Candidat obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Candidat obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidat auth(String username, String password) throws WrongUsernameOrPasswordException {
		// TODO Auto-generated method stub
		return null;
	}

}

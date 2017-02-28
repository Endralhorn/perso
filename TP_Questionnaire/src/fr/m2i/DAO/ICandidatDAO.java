package fr.m2i.DAO;

import java.util.List;

import fr.m2i.model.Candidat;

public interface ICandidatDAO extends IDAO<Candidat, Integer> {
	
	public List<Candidat> findAll();
	public Candidat find(Integer id);
	public Candidat save(Candidat obj);
	public void delete(Candidat obj);
	
	public Candidat auth(String cleunique);
	

}

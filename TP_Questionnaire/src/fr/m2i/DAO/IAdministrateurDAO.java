package fr.m2i.DAO;

import java.util.List;

import fr.m2i.model.Administrateur;
import fr.m2i.validation.WrongUsernameOrPasswordException;

public interface IAdministrateurDAO extends IDAO<Administrateur, Integer>
{
	public List<Administrateur> findAll();
	public Administrateur find(Integer id);
	public Administrateur save(Administrateur obj);
	public void delete(Administrateur obj);
	
	public Administrateur auth(String username, String password) throws WrongUsernameOrPasswordException;
}
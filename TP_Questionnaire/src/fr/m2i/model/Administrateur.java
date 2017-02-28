package fr.m2i.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrateur")

public class Administrateur extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="login_admin")
	private String loginAdmin;
	
	@Column(name="pass_admin")
	private String passAdmin;

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getPassAdmin() {
		return passAdmin;
	}

	public void setPassAdmin(String passAdmin) {
		this.passAdmin = passAdmin;
	}
	
	
	

}

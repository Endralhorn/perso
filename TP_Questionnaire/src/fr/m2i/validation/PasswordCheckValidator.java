package fr.m2i.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.m2i.noentity.InscriptionUtilisateur;


public class PasswordCheckValidator implements Validator{

		@Override
		public boolean supports(Class<?> cls) {
			return InscriptionUtilisateur.class.equals(cls);
		}


		@Override
		public void validate(Object obj, Errors e) {
			InscriptionUtilisateur myInscriptionUtilisateur = (InscriptionUtilisateur)obj;

			if (!myInscriptionUtilisateur.getPassAdmin().equals(myInscriptionUtilisateur.getPasswordCheck())) {
				e.rejectValue("password", "pwdcheck", "Les mots de passe ne correspondent pas.");
			}
		}

}

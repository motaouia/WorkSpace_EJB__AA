package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.IBanqueLocal;
import metier.entities.Compte;

@WebService
public class BanqueService {
	
	@EJB
	private IBanqueLocal metier;
	
	@WebMethod
	public void verser(@WebParam(name="cdCompte")Long codeCompte, @WebParam(name="montant")double mt) {
		
		metier.verser(codeCompte, mt);
	}
	
	@WebMethod
	public void retirer(@WebParam(name="cdCompte")Long codeCompte, @WebParam(name="montant")double mt) {
		
		metier.retirer(codeCompte, mt);
	}
	
	@WebMethod
	public void virement(@WebParam(name="cdCompte1")Long codeCompte1, @WebParam(name="cdCompte2")Long codeCompte2,@WebParam(name="montant")double mt) {
		
		metier.virement(codeCompte1, codeCompte2, mt);
	}

	@WebMethod
	public Compte addCompte(@WebParam(name="solde")double solde) {
		return metier.addCompte(new Compte(solde, new Date()));
	}

	@WebMethod
	public Compte getCompte(@WebParam(name="cdCompte")Long codeCompte) {
		return metier.getCompte(codeCompte);
	}
	
	@WebMethod
	public List<Compte> getAllComptes() {
		return metier.getAllComptes();
	}

	@WebMethod
	public void deleteCompte(@WebParam(name="cdCompte")Long codeCompte) {
		metier.deleteCompte(codeCompte);
	}
	
}

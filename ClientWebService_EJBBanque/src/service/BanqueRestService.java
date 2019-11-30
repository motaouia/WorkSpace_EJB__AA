package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.IBanqueLocal;
import metier.entities.Compte;

@Stateless
@Path("/")
public class BanqueRestService {
	
	@EJB
	private IBanqueLocal banqueMetier;
	
	@POST
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte addCompte(Compte compte) {
		return banqueMetier.addCompte(compte);
	}

	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam(value="code")Long codeCompte) {
		return banqueMetier.getCompte(codeCompte);
	}

	@GET
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> getAllComptes() {
		return banqueMetier.getAllComptes();
	}

	@PUT
	@Path("/comptes/verser")
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(@FormParam(value="code")Long codeCompte,
			@FormParam(value="montant")double montant) {
		banqueMetier.verser(codeCompte, montant);
	}

	@PUT
	@Path("/comptes/retirer")
	@Produces(MediaType.APPLICATION_JSON)
	public void retirer(@FormParam(value="code")Long codeCompte,//
/*						*/@FormParam(value="montant")double montant) {
		banqueMetier.retirer(codeCompte, montant);
	}

	@PUT
	@Path("/comptes/virement")
	@Produces(MediaType.APPLICATION_JSON)
	public void virement(@FormParam(value="code1")Long codeCompte1,//
/*			*/@FormParam(value="code2")Long codeCompte2,//
/*			  */@FormParam(value="montant")double montant) {
		banqueMetier.virement(codeCompte1, codeCompte2, montant);
	}
	
	@DELETE
	@Path("/comptes/{code}")
	public void deleteCompte(@PathParam(value="code")Long codeCompte) {
		banqueMetier.deleteCompte(codeCompte);
	}

}
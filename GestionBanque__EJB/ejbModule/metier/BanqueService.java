package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;

//@Stateless(name="BS")
@Stateless
public class BanqueService implements IBanqueLocal, IBanqueRemote {

	@PersistenceContext(name="UP_GestionBanque")
	private EntityManager entityManager;
	
	@Override
	public Compte addCompte(Compte compte) {
		entityManager.persist(compte);
		return compte;
	}

	@Override
	public Compte getCompte(Long codeCompte) {
		Compte compte = entityManager.find(Compte.class, codeCompte);
		if(compte == null) {
			throw new RuntimeException("Le Compte Dont le CodeCompte: "+codeCompte+" est Introuvable");
		}
			
		return compte;
	}

	@Override
	public List<Compte> getAllComptes() {
		Query requestAllComptes = entityManager.createQuery("select c from Compte c");
		return (List<Compte>)requestAllComptes.getResultList();
	}

	@Override
	public void verser(Long codeCompte, double montant) {
		Compte compte = getCompte(codeCompte);
		compte.setSoldeCompte(compte.getSoldeCompte() + montant);
	}

	@Override
	public void retirer(Long codeCompte, double montant) {
		Compte compte = getCompte(codeCompte);
		if(montant <= compte.getSoldeCompte()) {
			compte.setSoldeCompte(compte.getSoldeCompte() - montant);
		}
		
	}

	@Override
	public void virement(Long codeCompte1, Long codeCompte2, double montant) {
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
	}

	@Override
	public void deleteCompte(Long codeCompte) {
		Compte compte = getCompte(codeCompte);
		entityManager.remove(compte);
	}

}
package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Compte;

@Local
public interface IBanqueLocal {

	
	public Compte addCompte(Compte compte);

	public Compte getCompte(Long codeCompte);

	public List<Compte> getAllComptes();

	public void verser(Long codeCompte, double montant);

	public void retirer(Long codeCompte, double montant);

	public void virement(Long codeCompte1, Long codeCompte2, double montant);

	public void deleteCompte(Long codeCompte);
	
	
}

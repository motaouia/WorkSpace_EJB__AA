package clientremote;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import metier.IBanqueRemote;
import metier.entities.Compte;

public class ClientRemote {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			//GestionBanque__EJB/BS!metier.IBanqueRemote
			
			String appNameaa = "";
			String moduleNameaa = "GestionBanque__EJB";
			String beanNameaa = "BanqueService";
			String remoteInterfaceaa = IBanqueRemote.class.getName();
			
			String fullName = "ejb:" + appNameaa + "/" + moduleNameaa +"/" + beanNameaa +"!"+ remoteInterfaceaa;
			
			//Create proxy:
			IBanqueRemote proxy = (IBanqueRemote) context.lookup(fullName);
			
			//add Compte
			//proxy.addCompte(new Compte(9000.80, new Date()));
			
			//System.out.println("Le solde du Compte dont le code Compte : "+ proxy.getCompte(1L).getCodeCompte()+ " est :"+proxy.getCompte(1L).getSoldeCompte());
			
			proxy.verser(1L, 1500.00);
			proxy.retirer(3L, 4000.80);
			
			
			List<Compte> listeAllComptes = proxy.getAllComptes();
			
			for(Compte cp : listeAllComptes) {
				System.out.println("###===###");
				System.out.println("Le solde du Compte dont le code Compte : "+ cp.getCodeCompte()+ " est :"+ cp.getSoldeCompte());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

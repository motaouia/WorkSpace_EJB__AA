package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPTES")
public class Compte implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeCompte;
	@Column(name="SOLDE_COMPTE")
	private double soldeCompte;
	@Column(name="DATE_CREATION")
	private Date dateCreation;
	
	public Compte() {
		super();
	}

	public Compte(double soldeCompte, Date dateCreation) {
		super();
		this.soldeCompte = soldeCompte;
		this.dateCreation = dateCreation;
	}

	public Long getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(Long codeCompte) {
		this.codeCompte = codeCompte;
	}

	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
}
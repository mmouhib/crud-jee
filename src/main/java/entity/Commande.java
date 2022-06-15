package entity;

import java.io.Serializable;

public class Commande implements Serializable {

	int ID_Commande;
	String nom;

	public Commande() {
		super();
	}

	public Commande(String nom) {
		super();
		this.nom = nom;
	}

	public Commande(int ID_Commande, String nom) {
		super();
		this.ID_Commande = ID_Commande;
		this.nom = nom;
	}

	public int getID_Commande() {
		return ID_Commande;
	}

	public void setID_Commande(int ID_Commande) {
		this.ID_Commande = ID_Commande;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Produit{" + "ID_Commande=" + ID_Commande + ", nom='" + nom + '\'' + '}';
	}

}

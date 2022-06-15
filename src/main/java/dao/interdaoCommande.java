package dao;

import java.util.List;
import entity.Commande;

public interface interdaoCommande {
	public void ajouterCommande(Commande c);

	public List<Commande> getAllCommandes();

	public void deleteCommande(int id);

	public Commande updateCommande(Commande c);
}

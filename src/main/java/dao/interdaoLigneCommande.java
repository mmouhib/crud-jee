package dao;

import java.util.List;
import entity.LigneCommande;

public interface interdaoLigneCommande {
	public void ajouterLigneCommande(LigneCommande l);

	public List<LigneCommande> getAllLigneCommandes();

	public void deleteLigneCommande(int id, int id2);

	public LigneCommande updateLigneCommande(LigneCommande l);
}

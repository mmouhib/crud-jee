package dao;

import java.util.List;
import entity.Produit;

public interface interdaoProduit {
	public void ajouterProduit(Produit p);

	public List<Produit> getAllProduits();

	public void deleteProduit(long id);

	public Produit updateProduit(Produit p);
}

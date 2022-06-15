package Model;

import java.util.ArrayList;
import java.util.List;

import dao.impdaoProduit;
import dao.interdaoProduit;
import entity.Produit;

public class modeleproduit {
	private Produit prod;
	private List<Produit> lst = new ArrayList<Produit>();

	private interdaoProduit service = new impdaoProduit();

	public Produit getProd() {
		return prod;

	}

	public void setProduit(Produit prod) {

		this.prod = prod;
	}

	public void ajouter(Produit p) {
		service.ajouterProduit(p);
	}

	public void delete(long id) {
		service.deleteProduit(id);
	}

	public Produit modifier(Produit p) {
		service.updateProduit(p);
		return p;
	}

	public List<Produit> listerProduit() {
		lst = service.getAllProduits();
		return lst;
	}
}

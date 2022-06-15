package Model;

import java.util.ArrayList;
import java.util.List;
import dao.impdaoCommande;
import dao.interdaoCommande;
import entity.Commande;

public class modelecommande {

	private Commande prod;
	private List<Commande> lst = new ArrayList<Commande>();

	private interdaoCommande service = new impdaoCommande();

	public Commande getProd() {
		return prod;
	}

	public void setProduit(Commande prod) {

		this.prod = prod;
	}

	public void ajouter(Commande p) {
		service.ajouterCommande(p);
	}

	public void delete(int id) {
		service.deleteCommande(id);
	}

	public Commande modifier(Commande p) {
		service.updateCommande(p);
		return p;
	}

	public List<Commande> listerCommande() {
		lst = service.getAllCommandes();
		return lst;
	}

}

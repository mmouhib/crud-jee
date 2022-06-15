package Model;

import java.util.ArrayList;
import java.util.List;
import dao.impdaoLigneCommande;
import dao.interdaoLigneCommande;
import entity.LigneCommande;

public class modelelignecommande {

	private LigneCommande prod;
	private List<LigneCommande> lst = new ArrayList<LigneCommande>();

	private interdaoLigneCommande service = new impdaoLigneCommande();

	public LigneCommande getProd() {
		return prod;
	}

	public void setProduit(LigneCommande prod) {

		this.prod = prod;
	}

	public void ajouter(LigneCommande p) {
		service.ajouterLigneCommande(p);
	}

	public void delete(int id, int id2) {
		service.deleteLigneCommande(id, id2);
	}

	public LigneCommande modifier(LigneCommande p) {
		service.updateLigneCommande(p);
		return p;
	}

	public List<LigneCommande> listerLigneCommande() {
		lst = service.getAllLigneCommandes();
		return lst;
	}

}

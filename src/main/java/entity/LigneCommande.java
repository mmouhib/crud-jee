package entity;

import java.io.Serializable;

public class LigneCommande implements Serializable {
    int ID_PRODUIT, id_commande, qte_commande;

    public LigneCommande(int ID_PRODUIT, int id_commande, int qte_commande) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.id_commande = id_commande;
        this.qte_commande = qte_commande;
    }

    public int getID_PRODUIT() {
        return ID_PRODUIT;
    }

    public void setID_PRODUIT(int ID_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getQte_commande() {
        return qte_commande;
    }

    public void setQte_commande(int qte_commande) {
        this.qte_commande = qte_commande;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Produit{" +
                "ID_PRODUIT=" + ID_PRODUIT +
                ", id_commande=" + id_commande +
                ", qte_commande=" + qte_commande +
                '}';
    }
}
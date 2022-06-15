package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import entity.LigneCommande;
import utinitaire.singletonConnection;

public class impdaoLigneCommande implements interdaoLigneCommande {
	Connection conn = (Connection) singletonConnection.getConnection();

	public void ajouterLigneCommande(LigneCommande p) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into ligne_commande VALUES(?,?,?)");
			ps.setInt(1, p.getID_PRODUIT());
			ps.setInt(2, p.getId_commande());
			ps.setInt(3, p.getQte_commande());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<LigneCommande> getAllLigneCommandes() {
		List<LigneCommande> lst = new ArrayList<LigneCommande>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ligne_commande");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LigneCommande p = new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				lst.add(p);
			}
		} catch (SQLException e) {
			return null;
		}
		return lst;
	}

	public LigneCommande updateLigneCommande(LigneCommande p) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE ligne_commande SET qte_commande=? WHERE ID_PRODUIT=? and id_commande=?");
			ps.setInt(1, p.getQte_commande());
			ps.setInt(2, p.getID_PRODUIT());
			ps.setInt(3, p.getId_commande());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void deleteLigneCommande(int id, int id2) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM ligne_commande WHERE ID_PRODUIT=? and id_commande=?");
			ps.setInt(1, id);
			ps.setInt(2, id2);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

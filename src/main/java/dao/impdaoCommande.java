package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import entity.Commande;
import utinitaire.singletonConnection;

public class impdaoCommande implements interdaoCommande {
	Connection conn = (Connection) singletonConnection.getConnection();

	public void ajouterCommande(Commande c) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO commande(nom) VALUES(?)");
			ps.setString(1, c.getNom());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Commande> getAllCommandes() {
		List<Commande> lst = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from commande");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Commande c = new Commande();
				c.setID_Commande(rs.getInt(1));
				c.setNom(rs.getString(2));
				lst.add(c);
			}
		} catch (SQLException e) {
			return null;
		}
		return lst;
	}

	public Commande updateCommande(Commande c) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE commande SET nom=? WHERE ID_Commande=?");
			ps.setString(1, c.getNom());
			ps.setInt(2, c.getID_Commande());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void deleteCommande(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM commande WHERE ID_Commande = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

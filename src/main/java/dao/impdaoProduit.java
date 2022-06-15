package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import entity.Produit;

import utinitaire.singletonConnection;

public class impdaoProduit implements interdaoProduit {
	Connection conn = (Connection) singletonConnection.getConnection();

	public void ajouterProduit(Produit p) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUITS(NOM_PRODUIT,PRIX) VALUES(?,?)");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produit> getAllProduits() {
		List<Produit> lst = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from produits");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setIdProduit(rs.getLong(1));
				p.setNomProduit(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				lst.add(p);
			}
		} catch (SQLException e) {
			return null;
		}
		return lst;
	}

	public Produit updateProduit(Produit p) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE PRODUITS SET NOM_PRODUIT=?,PRIX=? WHERE ID_PRODUIT=?");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix());
			ps.setLong(3, p.getIdProduit());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void deleteProduit(long id) {
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM PRODUITS WHERE ID_PRODUIT = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package utinitaire;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import utinitaire.singletonConnection;
import dao.impdaoLigneCommande;
import entity.LigneCommande;

public class test {
	public static void main(String[] args) {

		Connection mycon = singletonConnection.getConnection();
		LigneCommande l = new LigneCommande(2, 2, 1000);

		impdaoLigneCommande dao = new impdaoLigneCommande();

		dao.deleteLigneCommande(2, 2);

		System.out.print(dao.getAllLigneCommandes());

	}
}

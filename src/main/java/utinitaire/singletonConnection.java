package utinitaire;

import java.sql.Connection;
import java.sql.DriverManager;

public class singletonConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdproduits", "root", "");
			System.out.println("conn établie");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}

<%@ page
	import="java.util.*,entity.Produit,entity.Commande,entity.LigneCommande,Model.modeleproduit,Model.modelecommande"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: flex;
	align-items: center;
	justify-content: space-around;
	flex-direction: row;
}

.produit, .commande, .ligne-commande {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	height: 95vh;
	width: 30vw;
	border: 3px solid #55608e;
	border-radius: 10px;
}

a {
	text-decoration: none;
}

a:hover {
	color: red;
}

* {
	font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
}

form {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	gap: 20px;
}

table {
	border: 1px solid #55608e;
	border-radius: 2%;
	overflow: hidden;
}

.tab-header {
	padding: 5px;
	background-color: #55608e;
	color: white;
	background-color: #55608e;
}
</style>
</head>
<body>
	<div class="produit">
		<h1>Gestion des produit</h1>
		<a href="./list">lister produits</a>
		<form method="post" action="./ajout">
			<label for="nom">Nom Produit :</label> <input type="text" name="nom"
				id="nom" /> <label for="prix">Prix Produit:</label> <input
				type="text" name="prix" id="prix" /> <input type="submit"
				value="ajouter" />
		</form>
		<%
		List<Produit> lstprod = new ArrayList<Produit>();
		lstprod = (ArrayList<Produit>) request.getAttribute("lstprod");

		if (lstprod != null) {
		%>
		<table>
			<tr class="tab-header">
				<th>Code Produit</th>
				<th>Nom Produit</th>
				<th>Prix Produit</th>
				<th>action</th>
			</tr>
			<%
			for (Produit p : lstprod) {
			%>
			<tr>
				<td><%=p.getIdProduit()%></td>
				<td><%=p.getNomProduit()%></td>
				<td><%=p.getPrix()%></td>
				<td><a href="./delete?id=<%=p.getIdProduit()%>">Supprimer</a></td>
			</tr>
			<%
			}
			}
			%>
		</table>

		<div class="container">
			<div class="card">
				<div class="card-header">Modification des Produits</div>
				<div class="card-body">
					<form action="./update" method="post">
						<div class="form-group">
							<label class="control-label">ID Produit :</label> <input
								type="text" name="id" class="form-control" />
						</div>
						<div class="form-group">
							<label class="control-label">Nom Produit :</label> <input
								type="text" name="nom" class="form-control" />
						</div>
						<div class="form-group">
							<label class="control-label">Prix :</label> <input type="text"
								name="prix" class="form-control" />
						</div>
						<div>
							<button type="submit" class="btn btn-primary">Modifier</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="commande">
		<h1>Gestion des produit</h1>
		<a href="./listcomm">lister commandes</a>
		<form method="post" action="./ajoutcomm">
			<label for="nom">Nom Commande :</label> <input type="text" name="nom"
				id="nom" /> <input type="submit" value="ajouter" />
		</form>
		<%
		List<Commande> lstcomm = new ArrayList<Commande>();
		lstcomm = (ArrayList<Commande>) request.getAttribute("lstcomm");
		if (lstcomm != null) {
		%>
		<table>
			<tr class="tab-header">
				<th>Code Commande</th>
				<th>Nom Commande</th>
				<th>action</th>
			</tr>
			<%
			for (Commande c : lstcomm) {
			%>
			<tr>
				<td><%=c.getID_Commande()%></td>
				<td><%=c.getNom()%></td>
				<td><a href="./deletecomm?id=<%=c.getID_Commande()%>">Supprimer</a></td>

			</tr>
			<%
			}
			}
			%>
		</table>

		<div class="container">
			<div class="card">
				<div class="card-header">Modification des Commandes</div>
				<div class="card-body">
					<form action="./updatecomm" method="post">
						<div class="form-group">
							<label class="control-label">ID Commande :</label> <input
								type="text" name="id" class="form-control" />
						</div>
						<div class="form-group">
							<label class="control-label">Nom Commande :</label> <input
								type="text" name="nom" class="form-control" />
						</div>

						<div>
							<button type="submit" class="btn btn-primary">Modifier</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>






	<div class="ligne-commande">
		<h1>Gestion des Ligne commandes</h1>
		<a href="./listlig">lister Ligne commandes</a>
		<form method="post" action="./ajoutlig">
			<%
			modelecommande modCommande = new modelecommande();
			modeleproduit modProduit = new modeleproduit();

			List<Produit> idprod = modProduit.listerProduit();
			List<Commande> idcomm = modCommande.listerCommande();
			if ((idprod != null) && (idcomm != null)) {
			%>


			<label for="nom">Id Commande :</label> <select id="idscomms"
				name="idscomms">
				<%
				for (Commande p : idcomm) {
				%>
				<option value="<%=p.getID_Commande()%>"><%=p.getID_Commande() + "-" + p.getNom()%></option>
				<%
				}
				}
				%>
			</select> <label for="nom">Id Produit :</label> <select id="idsprods"
				name="idsprods">
				<%
				for (Produit p : idprod) {
				%>
				<option value="<%=p.getIdProduit()%>"><%=p.getIdProduit() + "-" + p.getNomProduit()%></option>
				<%
				}
				%>
			</select> <label for="nom">qte :</label> <input type="text" name="qte"
				id="qte" /> <input type="submit" value="ajouter" />
		</form>
		<%
		List<LigneCommande> lstligcomm = new ArrayList<LigneCommande>();
		lstligcomm = (ArrayList<LigneCommande>) request.getAttribute("lstligcomm");
		if (lstligcomm != null) {
		%>
		<table>
			<tr class="tab-header">
				<th>Code Produit</th>
				<th>Code Commande</th>
				<th>qte</th>
				<th>action</th>
			</tr>
			<%
			for (LigneCommande x : lstligcomm) {
			%>
			<tr>
				<td><%=x.getID_PRODUIT()%></td>
				<td><%=x.getId_commande()%></td>
				<td><%=x.getQte_commande()%></td>
				<td><a
					href="./deletelig?id=<%=x.getID_PRODUIT()%>-<%=x.getId_commande()%>">Supprimer</a></td>
			</tr>
			<%
			}
			}
			%>
		</table>

		<div class="container">
			<div class="card">
				<div class="card-header">Modification des Lignes commande</div>
				<div class="card-body">
					<form action="./updatelig" method="post">
						<div class="form-group">
							<label class="control-label">ID Commande :</label> <input
								type="text" name="idp" class="form-control" />
						</div>
						<div class="form-group">
							<label class="control-label">Nom Commande :</label> <input
								type="text" name="idc" class="form-control" />
						</div>

						<div class="form-group">
							<label class="control-label">qte :</label> <input type="text"
								name="qte" class="form-control" />
						</div>

						<div>
							<button type="submit" class="btn btn-primary">Modifier</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
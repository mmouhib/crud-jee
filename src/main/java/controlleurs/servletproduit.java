package controlleurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.*;
import Model.modeleproduit;
import Model.modelecommande;
import Model.modelelignecommande;

@WebServlet(urlPatterns = { "/ajout", "/list", "/update", "/delete", "/ajoutcomm", "/listcomm", "/updatecomm",
		"/deletecomm", "/ajoutlig", "/listlig", "/updatelig", "/deletelig" })
public class servletproduit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private modeleproduit modProduit = new modeleproduit();
	private modelecommande modCommande = new modelecommande();
	private modelelignecommande modLigneCommande = new modelelignecommande();

	public servletproduit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		if (path.equals("/ajout")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			modProduit.ajouter(new Produit(nom, prix));
			response.sendRedirect("GestionProduit.jsp");
		}

		else if (path.equals("/list")) {
			request.setAttribute("lstprod", modProduit.listerProduit());
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/update")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Produit p = new Produit();
			p.setIdProduit(id);
			p.setNomProduit(nom);
			p.setPrix(prix);
			modProduit.modifier(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			modProduit.delete(id);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		// ----------------------------------------------------------------------------------------------------

		else if (path.equals("/ajoutcomm")) {
			String nom = request.getParameter("nom");
			modCommande.ajouter(new Commande(nom));
			response.sendRedirect("GestionProduit.jsp");
		}

		else if (path.equals("/listcomm")) {
			request.setAttribute("lstcomm", modCommande.listerCommande());
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/updatecomm")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			Commande c = new Commande(id, nom);
			modCommande.modifier(c);
			request.setAttribute("commande", c);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/deletecomm")) {
			int id = Integer.parseInt(request.getParameter("id"));
			modCommande.delete(id);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		// ----------------------------------------------------------------------------------------------------

		else if (path.equals("/ajoutlig")) {
			int idp = Integer.parseInt(request.getParameter("idsprods"));
			int idc = Integer.parseInt(request.getParameter("idscomms"));
			int qte = Integer.parseInt(request.getParameter("qte"));
			System.out.println(idp + idc + qte);
			modLigneCommande.ajouter(new LigneCommande(idp, idc, qte));
			response.sendRedirect("GestionProduit.jsp");
		}

		else if (path.equals("/listlig")) {
			request.setAttribute("lstligcomm", modLigneCommande.listerLigneCommande());
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/updatelig")) {
			int idp = Integer.parseInt(request.getParameter("idp"));
			int idc = Integer.parseInt(request.getParameter("idc"));
			int qte = Integer.parseInt(request.getParameter("qte"));

			LigneCommande c = new LigneCommande(idp, idc, qte);
			modLigneCommande.modifier(c);
			request.setAttribute("lignecommande", c);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

		else if (path.equals("/deletelig")) {

			String param = request.getParameter("id");
			String[] params = param.split("-");

			int id = Integer.parseInt(params[0]);
			int id2 = Integer.parseInt(params[1]);

			modLigneCommande.delete(id, id2);
			request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

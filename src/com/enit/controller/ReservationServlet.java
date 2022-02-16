package com.enit.controller;

import java.io.IOException;

import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enit.MyExceptions.PlusDePlaceException;
import com.enit.MyExceptions.SoldeInsuffisantException;
import com.enit.MyExceptions.SoldeNegatifException;
import com.enit.MyExceptions.UserNotFoundException;
import com.enit.entities.*;
import com.enit.service.Cinema;
import com.enit.service.Utilisateur;

@WebServlet(name = "ywt", urlPatterns = { "/Reservation" })
public class ReservationServlet extends HttpServlet {
	ServletContext context;
	@EJB
	private Cinema cinema;
	@EJB
	private Utilisateur utilisateur;

	// @EJB private ILocalEnseignant metierEnseignant;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		Set<Compte> ListeCompte = utilisateur.getAllCompte();
		// List<Cours> listeCours=metierCours.tousLesCours();

		context.setAttribute("ListeCompte", ListeCompte);
		// context.setAttribute("listeEnseignants", listeEnseignants);

		// request.getRequestDispatcher("listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Reservation.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		// Set<Salle> ListeSalle = cinema.listSalle();

		String action = request.getParameter("action");

		if (action.equals("ajouter"))

		{
			String nom = request.getParameter("nom");
			String password = request.getParameter("password");

			Integer idseance = Integer.parseInt(request.getParameter("idseance"));

			Seance s = cinema.findSeance(idseance);

			try {

				utilisateur.init(nom, password);
				cinema.reserve(s, utilisateur);

			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PlusDePlaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SoldeInsuffisantException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SoldeNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Set<Compte> ListeCompte = utilisateur.getAllCompte();

			// context.setAttribute("Reservation", Reservation);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Reservation.jsp").forward(request, response);
	}
}

package com.enit.controller;

import java.io.IOException;


import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.enit.entities.Salle;

import com.enit.entities.Film;
import com.enit.service.Cinema;

@WebServlet(name = "csio", urlPatterns = { "/salle" })
public class SalleServlet extends HttpServlet {
	ServletContext context;
	@EJB
	private Cinema cinema;
	// @EJB private ILocalEnseignant metierEnseignant;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		Set<Salle> ListeSalle = cinema.listSalle();
		// List<Cours> listeCours=metierCours.tousLesCours();

		context.setAttribute("listeSalle", ListeSalle);
		// context.setAttribute("listeEnseignants", listeEnseignants);

		// request.getRequestDispatcher("listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Films.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		// Set<Salle> ListeSalle = cinema.listSalle();

		String action = request.getParameter("action");

		if (action.equals("ajouter"))

		{
			Integer cap = Integer.parseInt(request.getParameter("capacite"));
			String nom = request.getParameter("nom");
			String adress = request.getParameter("adress");

			cinema.AjouterSalle(nom, adress, cap);
			;
			// request.setAttribute("beanCours", cours);
			Set<Salle> ListeSalle = cinema.listSalle();

			context.setAttribute("listeSalle", ListeSalle);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Films.jsp").forward(request, response);
	}
}

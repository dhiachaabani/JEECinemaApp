package com.enit.controller;

import java.io.IOException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.enit.entities.*;
import com.enit.service.Cinema;

@WebServlet(name = "ou", urlPatterns = { "/Seance" })
public class SeanceServlet extends HttpServlet {
	ServletContext context;
	@EJB
	private Cinema cinema;
	// @EJB private ILocalEnseignant metierEnseignant;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		Set<Seance> ListeSeance = cinema.getAllSeance();
		// List<Cours> listeCours=metierCours.tousLesCours();

		context.setAttribute("ListeSeance", ListeSeance);
		// context.setAttribute("listeEnseignants", listeEnseignants);

		// request.getRequestDispatcher("listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Salleprog.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		// Set<Salle> ListeSalle = cinema.listSalle();

		String action = request.getParameter("action");

		if (action.equals("ajouter"))

		{
			Integer idsalle = Integer.parseInt(request.getParameter("idsalle"));
			String horaire = request.getParameter("horaire");
			Float tarif = Float.parseFloat(request.getParameter("tarif"));
			cinema.AjouterSeance(horaire, tarif, idsalle);
			
			Set<Seance> ListeSeance = cinema.getAllSeance();

			context.setAttribute("ListeSeance", ListeSeance);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Salleprog.jsp").forward(request, response);
	}
}

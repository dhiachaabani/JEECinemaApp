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
import com.enit.entities.SalleProg;
import com.enit.entities.Film;
import com.enit.service.Cinema;

@WebServlet(name = "o", urlPatterns = { "/Salleprog" })
public class SalleProgServlet extends HttpServlet {
	ServletContext context;
	@EJB
	private Cinema cinema;
	// @EJB private ILocalEnseignant metierEnseignant;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		Set<SalleProg> ListeSalleProg = cinema.getAllSalleProg();
		// List<Cours> listeCours=metierCours.tousLesCours();

		context.setAttribute("ListeSalleProg", ListeSalleProg);
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
			Integer idfilm = Integer.parseInt(request.getParameter("idfilm"));
			Integer idsalle = Integer.parseInt(request.getParameter("idsalle"));

			cinema.AjouterSalleProg(idfilm, idsalle);
			;
			// request.setAttribute("beanCours", cours);
			Set<SalleProg> ListeSalleProg = cinema.getAllSalleProg();

			context.setAttribute("ListeSalleProg", ListeSalleProg);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Salleprog.jsp").forward(request, response);
	}
}

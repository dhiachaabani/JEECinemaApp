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

import com.enit.entities.Film;
import com.enit.service.Cinema;

@WebServlet(name = "csi", urlPatterns = { "/film" })
public class FilmServlet extends HttpServlet {
	ServletContext context;
	@EJB
	private Cinema cinema;
	// @EJB private ILocalEnseignant metierEnseignant;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		Set<Film> ListeFilms = cinema.list();
		// List<Cours> listeCours=metierCours.tousLesCours();

		context.setAttribute("listeFilms", ListeFilms);
		// context.setAttribute("listeEnseignants", listeEnseignants);

		// request.getRequestDispatcher("listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Films.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		context = request.getSession().getServletContext();

		// Set<Film> ListeFilms = cinema.list();

		String action = request.getParameter("action");

		if (action.equals("ajouter"))

		{
			// Integer idCours= Integer.parseInt(request.getParameter("id"));
			String label = request.getParameter("nom");

			cinema.createFilm(label);
			// request.setAttribute("beanCours", cours);
			Set<Film> listeFilms = cinema.list();

			context.setAttribute("listeFilms", listeFilms);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Films.jsp").forward(request, response);
	}
}

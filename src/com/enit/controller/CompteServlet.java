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

import org.apache.taglibs.standard.tag.common.core.Util;

import com.enit.entities.*;
import com.enit.service.Cinema;
import com.enit.service.Utilisateur;

@WebServlet(name = "yt", urlPatterns = { "/Compte" })
public class CompteServlet extends HttpServlet {
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
		context.getRequestDispatcher("/Comptes.jsp").forward(request, response);
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

			Float solde = Float.parseFloat(request.getParameter("solde"));
			utilisateur.createCompte(nom, password, solde);
			Set<Compte> ListeCompte = utilisateur.getAllCompte();

			context.setAttribute("ListeCompte", ListeCompte);
			// context.setAttribute("listeEnseignants", listeEnseignants);
		}

		// request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
		context.getRequestDispatcher("/Comptes.jsp").forward(request, response);
	}
}

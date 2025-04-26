package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao; 
	
	@RequestMapping(path= { "home.do", "/" })
	private String goHome(Model model) {
		return "home"; 
	}
	@RequestMapping(path= { "getFilm.do" })
	private String lookupFilm(Model model, @RequestParam("filmId") int filmId) {
		Film film = filmDao.findFilmById(filmId);
		model.addAttribute("film", film);
		return "FilmResults"; 
	}
	@RequestMapping(path= { "addFilm.do" })
	private String addFilm(Model model,  Film film) {
		Film makeFilm = filmDao.addFilm(film);
		model.addAttribute("film", makeFilm);
		return "FilmResults"; 
	}
	
	@RequestMapping(path= { "updatingFilm.do" })
	private String updatingFilm(Model model, Film film, @RequestParam("filmId") int filmId) {
		Film updateFilm = filmDao.updatingFilm(film);
		model.addAttribute("film", updateFilm);
		return "FilmResults"; 
}
}
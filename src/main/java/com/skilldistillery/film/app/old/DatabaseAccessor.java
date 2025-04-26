package com.skilldistillery.film.app.old;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;


public interface DatabaseAccessor {
 Film findFilmById(int filmId);
 Actor findActorById(int actorId);
 List<Actor> findActorsByFilmId(int filmId);
 List<Film> findFilmByKeyword(String keyword);
 String findLanguageById(int languageId);
 Film addFilm(Film newFilm); 
 Film updatingFilm(Film updatingFilm);
 void deleteFilm(Film fimToDelete);
}

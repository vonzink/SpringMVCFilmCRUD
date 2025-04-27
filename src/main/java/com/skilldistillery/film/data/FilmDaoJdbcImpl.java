package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static String USER = "student";
	private static String PASS = "student";
	private Film film;	

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		film = null;
		String sql = "SELECT * FROM film WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film(rs.getInt("id"), 
						rs.getString("title"), 
						rs.getString("description"),
						rs.getInt("release_year"), 
						rs.getInt("language_id"), 
						findLanguageById(rs.getInt("language_id")),
						rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), 
						rs.getInt("length"), 
						rs.getDouble("replacement_cost"),
						rs.getString("rating"), 
						rs.getString("special_features"));

				List<Actor> actors = findActorsByFilmId(filmId);
				film.setActors(actors);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor(rs.getInt("id"), 
							rs.getString("first_name"), 
							rs.getString("last_name"));

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT * FROM actor JOIN film_actor " + "ON actor.id = film_actor.actor_id "
				+ "WHERE film_actor.film_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), 
								rs.getString("first_name"), 
								rs.getString("last_name"));
				
				actors.add(actor);
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

@Override
public List<Film> findFilmByKeyword(String keyword) {
	List<Film> films = new ArrayList<>(); 
	String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
	
	try {
		 Connection conn = DriverManager.getConnection(URL, USER, PASS);
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 stmt.setString(1, "%" + keyword + "%");
		 stmt.setString(2, "%" + keyword + "%");
		 ResultSet rs = stmt.executeQuery();
		    		    
			
		    while (rs.next()) {
		    	film = new Film(
		    	rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getInt("language_id"),
                findLanguageById(rs.getInt("language_id")),
                rs.getInt("rental_duration"),
                rs.getDouble("rental_rate"),
                rs.getInt("length"),
                rs.getDouble("replacement_cost"),
                rs.getString("rating"),
                rs.getString("special_features")); 
		    	
		    	List<Actor> actors = findActorsByFilmId(film.getId()); 
	            film.setActors(actors);

	            films.add(film);
	
	        }
		    conn.close();
		    stmt.close();
		    rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	return films;
	
	}
@Override
	public String findLanguageById(int languageId) {
		String language = null;
		String sql = "SELECT name FROM language WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, languageId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				language = rs.getString("name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return language;
	}

//
@Override
public Film addFilm(Film film) {
    String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pst.setString(1, film.getTitle());
        pst.setString(2, film.getDescription());
        pst.setInt(3, film.getYear());
        pst.setInt(4, film.getLanguageId()); 
        pst.setInt(5, film.getRentalDuration()); 
        pst.setDouble(6, film.getRentalRate());
        pst.setInt(7, film.getLength());
        pst.setDouble(8, film.getReplacementCost());
        pst.setString(9, film.getRating()); 

        if (pst.executeUpdate() == 1) {
            try (ResultSet keys = pst.getGeneratedKeys()) {
                if (keys.next()) {
                    film.setId(keys.getInt(1));
                }
            }
            return film;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; 
}

@Override
public Film updateFilm(Film film) {
	 String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?" + 
			 	", rental_rate = ?, length = ?, replacement_cost = ?, rating = ?"
	 		+ " WHERE id = ?";
			try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
					PreparedStatement pst = conn.prepareStatement(sql)) {	 
				
				pst.setString(1, film.getTitle());
		        pst.setString(2, film.getDescription());
		        pst.setInt(3, film.getYear());
		        pst.setInt(4, film.getLanguageId()); 
		        pst.setInt(5, film.getRentalDuration()); 
		        pst.setDouble(6, film.getRentalRate());
		        pst.setInt(7, film.getLength());
		        pst.setDouble(8, film.getReplacementCost());
		        pst.setString(9, film.getRating()); 
		        pst.setInt(10, film.getId());
				pst.executeUpdate();
			 return film;
			 
		    } catch (SQLException e) { e.printStackTrace(); }
		    return film;
		  }

@Override
public void deleteFilm(Film film) {
		 String sql = "DELETE FROM film WHERE id = ?";
				try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
						PreparedStatement pst = conn.prepareStatement(sql)) {	 
				
						pst.setInt(1, film.getId());
						pst.executeUpdate();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
		}

	


package com.skilldistillery.film.app.old;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private final String RESET = "\u001B[0m";
	private final String GREEN_TEXT = "\u001B[32m";
	private final String YELLOW_TEXT = "\u001B[33m";
    private final String RED_TEXT = "\u001B[31m";
    private final String BLUE_TEXT = "\u001B[34m";
    private final String PURPLE_TEXT = "\u001B[35m";
    private final String CYAN_TEXT = "\u001B[36m";
    
    private final String BOLD = "\u001B[1m";
    private final String ITALIC = "\u001B[3m";

	private Film film;
	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner input = new Scanner(System.in);

	
	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		startUserInterface();

	}

	private void startUserInterface() {
		boolean running = true;
		while (running) {

			System.out.println(GREEN_TEXT);
			System.out.println("╔═══════════════════════════════════════╗");
			System.out.println("║        FILM QUERY MAIN MENU           ║");
			System.out.println("╠═══════════════════════════════════════╣");
			System.out.println("║1. Look up a film by it's id           ║");
			System.out.println("║2. Look up a film by a search keyword  ║");
			System.out.println("║3. Add a Film	                        ║");
			System.out.println("║4. Update a Film                       ║");
			System.out.println("║5. Delete a Film                       ║");
			System.out.println("║6. Exit the application                ║");
			System.out.println("╚═══════════════════════════════════════╝");
			System.out.println();
			System.out.print(YELLOW_TEXT + "Enter your choice: " + RESET);
			
			try {
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					filmById();
					break; 
				case 2:
					filmByKeyword();
					break; 
				case 3:
					addFilm(); 
					break;
				case 4:
					updatingFilm(); 
					break; 
				case 5:
					deleteFilm(); 
					break;
				case 6:
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Please enter 1, 2, 3, 4 or 5");
					}
			} catch (Exception e) {
				input.nextLine(); 
				System.out.println("Please enter 1, 2, 3, 4 or 5");
			}
		}
	}
	private void deleteFilm() {
		// TODO Auto-generated method stub
		
	}

	private void updatingFilm() {
		// TODO Auto-generated method stub
		
	}

	private void addFilm() {

		    try {
		        input.nextLine(); 
		        System.out.println("Enter Film Title:");
		        String title = input.nextLine();

		        System.out.println("Enter Film Year:");
		        int year = input.nextInt();
		        input.nextLine(); 

		        System.out.println("Enter Film Rating:");
		        String rating = input.nextLine();

		        System.out.println("Enter Film Language ID:");
		        int languageId = input.nextInt();
		        input.nextLine(); 

		        System.out.println("Enter Film Description:");
		        String description = input.nextLine();

		        System.out.println("Enter Rental Duration:");
		        int rentalDuration = input.nextInt();
		        input.nextLine();

		        System.out.println("Enter Rental Rate:");
		        double rentalRate = input.nextDouble();
		        input.nextLine();

		        System.out.println("Enter Film Length:");
		        int length = input.nextInt();
		        input.nextLine();

		        System.out.println("Enter Replacement Cost:");
		        double replacementCost = input.nextDouble();
		        input.nextLine();

		        Film newFilm = new Film();
		        newFilm.setTitle(title);
		        newFilm.setYear(year);
		        newFilm.setRating(rating);
		        newFilm.setLanguageId(languageId);
		        newFilm.setDescription(description);
		        newFilm.setRentalDuration(rentalDuration);
		        newFilm.setRentalRate(rentalRate);
		        newFilm.setLength(length);
		        newFilm.setReplacementCost(replacementCost);

		        Film addedFilm = db.addFilm(newFilm);

		        if (addedFilm != null) {
		            System.out.println(GREEN_TEXT + "Film added successfully! ID: " + addedFilm.getId() + RESET);
		        } else {
		            System.out.println(RED_TEXT + "Failed to add film." + RESET);
		        }
		    } catch (Exception e) {
		        input.nextLine();
		        System.out.println(RED_TEXT + "Error adding film. Please try again." + RESET);
		    }
		}

	private void filmById() {
		film = null; 
		System.out.println("Please enter the film ID: ");
		
			try {
				int filmId = input.nextInt();
				input.nextLine(); 
				
				film = db.findFilmById(filmId);

				if (film == null) {
					System.out.println(); 
					System.out.println(RED_TEXT + "- film not found - ");
				} else {
			System.out.println();
			System.out.println(BLUE_TEXT);
			System.out.println("╔═══════════════════════════════════════╗");
			System.out.println("║          FILM BY ID NUMBER            ║");
			System.out.println("╚═══════════════════════════════════════╝");
			System.out.println(RESET);
			System.out.println(BOLD +"  Tite: " + RESET + film.getTitle());
			System.out.println(BOLD +"  Year: "+ RESET + film.getYear());
			System.out.println(BOLD +"  Rating: "+ RESET  + film.getRating());
			System.out.println(BOLD +"  Language: "+ RESET  + film.getLanguage());
			System.out.println(BOLD +"  Description: "+ RESET + film.getDescription());
			System.out.println(PURPLE_TEXT);
			System.out.println();
			System.out.println(ITALIC + "		Actors");
			for(Actor actors : film.getActors()) {
				System.out.println(CYAN_TEXT + "  -> " + actors.getFirstName() + " " + actors.getLastName());
			}
			System.out.println(BLUE_TEXT +
					"════════════════════════════════════════");
			System.out.println(RESET);
			}
	} catch (Exception e) {
		input.nextLine(); 
		System.out.println(); 
		System.out.println(RED_TEXT + "-- film not found -- ");
		}
	}
	
	private void filmByKeyword() {
		film = null; 
		input.nextLine(); 
		System.out.println("Search: ");		
		String keywordFilm = input.nextLine(); 

		try {
			List<Film> films = db.findFilmByKeyword(keywordFilm); 
			
			if(films.isEmpty()) {
				System.out.println();
				System.out.println(RED_TEXT + " - film not found - ");
			} else {
				for (Film keyWord : films){
				System.out.println();
				System.out.println(PURPLE_TEXT);
				System.out.println("╔═══════════════════════════════════════╗");
				System.out.println("║             SEARCH RESULTS            ║");
				System.out.println("╚═══════════════════════════════════════╝");
				System.out.println(RESET);
				System.out.println(BOLD +"  Tite: " + RESET + keyWord.getTitle());
				System.out.println(BOLD +"  Year: "+ RESET + keyWord.getYear());
				System.out.println(BOLD +"  Rating: "+ RESET  + keyWord.getRating());
				System.out.println(BOLD +"  Language: "+ RESET  + keyWord.getLanguage());
				System.out.println(BOLD +"  Description: "+ RESET + keyWord.getDescription());
				System.out.println(PURPLE_TEXT);
				System.out.println();
				System.out.println(ITALIC + "		Actors");
				for(Actor actors : keyWord.getActors()) {
					System.out.println(CYAN_TEXT + "  -> " + actors.getFirstName() + " " + actors.getLastName());
				}
				System.out.println(PURPLE_TEXT +
						"════════════════════════════════════════");
				System.out.println(RESET);
				}
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println(RED_TEXT + " -- film not found -- ");
		}	
	}
}
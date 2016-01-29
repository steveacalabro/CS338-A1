import java.util.ArrayList;

/**
 * Stephen Calabro
 * steve.a.calabro@gmail.com
 * CS338:GUI Assignment 1
 */
public class MovieListTester {
	public static void main(String[] args) {
		MovieListActions ma = new MovieListActions();
		
		System.out.println("MovieList");
		ma.printMovieList();
		System.out.println();
		
		System.out.println("MovieTable");
		ma.printMovieTable();
		System.out.println();
		
		ma.addMovieList("The Martian", 2015, "PG-13", 141, "Ridley Scott");
		ma.addMovieTable("Inside Out", 2015, "PG", 94, "Pete Doctor and Ronnie del Carmen");
		
		System.out.println("MovieList");
		ma.printMovieList();
		System.out.println();
		
		System.out.println("MovieList");
		ma.printMovieTable();
		System.out.println();
	}
}

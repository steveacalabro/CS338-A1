/**
 * @author Stephen Calabro
 * steve.a.calabro@gmail.com
 * CS338:GUI Assignment 1
 */
import java.util.ArrayList;

public class MovieListActions {
	private ArrayList<Movie> movieList = new ArrayList<>();
	private ArrayList<Movie> movieTable = new ArrayList<>();
	
	/**
	 * Getter for Movie List
	 * @return
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	/**
	 * Getter for Movie Table
	 * @return
	 */
	public ArrayList<Movie> getMovieTable() {
		return movieTable;
	}
	
	/**
	 * Setter for MovieList
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public void addMovieList(String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		Movie x = new Movie(_movieTitle, _year, _rating, _duration,_directors);
		movieList.add(x);
	}
	
	/**
	 * Setter for MovieTable
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public void addMovieTable(String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		Movie x = new Movie(_movieTitle, _year, _rating, _duration,_directors);
		movieTable.add(x);
	}
	
	/**
	 * Removes element from movie list
	 * @param index
	 */
	public void removeMovieList(int index) {
		movieList.remove(index);
	}

	/**
	 * Removes element from movie table
	 * @param index
	 */
	public void removeMovieTable(int index) {
		movieTable.remove(index);
	}
	
	/**
	 * Changes element in movie list
	 * @param index
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public void changeMovieList(int index, String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		Movie x = movieList.get(index);
		x.updateMovie(_movieTitle, _year, _rating, _duration, _directors);
		movieList.set(index, x);
	}
	
	/**
	 * Changes element in movie table
	 * @param index
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public void changeMovieTable(int index, String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		Movie x = movieTable.get(index);
		x.updateMovie(_movieTitle, _year, _rating, _duration, _directors);
		movieTable.set(index, x);
	}
	
	/**
	 * Method used to print movieList to console
	 */
	public void printMovieList() {
		for(int i = 0; i < movieList.size(); i++) {
			Movie m = movieList.get(i);
			System.out.println("---------------------");
			System.out.println(m.movieTitle());
			System.out.println(m.year());
			System.out.println(m.rating());
			System.out.println(m.duration());
			System.out.println(m.directors());
			System.out.println("---------------------");
		}
	}
	
	/**
	 * Method used to print movieTable to console
	 */
	public void printMovieTable() {
		for(int i = 0; i < movieTable.size(); i++) {
			Movie m = movieTable.get(i);
			System.out.println("---------------------");
			System.out.println(m.movieTitle());
			System.out.println(m.year());
			System.out.println(m.rating());
			System.out.println(m.duration());
			System.out.println(m.directors());
			System.out.println("---------------------");
		}
	}
}

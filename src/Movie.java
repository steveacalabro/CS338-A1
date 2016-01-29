/**
 * Stephen Calabro
 * steve.a.calabro@gmail.com
 * CS338:GUI Assignment 1
 */
public class Movie {
	private String movieTitle;
	private int year;
	private String rating;
	private int duration;
	private String directors;
	
	/**
	 * Constructor for the Movie Object
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public Movie(String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		movieTitle = _movieTitle;
		year = _year;
		rating = _rating;
		duration = _duration;
		directors = _directors;
	}
	
	/**
	 * Getter for movieTitle
	 * @return
	 */
	public String movieTitle() {
		return movieTitle;
	}
	
	/**
	 * Getter for year
	 * @return
	 */
	public int year() {
		return year;
	}
	
	/**
	 * Getter for rating
	 * @return
	 */
	public String rating() {
		return rating;
	}
	
	/**
	 * Getter for duration
	 * @return
	 */
	public int duration() {
		return duration;
	}
	
	/**
	 * Getter for directors
	 * @return
	 */
	public String directors() {
		return directors;
	}
	
	/**
	 * Mutator for Movie Object
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public void updateMovie(String _movieTitle, int _year, String _rating, int _duration, String _directors) {
		movieTitle = _movieTitle;
		year = _year;
		rating = _rating;
		duration = _duration;
		directors = _directors;
	}
}

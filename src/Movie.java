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
	 * Overloaded constructor to allow for string that will be parsed to ints for year and duration
	 * @param _movieTitle
	 * @param _year
	 * @param _rating
	 * @param _duration
	 * @param _directors
	 */
	public Movie(String _movieTitle, String _year, String _rating, String _duration, String _directors) {
		movieTitle = _movieTitle;
		year = Integer.parseInt(_year);
		rating = _rating;
		duration = Integer.parseInt(_duration);
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
	 * Setter for movieTitle
	 * @param _movieTitle
	 */
	public void movieTitle(String _movieTitle) {
		movieTitle = _movieTitle;
	}
	
	/**
	 * Getter for year
	 * @return
	 */
	public int year() {
		return year;
	}
	
	/**
	 * Setter for year
	 * @param _year
	 */
	public void year(String _year) {
		year = Integer.parseInt(_year);
	}
	
	/**
	 * Getter for rating
	 * @return
	 */
	public String rating() {
		return rating;
	}
	
	/**
	 * Setter for rating
	 * @param _rating
	 */
	public void rating(String _rating) {
		rating = _rating;
	}
	
	/**
	 * Getter for duration
	 * @return
	 */
	public int duration() {
		return duration;
	}
	
	/**
	 * Setter for duration
	 * @param _duration
	 */
	public void duration(String _duration) {
		duration = Integer.parseInt(_duration);
	}
	
	/**
	 * Getter for directors
	 * @return
	 */
	public String directors() {
		return directors;
	}
	
	/**
	 * Setter for directors
	 * @param _directors
	 */
	public void directors(String _directors) {
		directors = _directors;
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

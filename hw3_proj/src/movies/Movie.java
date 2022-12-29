/**
 * 
 */
package movies;

/**
 * @author Work_DCruz
 *
 */
public class Movie implements Comparable<Movie> {
	private String title;
	private int year;

	public Movie(String gName, int gYear) {
		title = gName;
		year = gYear;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public int equals(Movie gMovie) {
		return this.compareTo(gMovie);
	}

	public String toString() {
		return "Movie " + this.getTitle() + " " + "(" + this.getYear() + ")";
	}

	// Creates a sample set of movies to work with for main method.
	public static Movie[] getTestMovies() {

		Movie[] testMovies = new Movie[10];
		testMovies[0] = new Movie("True Grit", 1969);
		testMovies[1] = new Movie("True Grit", 2010);
		testMovies[2] = new Movie("The Martian", 2015);
		testMovies[3] = new Movie("Bridge of Spies", 2015);
		testMovies[4] = new Movie("TRON Legacy", 2010);
		testMovies[5] = new Movie("TRON Legacy", 2010);
		testMovies[6] = new Movie("9", 2009);
		testMovies[7] = new Movie("Coraline", 2009);
		testMovies[8] = new Movie("A Beautiful Mind", 2001);
		testMovies[9] = new Movie("Good Will Hunting", 1997);
		return testMovies;

	}

	public int hashCode() {
		return title.hashCode() + year;
	}

	// Compares 2 Movie objects by title, and then by year.
	@Override
	public int compareTo(Movie gMovie) {
		String m1Title = this.getTitle();
		String m2Title = gMovie.getTitle();
		int m1Year = this.getYear();
		int m2Year = gMovie.getYear();
		int comp1 = m1Title.compareTo(m2Title);
		if (comp1 != 0) {
			return comp1;
		} else {
			if (m1Year < m2Year) {
				return -1;
			} else if (m1Year > m2Year) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}

package movies;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	public ListFilmArchive() {
		super();
	}
	// Sorts first by alphabetical order, then in chronological order
	@Override
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> sortMachine = new TreeSet<Movie>(this);
		ArrayList<Movie> output = new ArrayList<Movie>(sortMachine);
		return output;

	}
	
	// Adds a movie to the list/set iff there are no duplicates already in the set.
	@Override
	public boolean add(Movie m) {
		ArrayList<Integer> comps = new ArrayList<Integer>();
		for (Movie e : this) {
			int comp = e.equals(m);
			comps.add(comp);
		}
		if (comps.contains(0) == false) {
			boolean reallyAdded = super.add(m);
			return reallyAdded;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}

}
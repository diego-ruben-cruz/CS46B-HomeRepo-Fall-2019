package movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	// Sorts first by alphabetical order, then in chronological order

	@Override
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> sortMachine = new TreeSet<Movie>(this);
		ArrayList<Movie> output = new ArrayList<Movie>(sortMachine);
		return output;
	}

	// Adds a movie to the list/set iff there are no duplicates already in the set.
	public boolean add(Movie m) {
		boolean reallyAdded = super.add(m);
		return reallyAdded;
	}

	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}

	
}
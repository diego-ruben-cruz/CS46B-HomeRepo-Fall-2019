package space;

import java.util.ArrayList;

public class Mission implements Comparable<Mission> {
	private String destination;
	private float cost;

	public Mission(String destination, Float cost) {
		this.destination = destination;
		this.cost = cost;
	}

	public String getDestination() {
		return destination;
	}

	public float getCost() {
		return cost;
	}

	// Compare by cost, then by destination.
	public int compareTo(Mission that) {
		if (this.cost == that.getCost()) {
			return this.destination.compareTo(that.getDestination());
		} else {
			if (this.cost > that.getCost()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x) {
		return this.compareTo((Mission) x) == 0;

	}

	// Return the destination’s hash code.
	public int hashCode() {
		return this.destination.hashCode();
	}

	public String toString() {
		return "Mission to " + destination + " will cost " + cost;
	}
}

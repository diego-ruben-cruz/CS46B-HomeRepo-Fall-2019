package airlines;

import java.util.*;

public class Airport implements Comparable<Airport> {
	private String name;
	private int x;
	private int y;
	private Set<Airport> connections; // all airports with a direct route from this airport

	public Airport(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Airport> getConnections() {
		return new ArrayList<>(connections);
	}

	// Adds that airport to the list of connections. This is a one-way route, so
	// don’t add this airport to that’s list of connections.
	public void connectTo(Airport that) {
		this.connections.add(that);
	}

	//
	// Does nothing if this airport is not connected to that.
	//
	public void disconnectFrom(Airport that) {
		if (connections.contains(that)) {
			this.connections.remove(that);
		}
	}

	// Uses best practice to determine whether two objects are the same.
	public boolean equals(Object x) {
		int result = this.compareTo((Airport) x);
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Just compare by airport name.
	public int compareTo(Airport that) {
		return this.name.compareTo(that.name);
	}

	// Determines whether one Airport is connected to another.
	public boolean isConnectedTo(Airport that) {
		List<Airport> refList = this.getConnections();
		for (Airport ref : refList) {
			if (ref.equals(that)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}

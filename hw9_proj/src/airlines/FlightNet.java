package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {
	public boolean nameIsAvailable(String name) {
		for (Airport ref : this) {
			if (ref.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	// Connects two airports to each other.
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}

	// Disconnects to airports from each other.
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}

	// Disconnects all routes from a particular airport, then removes the airport.
	public void removeAndDisconnect(Airport removeMe) {
		for (Airport ref : this) {
			removeMe.disconnectFrom(ref);
		}
		this.remove(removeMe);
	}

	// Gets an airport near given x and y coordinates.
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		for (Airport ref : this) {
			int refX = ref.getX();
			int refY = ref.getY();
			double distance = Math.hypot(x - refX, y - refY);
			if (distance > 0 && distance < maximumDistance) {
				return ref;
			}
		}
		return null;
	}
}

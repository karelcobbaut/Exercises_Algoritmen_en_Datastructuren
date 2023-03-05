package week7parking;

import java.util.Collection;

public interface ParkingSimulator {

    public int simulate(int capacity, int returnTime, Collection<Event> arrivalEvents);

}

package entity;

public abstract class Passenger {
    protected Long passengerID;
    protected String name;

    public Passenger(Long passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    public abstract void bookTrip();
    public abstract void viewTrips();
}
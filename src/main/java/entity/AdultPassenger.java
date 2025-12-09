package entity;

public class AdultPassenger extends Passenger {
    private String occupation;

    public AdultPassenger(Long passengerID, String name, String occupation) {
        super(passengerID, name);
        this.occupation = occupation;
    }

    @Override
    public void bookTrip() {}

    @Override
    public void viewTrips() {}
}
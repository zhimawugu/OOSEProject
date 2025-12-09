package entity;

public class StudentPassenger extends Passenger {
    private String schoolName;

    public StudentPassenger(Long passengerID, String name, String schoolName) {
        super(passengerID, name);
        this.schoolName = schoolName;
    }

    @Override
    public void bookTrip() {}

    @Override
    public void viewTrips() {}
}
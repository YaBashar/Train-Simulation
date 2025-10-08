package unsw.trains;


public class Passenger extends Load {
    private String passengerId;
    private boolean isMechanic;
    private static final int weight = 70;

    public Passenger(String passengerId, Station startStation, String destination) {
        super(passengerId, weight, startStation.getPos(), destination);
        super.setType("Passenger");
    }
   
}

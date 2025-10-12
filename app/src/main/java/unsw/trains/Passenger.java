package unsw.trains;


public class Passenger extends Load {
    private String passengerId;
    private boolean isMechanic;
    private static final int weight = 70;

    public Passenger(String passengerId, String startStation, String destination) {
        super(passengerId, weight, startStation, destination);
        super.setType("Passenger");
    }
   
}

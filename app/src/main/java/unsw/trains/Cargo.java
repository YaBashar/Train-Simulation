package unsw.trains;


public class Cargo extends Load {
    
    public Cargo(String cargoId, String startStation, String destStation, int weight) {
        super(cargoId, weight, startStation, destStation);
        super.setType("Cargo");
    }

    public double slowDownTrain(int totalWeight, double speed) {
        double slowDownFactor = (double)totalWeight * 0.01;
        double newSpeed = (100 - slowDownFactor) * speed / 100;
        
        return newSpeed;
    }
}

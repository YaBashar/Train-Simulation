package unsw.trains;


public class Cargo extends Load {
    
    public Cargo(String cargoId, String startStation, String destStation, int weight) {
        super(cargoId, weight, startStation, destStation);
        super.setType("Cargo");
    }

}

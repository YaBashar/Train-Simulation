package unsw.trains;


public class Cargo extends Load {

    private String cargoId;
    private String type; // for part 3 (perishable cargo)
    
    public Cargo(String cargoId, Station startStation, String destStation, int weight) {
        super(cargoId, weight, startStation.getPos(), destStation);
        super.setType("Cargo");
    }
}

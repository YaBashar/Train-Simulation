package unsw.trains;

public class PerishableCargo extends Cargo {

    private int minsToPerish;

    public PerishableCargo(String cargoId, String startStation, String destStation, int weight, int minsToPerish) {
        super(cargoId, startStation, destStation, weight);
        super.setType("PerishableCargo");
        this.minsToPerish = minsToPerish;
    }

    public void deteriorate() {
        this.minsToPerish -= 1;
    }

    public int getMinsToPerish() {
        return minsToPerish;
    }

    public void setMinsToPerish(int minsToPerish) {
        this.minsToPerish = minsToPerish;
    }

}

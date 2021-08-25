public class RentalResult {
    private final int daysRented;
    private final double charge;
    private final int point;

    public RentalResult(int daysRented, double charge, int point){
        this.daysRented = daysRented;
        this.charge = charge;
        this.point = point;
    }

    public double getCharge() {
        return charge;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int getPoint() {
        return point;
    }
}

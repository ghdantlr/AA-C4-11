import java.util.Date;

public class VHS extends Video{
    public VHS(String title, int videoType, int priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    public VHS(String title, int priceCode, Date registeredDate) {
        super(title, Video.VHS, priceCode, registeredDate);
    }

    @Override
    public void setPenalty() {
        this.penalty = 1;
    }

    @Override
    public void setEachRentedLimit() {
        this.rentedLimit = 5;
    }
}

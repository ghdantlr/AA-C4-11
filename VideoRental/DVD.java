import java.util.Date;

public class DVD extends Video{

    public DVD(String title, int videoType, int priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    public DVD(String title, int priceCode, Date registeredDate) {
        super(title, Video.DVD, priceCode, registeredDate);
    }

    @Override
    public void setPenalty() {
        this.penalty = 3;
    }

    @Override
    public void setEachRentedLimit() {
        this.rentedLimit = 2;
    }
}

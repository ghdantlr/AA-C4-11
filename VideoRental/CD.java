import java.util.Date;

public class CD extends Video{

    public CD(String title, int videoType, int priceCode, Date registeredDate) {
        super(title, videoType, priceCode, registeredDate);
    }

    public CD(String title, int priceCode, Date registeredDate) {
        super(title, Video.CD, priceCode, registeredDate);
    }

    @Override
    public void setPenalty() {
        this.penalty = 2;
    }

    @Override
    public void setEachRentedLimit() {
        this.rentedLimit = 3;
    }
}

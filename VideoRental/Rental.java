import java.util.Date;

public class Rental {
	private Video video ;
	private RentStatus status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = RentStatus.RENT ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public RentStatus getStatus() {
		return status;
	}

	public void returnVideo() {
		if (!video.isRented()) return;
		video.setRented(false);
		if ( status == RentStatus.RENT ) {
			this.status = RentStatus.RETURN;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented = getRented();

		if ( daysRented <= 2) return limit ;

		limit = video.getRentedLimit();
		return limit ;
	}

	public int getRented() {
		int daysRented = 0;
		long diff;

		if (getStatus() == RentStatus.RETURN) { // returned Video
			diff = getReturnDate().getTime() - getRentDate().getTime();
		} else { // not yet returned
			diff = new Date().getTime() - getRentDate().getTime();
		}
		daysRented = calcDiff(diff);
		return daysRented;
	}

	private int calcDiff(long diff) {
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}

	public double getCarge(int daysRented) {
		double eachCharge = 0;

		switch (getVideo().getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
		}
		return eachCharge;
	}

	public int getPoint(int daysRented) {
		int eachPoint = 1;

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty());

		return eachPoint;

	}

}

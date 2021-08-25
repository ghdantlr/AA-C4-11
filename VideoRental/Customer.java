import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) { this.setName(name);	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public Rental getRental(String videoTitle){
		Rental foundRental = null;
		for ( Rental rental: rentals ) {
			if ( rental.getVideo().getTitle().equals(videoTitle)) {
				foundRental = rental;
				break;
			}
		}
		return foundRental;
	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			RentalResult rentalResult = each.getRentalResult();

			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + rentalResult.getDaysRented() + "\tCharge: " + rentalResult.getCharge()
					+ "\tPoint: " + rentalResult.getPoint() + "\n";

			totalCharge += rentalResult.getCharge();

			totalPoint += rentalResult.getPoint() ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result ;
	}
}

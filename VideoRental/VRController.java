import java.util.ArrayList;
import java.util.List;

public class VRController {

    private VRModel model;

    public VRController(VRModel model) {
        this.model = model;
    }

    private void printClearedRentalInfo(Customer customer){
        System.out.println("Name: " + customer.getName() +
                "\tRentals: " + customer.getRentals().size());
        for (Rental rental : customer.getRentals()) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
        }
    }

    public boolean clearRentals(String customerName) {
        Customer foundCustomer = model.findCustomer(customerName) ;
        if (foundCustomer == null) return false;

        printClearedRentalInfo(foundCustomer);

        List<Rental> rentals = new ArrayList<Rental>();
        foundCustomer.setRentals(rentals);
        return true;
    }

    public void returnVideo(String customerName, String videoTitle) {
        Customer foundCustomer = model.findCustomer(customerName) ;
        if ( foundCustomer == null ) return;

        Rental foundCustomerRental = foundCustomer.getRental(videoTitle) ;
        if (foundCustomerRental == null) return;

        foundCustomerRental.returnVideo();
    }

    public void rentVideo(String customerName, String videoTitle) {

        Customer foundCustomer = model.findCustomer(customerName) ;
        if ( foundCustomer == null ) return ;

        Video foundVideo = model.findVideo(videoTitle) ;
        if ( foundVideo == null ) return ;

        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }
}

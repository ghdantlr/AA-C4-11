import java.util.ArrayList;
import java.util.List;

public class VRController {

    private VRModel model;

    public VRController(VRModel model) {
        this.model = model;
    }

    public boolean clearRentals(String customerName) {
        Customer foundCustomer = model.findCustomer(customerName) ;
        if (foundCustomer == null) return false;

        System.out.println("Name: " + foundCustomer.getName() +
                "\tRentals: " + foundCustomer.getRentals().size());
        for (Rental rental : foundCustomer.getRentals()) {
            System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
            System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
        }

        List<Rental> rentals = new ArrayList<Rental>();
        foundCustomer.setRentals(rentals);
        return true;
    }

    public void returnVideo(String customerName, String videoTitle) {
        Customer foundCustomer = model.findCustomer(customerName) ;
        if ( foundCustomer == null ) return;

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        for ( Rental rental: customerRentals ) {
            if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break ;
            }
        }
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

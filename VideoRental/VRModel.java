import java.util.ArrayList;
import java.util.List;

public class VRModel {
    private List<Customer> customers = new ArrayList<Customer>() ;

    private List<Video> videos = new ArrayList<Video>() ;

    public List<Customer> getCustomers(){
        return customers;
    }

    public List<Video> getVideos(){
        return videos;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addVideo(Video video){
        videos.add(video);
    }

    public Customer findCustomer(String customerName){
        Customer foundCustomer = null;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        return foundCustomer;
    }

    public Video findVideo(String videoTitle){
        Video foundVideo = null;
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }
        return foundVideo;
    }
}

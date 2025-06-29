import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList = new ArrayList<>();

    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(102, "Shatabdi Express", "Delhi", "Bhopal", 120));
        trainList.add(new Train(103, "Duronto Express", "Mumbai", "Kolkata", 130));
        trainList.add(new Train(104, "Garib Rath", "Lucknow", "Chandigarh", 90));
        trainList.add(new Train(105, "Intercity Express", "Kanpur", "Delhi", 80));
        trainList.add(new Train(106, "Vande Bharat Express", "Varanasi", "Delhi", 150));
        trainList.add(new Train(107, "Tejas Express", "Ahmedabad", "Mumbai", 140));
        trainList.add(new Train(108, "Goa Express", "Goa", "Delhi", 110));
        trainList.add(new Train(109, "Kanchanjunga Express", "Sealdah", "Guwahati", 100));
        trainList.add(new Train(110, "Coromandel Express", "Kolkata", "Chennai", 125));
        trainList.add(new Train(111, "Deccan Queen", "Pune", "Mumbai", 95));
        trainList.add(new Train(112, "Uday Express", "Coimbatore", "Bangalore", 85));
        trainList.add(new Train(113, "Purushottam Express", "Puri", "New Delhi", 115));
        trainList.add(new Train(114, "Humsafar Express", "Bangalore", "Gorakhpur", 105));
        trainList.add(new Train(115, "Sampark Kranti", "Varanasi", "Delhi", 98));
    }

    public List<Train> searchTrain(String source,String destination){
        List<Train> res = new ArrayList<>();

        for(Train train: trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase((destination))){
                res.add(train);
            }
        }

        return res;
    }

    public Ticket bookTicket(User user,int trainId,int seatCount){
        for(Train train : trainList){
            if(train.getTrainId()== trainId){
                if(train.bookSeats(seatCount)){
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }else{
                    System.out.println("Not Enough Seats Available");
                    return null;
                }
            }
        }

        System.out.println("Train id not found");
        return null;
    }

    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();

        for(Ticket ticket : ticketList){
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                res.add(ticket);
            }
        }

        return  res;
    }


    public boolean cancelTicket(int ticketId,User user){
        Iterator<Ticket> iterator= ticketList.listIterator();

        while (iterator.hasNext()){
            Ticket ticket = iterator.next();

            if(ticket.getTicketId() == ticketId &&
                            ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Train train = ticket.getTrain();
                train.cancelTicket(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket "+ticketId+ " cancelled successful..");
                return true;
            }
        }

        System.out.println("Ticket not found or does not belong to current user..");
        return false;
    }

    public void listAllTrains(){
        System.out.println("List of all trains..");

        for(Train train:trainList){
            System.out.println(train);
        }
    }
}

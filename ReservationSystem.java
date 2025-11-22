import java.util.*;

public class ReservationSystem {
    private List<User> users = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private User loggedInUser = null;

    public ReservationSystem() {
        trains.add(new Train(101, "Rajdhani Express", "Delhi", "Mumbai", 5, 1200));
        trains.add(new Train(102, "Shatabdi Express", "Delhi", "Chandigarh", 10, 800));
        trains.add(new Train(103, "Duronto Express", "Mumbai", "Kolkata", 8, 1500));
    }

    public void register(String username, String password, String name) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }
        users.add(new User(username, password, name));
        System.out.println("Registration successful! Please login.");
    }

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedInUser = u;
                System.out.println("Welcome, " + u.getName() + "!");
                return true;
            }
        }
        System.out.println("Invalid credentials.");
        return false;
    }

    public void viewTrains() {
        System.out.println("Available Trains:");
        for (Train t : trains) {
            System.out.println(t.getTrainNumber() + " | " + t.getTrainName() + " | " + t.getSource() + " → " + t.getDestination() +
                    " | Seats: " + t.getTotalSeats() + " | Fare: Rs." + t.getFare());
        }
    }

    public void bookTicket(int trainNumber) {
        if (loggedInUser == null) {
            System.out.println("Please login first!");
            return;
        }
        for (Train t : trains) {
            if (t.getTrainNumber() == trainNumber) {
                if (t.bookSeat()) {
                    Ticket ticket = new Ticket(loggedInUser, t);
                    tickets.add(ticket);
                    System.out.println("Ticket booked successfully!");
                    ticket.displayTicket();
                    return;
                } else {
                    System.out.println("No seats available.");
                    return;
                }
            }
        }
        System.out.println("Train not found.");
    }

    public void cancelTicket(int ticketId) {
        Ticket toCancel = null;
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId && t.getUser().equals(loggedInUser)) {
                toCancel = t;
                break;
            }
        }
        if (toCancel != null) {
            toCancel.getTrain().cancelSeat();
            tickets.remove(toCancel);
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Ticket not found or not yours.");
        }
    }

    public void viewMyTickets() {
        if (loggedInUser == null) {
            System.out.println("Please login first!");
            return;
        }
        System.out.println("Your Booked Tickets:");
        for (Ticket t : tickets) {
            if (t.getUser().equals(loggedInUser)) {
                t.displayTicket();
            }
        }
    }
}

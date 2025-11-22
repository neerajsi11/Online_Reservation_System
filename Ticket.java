public class Ticket {
    private static int idCounter = 1000;
    private int ticketId;
    private User user;
    private Train train;

    public Ticket(User user, Train train) {
        this.ticketId = idCounter++;
        this.user = user;
        this.train = train;
    }

    public int getTicketId() { return ticketId; }
    public User getUser() { return user; }
    public Train getTrain() { return train; }

    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Passenger: " + user.getName());
        System.out.println("Train: " + train.getTrainName() + " (" + train.getTrainNumber() + ")");
        System.out.println("From: " + train.getSource() + " To: " + train.getDestination());
        System.out.println("Fare: Rs. " + train.getFare());
        System.out.println("-----------------------------------");
    }
}

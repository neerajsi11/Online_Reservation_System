import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        while (true) {
            System.out.println("\n=== Online Train Reservation System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Trains");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. View My Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter Password: ");
                    String password = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    system.register(username, password, name);
                    break;
                case 2:
                    System.out.print("Enter Username: ");
                    username = sc.next();
                    System.out.print("Enter Password: ");
                    password = sc.next();
                    system.login(username, password);
                    break;
                case 3:
                    system.viewTrains();
                    break;
                case 4:
                    System.out.print("Enter Train Number: ");
                    int trainNo = sc.nextInt();
                    system.bookTicket(trainNo);
                    break;
                case 5:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();
                    system.cancelTicket(ticketId);
                    break;
                case 6:
                    system.viewMyTickets();
                    break;
                case 7:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

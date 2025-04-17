class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketReservationSystem {
    private Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicketById(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        Ticket curr = head;
        Ticket prev = null;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    Ticket last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomerOrMovie(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }
        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No ticket found for keyword: " + keyword);
    }

    public int countTotalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Avengers", "A1", "10:00AM");
        system.addTicket(102, "Bob", "Batman", "B2", "12:00PM");
        system.addTicket(103, "Charlie", "Avengers", "C3", "2:00PM");
        system.addTicket(104, "David", "Superman", "D4", "4:00PM");

        System.out.println("All Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer 'Alice':");
        system.searchByCustomerOrMovie("Alice");

        System.out.println("\nSearch by Movie 'Avengers':");
        system.searchByCustomerOrMovie("Avengers");

        System.out.println("\nRemoving Ticket ID 102");
        system.removeTicketById(102);

        System.out.println("\nAll Booked Tickets After Removal:");
        system.displayTickets();

        System.out.println("\nTotal Tickets Booked: " + system.countTotalTickets());
    }
}

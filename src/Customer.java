import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by wyli on 16/12/7.
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Records for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental)rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }


    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<h1>Rentals for <em>" + getName() + "</em><h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }
        result += "<p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "On this rentals you earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points</p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public static void main(String[] args) {
        Customer customer = new Customer("jeskert");
        Movie movie = new Movie("Titanic", 20);
        Rental rental = new Rental(movie, 5);
        customer.addRental(rental);
        System.out.println(customer.htmlStatement());
    }
}

import main.rental.Customer;
import main.rental.Movie;
import main.rental.Rental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void htmlStatement() throws Exception {
        Customer customer = dummyCustomer();
        assertEquals(customer.htmlStatement(), "<h1>Rentals for <em>jeskert</em><h1><p>\n" +
                "Titanic: 4.5<br>\n" +
                "<p>You owe <em>4.5</em></p>\n" +
                "On this rentals you earned <em>1</em> frequent renter points</p>");
    }

    @Test
    public void statement() throws Exception {
        Customer customer = dummyCustomer();
        assertEquals(customer.statement(), "main.rental.Rental Records for jeskert\n" +
                "\tTitanic\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points");
    }

    private Customer dummyCustomer() {
        Customer customer = new Customer("jeskert");
        Movie movie = new Movie("Titanic", 2);
        Rental rental = new Rental(movie, 5);
        customer.addRental(rental);
        return customer;
    }
}
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void htmlStatement() throws Exception {
        Customer customer = dummyCustomer();
        assertEquals(customer.htmlStatement(), "<h1>Rentals for <em>jeskert</em><h1><p>\n" +
                "Titanic: 0.0<br>\n" +
                "<p>You owe <em>0.0</em></p>\n" +
                "On this rentals you earned <em>1</em> frequent renter points</p>");
    }

    @Test
    public void statement() throws Exception {
        Customer customer = dummyCustomer();
        assertEquals(customer.statement(), "Rental Records for jeskert\n" +
                "\tTitanic\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points");
    }

    private Customer dummyCustomer() {
        Customer customer = new Customer("jeskert");
        Movie movie = new Movie("Titanic", 20);
        Rental rental = new Rental(movie, 5);
        customer.addRental(rental);
        return customer;
    }
}
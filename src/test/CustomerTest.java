import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
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
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SecondAgendaTest {

    private static Agenda agenda = new Agenda();

    @BeforeClass
    public static void setUp() {
        System.out.println("Starting second test cases.");
        agenda = new Agenda();
    }

    @Test
    public void testSorting() {
        Contact bogdan = new Contact("Bogdan", "+40 758 111 123");
        Contact mircea = new Contact("Mircea", "+40 758 333 123");
        Contact stefan = new Contact("Stefan", "+40 758 222 123");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(mircea);
        contacts.add(stefan);
        contacts.add(bogdan);

        List<Contact> sorted = agenda.sortByName(contacts);
        contacts.sort(Comparator.comparing(Contact::getName));
        assertEquals(contacts, sorted);
    }

    @Test(expected = NullPointerException.class)
    public void testSortingWithNullName() {
        Contact bogdan = new Contact(null, "+40 758 111 123");
        Contact mircea = new Contact("Mircea", "+40 758 333 123");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(mircea);
        contacts.add(bogdan);

        List<Contact> sorted = agenda.sortByName(contacts);
    }

    @Test(expected = NullPointerException.class)
    public void testNullSorting() {
        List<Contact> contacts = null;
        List<Contact> sorted = agenda.sortByName(contacts);
    }

    @Test
    public void testFactorial() {
        assertEquals(6, agenda.agendaFactorial(3));
    }

    @Test
    public void testAgendaFactorialNotNull() {
        agenda.setContacts(new ArrayList<>());
        int factorial = agenda.agendaFactorial(agenda.getSize());
        assertNotNull(factorial);
    }

    @Test(expected = NullPointerException.class)
    public void testAgendaFactorialNull() {
        int factorial = agenda.agendaFactorial(null);
    }
}

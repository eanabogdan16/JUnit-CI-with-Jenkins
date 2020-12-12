package jenkins;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FirstAgendaTest {

    private static Agenda agenda = new Agenda();

    @BeforeClass
    public static void setUp() {
        agenda = new Agenda();
    }

    @Test
    public void testConstructor() {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Contact contact = new Contact("Mircea" + i, "+40 758 333 123");
            contacts.add(contact);
        }

        agenda = new Agenda(contacts);
        assertEquals(contacts, agenda.getContacts());
    }

    @Test
    public void testGetterAndSetter() {
        Contact contactTest = new Contact("Test", "+4 0725 351 489");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contactTest);

        agenda.setContacts(contacts);
        assertEquals(contacts, agenda.getContacts());
    }

    @Test
    public void testCount() {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Contact contact = new Contact("Mircea" + i, "+40 758 333 123");
            contacts.add(contact);
        }

        agenda.setContacts(contacts);
        int count = agenda.getSize();
        assertEquals(contacts.size(), count);
    }

    @Test
    public void testCountException() {
        agenda.setContacts(null);
        try {
            agenda.getSize();
            fail("Not returning exception!");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testListNull() {
        agenda = new Agenda();
        assertNull(agenda.getContacts());
    }

    @Test
    public void testListNotNull() {
        agenda.setContacts(new ArrayList<>());
        assertNotNull(agenda.getContacts());
    }


}

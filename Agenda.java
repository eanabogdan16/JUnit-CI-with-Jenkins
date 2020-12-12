import java.util.List;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
}

public class Agenda {
    private List<Contact> contacts;

    public Agenda() {}

    public Agenda(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> sortByName(List<Contact> contacts) {
        int n = contacts.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) < 0) {
                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }

        return contacts;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < this.contacts.size(); i++) {
            count++;
        }

        return count;
    }

    public int agendaFactorial(Integer n) {
        if (n == 0)
            return 1;
        else
            return (n * agendaFactorial(n - 1));
    }
}

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.Test
    void testPerson() {
        Person person = new Person("Frau Dr. Eva Müller, Hochschule Bonn-Rhein-Sieg, Fachbereich Informatik, Grantham-Allee 20, 53757 Sankt Augustin");

        assertEquals("Müller", person.name);
        assertEquals("Frau", person.anrede);
        assertEquals("Hochschule Bonn-Rhein-Sieg", person.organisation);
        assertEquals("Fachbereich Informatik", person.abteilung);
        assertEquals("20", person.hausnummer);
        assertEquals("Sankt Augustin ", person.stadt);
    }

}
package Group_C.Person_Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestPersonEachUse {

    private String name;
    private String lastName;
    private String dateOfBirth;
    private String nationality;
    private String education;
    private String englishCertification;
    private String phoneNumber;
    private String email;
    private boolean expectedResult;

    public TestPersonEachUse(String name, String lastName, String dateOfBirth, String nationality,
                                   String education, String englishCertification, String phoneNumber, String email,
                                   boolean expectedResult) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.education = education;
        this.englishCertification = englishCertification;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Valid combination
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", true},
                // Name
                {"", "Perez", "03/12/2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                {null, "Perez", "03/12/2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Surname
                {"Pepito", "", "03/12/2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                {"Pepito", null, "03/12/2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Date of birth
                {"Pepito", "Perez", "03.12.2003", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Null is not controlled
                // {"Pepito", "Perez", null, "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Nationality
                {"Pepito", "Perez", "03/12/2003", "", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "03/12/2003", null, "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Education
                {"Pepito", "Perez", "03/12/2003", "French", "", "C2", "123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "03/12/2003", "French", null, "C2", "123456789", "pepito.perez@example.com", false},
                // Certification
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "", "123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", null, "123456789", "pepito.perez@example.com", false},
                // Phone number
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "123", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "0123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "", "pepito.perez@example.com", false},
                // Null is not controlled
                // {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", null, "pepito.perez@example.com", false},
                // Email
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "123456789", "", false},
                {"Pepito", "Perez", "03/12/2003", "French", "Primary", "C2", "123456789", null, false},
                // Is European
                {"Pepito", "Perez", "03/12/2003", "RUSSIAN", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                // Is Legal Age
                {"Pepito", "Perez", "12/02/2008", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false},
                {"Pepito", "Perez", "12/02/2004", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", true},
                {"Pepito", "Perez", "12/02/2005", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", true},
                {"Pepito", "Perez", "12/02/2006", "French", "Primary", "C2", "123456789", "pepito.perez@example.com", false}
        });
    }

    @Test
    public void testPerson() {
        try {
            Person person = new Person(name, lastName, dateOfBirth, nationality, education,
                    englishCertification, phoneNumber, email);
            assertEquals(name, person.getName());
            assertEquals(lastName, person.getLastName());
            assertEquals(dateOfBirth, person.getDateOfBirth());
            assertEquals(nationality, person.getNationality());
            assertEquals(education, person.getEducation());
            assertEquals(englishCertification, person.getEnglishCertification());
            assertEquals(phoneNumber, person.getPhoneNumber());
            assertEquals(email, person.getEmail());
            assertEquals(expectedResult, person.isLegalAge() && person.isEuropean());
        } catch (IllegalArgumentException e) {
            assertEquals(!expectedResult, true);
        }
    }
}

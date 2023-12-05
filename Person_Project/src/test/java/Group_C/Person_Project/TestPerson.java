package Group_C.Person_Project;

import junit.framework.TestCase;

public class TestPerson extends TestCase {

	    //@Test
	    public void testIsLegalAge() {
	        Person person1 = new Person("John", "Doe", "07/10/1990", "European", "Computer Science", "Advanced", "123456789", "john@example.com");
	        assertTrue(person1.isLegalAge());

	        Person person2 = new Person("Jane", "Doe", "01/01/2010", "European", "Computer Science", "Advanced", "987654321", "jane@example.com");
	        assertFalse(person2.isLegalAge());
	    }

	    //@Test
	    public void testIsEuropean() {
	        Person europeanPerson = new Person("Alice", "Smith", "05/15/1985", "Italian", "Mathematics", "Intermediate", "555555555", "alice@example.com");
	        assertTrue(europeanPerson.isEuropean());

	        Person nonEuropeanPerson = new Person("Bob", "Johnson", "03/20/1990", "American", "Physics", "Advanced", "111111111", "bob@example.com");
	        assertFalse(nonEuropeanPerson.isEuropean());
	    }

	   // @Test expected = IllegalArgumentException.class
	    public void testInvalidDayOfBirth() {
	        new Person("Invalid", "Person", "31/02/2000", "European", "Invalid Education", "None", "999999999", "invalid@example.com");
	    }
	    
	    // @Test expected = IllegalArgumentException.class
	    public void testInvalidMonthOfBirth() {
	        new Person("Invalid", "Person", "31/13/2000", "European", "Invalid Education", "None", "999999999", "invalid@example.com");
	    }  

	    // @Test expected = IllegalArgumentException.class
	    public void testInvalidYearOfBirth() {
	        new Person("Invalid", "Person", "31/12/2030", "European", "Invalid Education", "None", "999999999", "invalid@example.com");
	    }
	    
	    //@Test expected = IllegalArgumentException.class
	    public void testInvalidPhoneNumber() {
	        new Person("Invalid", "Person", "01/01/1990", "European", "Invalid Education", "None", "123", "invalid@example.com");
	    }

	}

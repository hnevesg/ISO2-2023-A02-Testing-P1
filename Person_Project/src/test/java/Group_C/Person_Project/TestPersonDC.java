package Group_C.Person_Project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPersonDC {

	private Person p;

	@Before
	public void init() {
		p = new Person("Pepito", "Perez", "03/12/2003", "SPANISH", "Primary", "C2", "123456789",
				"pepitoperez@gmail.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetName() throws IllegalArgumentException {
		p.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLastName() throws IllegalArgumentException{
		p.setLastName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDateOfBirth() throws IllegalArgumentException{
		p.setDateOfBirth("12.02.2003");
	}


	@Test(expected = IllegalArgumentException.class)
	public void testSetNationality() throws IllegalArgumentException {
		p.setNationality(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEducation() throws IllegalArgumentException {
		p.setEducation(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEnglishCertification() throws IllegalArgumentException {
		p.setEnglishCertification(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPhoneNumber() throws IllegalArgumentException {
		p.setPhoneNumber("123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmail() throws IllegalArgumentException {
		p.setEmail(null);
	}

	@Test
	public void testIsLegalAge() {
		p.setDateOfBirth("12/02/2008");
		assertFalse(p.isLegalAge());
	}

	@Test
	public void testIsEuropean() {
		p.setNationality("RUSSIAN");
		assertFalse(p.isEuropean());
	}

}

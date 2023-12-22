package Group_C.Person_Project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPersonMCDC {
	
	private Person p;
	
	@Before
	public void init() {
		p = new Person("Pepito", "Perez", "03/12/2003", "SPANISH", "Primary", "C2", "123456789",
				"pepitoperez@gmail.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNameA() throws IllegalArgumentException {
		p.setName(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNameB() throws IllegalArgumentException {
		p.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameA() throws IllegalArgumentException{
		p.setLastName(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameB() throws IllegalArgumentException{
		p.setLastName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDateOfBirth() throws IllegalArgumentException{
		p.setDateOfBirth("12.02.2003");
	}


	@Test(expected = IllegalArgumentException.class)
	public void testSetNationalityA() throws IllegalArgumentException {
		p.setNationality(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNationalityB() throws IllegalArgumentException {
		p.setNationality("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEducationA() throws IllegalArgumentException {
		p.setEducation(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEducationB() throws IllegalArgumentException {
		p.setEducation("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEnglishCertificationA() throws IllegalArgumentException {
		p.setEnglishCertification(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEnglishCertificationB() throws IllegalArgumentException {
		p.setEnglishCertification("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPhoneNumber() throws IllegalArgumentException {
		p.setPhoneNumber("123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmailA() throws IllegalArgumentException {
		p.setEmail(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEmailB() throws IllegalArgumentException {
		p.setEmail("");
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

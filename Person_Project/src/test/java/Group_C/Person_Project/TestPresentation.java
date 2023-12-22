package Group_C.Person_Project;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPresentation {

	private final InputStream originalSystemIn = System.in;

	private final String input = "Pepito\nPerez\n12/02/2003\nSPANISH\nPrimary\nC2\n123456789\npepito.perez@example.com\n";

	private final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

	private final StringBuilder output = new StringBuilder();

	@Before
	public void setUpStreams() {
		System.setIn(inputStream);
		System.setOut(new java.io.PrintStream(System.out) {
			public void println(String message) {
				output.append(message).append("\n");
			}
		});
	}

	@After
	public void restoreStreams() {
		System.setIn(originalSystemIn);
		System.setOut(System.out);
	}

	@Test
	public void testPresentation() {
		Presentation.main(new String[] {});

		String expectedOutput = "Enter your name\n"
		        + "Enter your lastname\n"
		        + "Enter your birthday (dd/mm/yyyy)\n"
		        + "Enter your nationality\n"
		        + "Enter your education level\n"
		        + "Enter your english certification\n"
		        + "Enter your phone number\n"
		        + "Enter your email\n"
		        + "\n"
		        + "User Information:\n"
		        + "Name: Pepito\n"
		        + "Last name: Perez\n"
		        + "Date of birth: 12/02/2003\n"
		        + "Nationality: SPANISH\n"
		        + "Education: Primary\n"
		        + "English Certification: C2\n"
		        + "Phone Number: 123456789\n"
		        + "Email: pepito.perez@example.com\n"
		        + "Is european: true\n"
		        + "Is legal age: true\n";


		assertEquals(expectedOutput, output.toString());
	}
}

package Group_C.Person_Project;

import java.util.Scanner;
import reading.Read;

public class Presentation {

    private static Scanner scanner = new Scanner(System.in);

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        try{
	        String name = Read.read_string("Enter your name");
	        String lastname = Read.read_string("Enter your lastname");
	        String age = Read.read_string("Enter your birthday (dd/mm/yyyy)");
	        String nationality = Read.read_string("Enter your nationality");
	        String education = Read.read_string("Enter your education level");
	        String englishCertification = Read.read_string("Enter your english certification");
	        String phoneNumber = Read.read_string("Enter your phone number");
	        String email = Read.read_string("Enter your email");
        
        
	        Person person = new Person(name, lastname, age, nationality, education, englishCertification, phoneNumber, email);
	        
	        print("\nUser Information:");
	        print("Name: " + person.getName());
	        print("Last name: " + person.getLastName());
	        print("Date of birth: " + person.getDateOfBirth());
	        print("Nationality: " + person.getNationality());
	        print("Education: " + person.getEducation());
	        print("English Certification: " + person.getEnglishCertification());
	        print("Phone Number: " + person.getPhoneNumber());
	        print("Email: " + person.getEmail());
	        boolean European = person.isEuropean();
	        print("Is european: " + European);
	        boolean legalAge = person.isLegalAge();
	        print("Is legal age: " + legalAge);
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}


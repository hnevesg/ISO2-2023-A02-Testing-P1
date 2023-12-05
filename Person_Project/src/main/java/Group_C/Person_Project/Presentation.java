package Group_C.Person_Project;

import java.util.Scanner;

public class Presentation {

    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        try{
        	String name = readString("Enter your name");
        String lastname = readString("Enter your lastname");
        String age = readString("Enter your birthday (dd/mm/yyyy)");
        String nationality = readString("Enter your nationality");
        String education = readString("Enter your education level");
        String englishCertification = readString("Enter your english certification");
        String phoneNumber = readString("Enter your phone number");
        String email = readString("Enter your email");
        
        
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
        person.isEuropean();
        person.isLegalAge();
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}


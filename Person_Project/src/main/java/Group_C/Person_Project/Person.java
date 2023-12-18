package Group_C.Person_Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Person {
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String nationality;
    private String education;
    private String englishCertification;
    private String phoneNumber;
    private String email;

    enum EuropeanNationality {
        AUSTRIAN, BELGIAN, BULGARIAN, CROATIAN, CYPRIOT, CZECH, DANISH,
        DUTCH, ESTONIAN, FINNISH, FRENCH, GERMAN, GREEK, HUNGARIAN, IRISH,
        ITALIAN, LATVIAN, LITHUANIAN, LUXEMBOURGER, MALTESE, POLISH, PORTUGUESE,
        ROMANIAN, SLOVAK, SLOVENIAN, SPANISH, SWEDISH
    }
    
    public Person(String name, String lastName, String dateOfBirth, String nationality,String education, String englishCertification, String phoneNumber, String email) throws IllegalArgumentException{
        	setName(name);
	        setLastName(lastName);
	        setDateOfBirth(dateOfBirth);
	        setNationality(nationality);
	        setEducation(education);
	        setEnglishCertification(englishCertification);
	        setPhoneNumber(phoneNumber);
	        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    	if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    	this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
    	if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    	this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {        
    	 try {
    		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	         sdf.setLenient(false);  
	         this.dateOfBirth= sdf.parse(dateOfBirth);
		}
		catch(ParseException e){
			throw new IllegalArgumentException();
		}
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
    	if (nationality == null || nationality.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
    	if (education == null || education.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.education = education;
    }

    public String getEnglishCertification() {
        return englishCertification;
    }

    public void setEnglishCertification(String englishCertification) {
    	if (englishCertification == null || englishCertification.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.englishCertification = englishCertification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.length() == 9) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must have 9 characters");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public boolean isLegalAge() {
        int currentYear = LocalDate.now().getYear();
        int birthYear = this.dateOfBirth.getYear();
        return currentYear - birthYear >= 18;
    }

    public boolean isEuropean() {
        for (EuropeanNationality europeanNationality : EuropeanNationality.values()) {
            if (europeanNationality.toString().equalsIgnoreCase(this.nationality)) {
                return true;
            }
        }
        return false;    
     }
}

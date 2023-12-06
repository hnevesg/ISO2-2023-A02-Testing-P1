package Group_C.Person_Project;

import java.time.LocalDate;

public class Person {
    private String name;
    private String lastName;
    private String dateOfBirth;
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
    
    public Person(String name, String lastName, String dateOfBirth, String nationality,String education, String englishCertification, String phoneNumber, String email) {
        try { 
        	setName(name);
	        setLastName(lastName);
	        setDateOfBirth(dateOfBirth);
	        setNationality(nationality);
	        setEducation(education);
	        setEnglishCertification(englishCertification);
	        setPhoneNumber(phoneNumber);
	        setEmail(email);
        }catch(IllegalArgumentException e){
	    	System.out.println(e.getMessage());
	    }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        String[] dateParts = dateOfBirth.split("/");
        if (dateParts.length == 3) {
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            if (month < 1 || month > 12){
                throw new IllegalArgumentException("Invalid month in date of birth");
            } else {
            	if(year < 1 || year > LocalDate.now().getYear()) {
            		throw new IllegalArgumentException("Invalid year in date of birth");
            	}
            	else if(day < 1) {
            		throw new IllegalArgumentException("Invalid day in date of birth");	
            	}else if(month == 2 && day > 28 && year%4 != 0) {
            		throw new IllegalArgumentException("Invalid day in date of birth");            		
            	}else if(month == 2 && day > 29 && year%4 == 0) {
            		throw new IllegalArgumentException("Invalid day in date of birth");            		
            	}else if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day>31) {
            		throw new IllegalArgumentException("Invalid day in date of birth");            		
            	}else if((month==4 || month==6 || month==9 || month==11) && day>30) {
            		throw new IllegalArgumentException("Invalid day in date of birth");            		
            	}else {
            		this.dateOfBirth = dateOfBirth;
            	}
            }
        } else {
            throw new IllegalArgumentException("Invalid date format for date of birth");
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEnglishCertification() {
        return englishCertification;
    }

    public void setEnglishCertification(String englishCertification) {
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
        this.email = email;
    }

    public boolean isLegalAge() {
        int currentYear = LocalDate.now().getYear();
        int birthYear = Integer.parseInt(this.dateOfBirth.split("/")[2]);
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

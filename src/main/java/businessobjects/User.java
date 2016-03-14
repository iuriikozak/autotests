package TestAutomation.TemplateMonster.businessobjects;

import TestAutomation.TemplateMonster.utility.PropertyReader;
import template_monster.utility.EncodingService;

import java.io.IOException;
import java.util.Objects;

public class User {
	
	private String userName = null;
	private String password = null;
	private String errorMessage = null;

    private String fullName = null;
    private String email = null;
    private String formAddress = null;
    private String city = null;
    private String country = null;
    private String state = null;
    private String post = null;
    private String phone = null;
    private String contactPhone = null;

    //For sales-billing system.
    private String adminName = null;
    private String adminPass = null;

    //For registration system.
    private String question = null;
    private String answer = null;
		
	public User(String fileLocation) throws IOException {
		super();
		
		PropertyReader propertyReader = new PropertyReader();
		this.userName = propertyReader.getPropertyValue(fileLocation, "userName");
		this.password = propertyReader.getPropertyValue(fileLocation, "password");
		this.errorMessage = propertyReader.getPropertyValue(fileLocation, "errorMessage");
        this.fullName = propertyReader.getPropertyValue(fileLocation, "fullName");
        this.formAddress = propertyReader.getPropertyValue(fileLocation, "formAddress");
        this.city = propertyReader.getPropertyValue(fileLocation, "city");
        this.country = propertyReader.getPropertyValue(fileLocation, "country");
        this.state = propertyReader.getPropertyValue(fileLocation, "state");
        this.post = propertyReader.getPropertyValue(fileLocation, "post");
        this.phone = propertyReader.getPropertyValue(fileLocation, "phone");
        this.contactPhone = propertyReader.getPropertyValue(fileLocation, "contactPhone");
        this.email = Objects.toString(System.currentTimeMillis()) + propertyReader.getPropertyValue(fileLocation,"email");
        this.adminName = propertyReader.getPropertyValue(fileLocation, "adminName");
        this.adminPass = propertyReader.getPropertyValue(fileLocation, "adminPass");
        this.question = propertyReader.getPropertyValue(fileLocation, "question");
        this.answer = propertyReader.getPropertyValue(fileLocation, "answer");
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
        return  EncodingService.convertUTF(userName);
       	}
	
	public void setLogin(String login) {
		this.userName = login;
	}
	
	public String getPassword() {
        return EncodingService.convertUTF(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

    public String getFullName() {
        return  EncodingService.convertUTF(fullName);
    }

    public String getEmail() {
        return EncodingService.convertUTF(email);
    }

    public String getFormAddress() {
        return  EncodingService.convertUTF(formAddress);
    }

    public String getCity() {
        return EncodingService.convertUTF(city);
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPost() {
        return EncodingService.convertUTF(post);
    }

    public String getPhone() {
        return phone;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getShortName(String email){
        int index = email.indexOf("@");
        return email.substring(0,index);
    }

    public String getFirstName(){
        int index = getFullName().indexOf(" ");
        return getFullName().substring(0,index);
    }

    public String getLastName(){
        int index = getFullName().indexOf(" ");
        return getFullName().substring(++index);
    }









}
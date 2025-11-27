package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
Faker faker = new Faker();
	
	public String createRandomUserName() {
		return faker.name().username();
	}
	
	public String createRandomPassword() {
		return faker.internet().password();
	}
	
	public String createRandomFullName() {
		return faker.name().fullName();
	}
	
	public String createRandomEmailAddress() {
		return faker.internet().emailAddress();
	}
}

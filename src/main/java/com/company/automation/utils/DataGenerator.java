package com.company.automation.utils;


import net.datafaker.Faker;
import org.springframework.stereotype.Component;


@Component
public class DataGenerator {

    private final Faker faker = new Faker();

    /***
     * Generates random Firstname string
     * @return random Firstname string
     */
    public String getRandomFirstName() {
        String firstName = "";
        try {
            firstName = faker.name().firstName();

        } catch (Exception e) {

        }
        return firstName;
    }

    /***
     * Generates random Middle name string
     * @return random Middle name string
     */
    public String getRandomMiddleName() {

        String middleName = "";
        try {
            middleName = faker.name().nameWithMiddle();

        } catch (Exception e) {

        }
        return middleName;
    }


    /***
     * Generates random Lastname string
     * @return random Lastname string
     */
    public String getRandomLastName() {
        return faker.name().lastName();
    }

    /***
     * Generates random Username string
     * @return random Username string
     */
    public String getRandomUserName() {
        return faker.name().username();
    }

    /***
     * Generates random Full name string
     * @return random Full name string
     */
    public String getRandomFullName() {
        return faker.name().fullName();
    }

    /***
     * Generates random string
     * @return random email address string
     */
    public String getRandomEmailAddress() {
        return faker.internet().emailAddress();
    }

    /***
     * Generates random password
     * @return random password string
     */
    public String getRandomPassword() {
        return faker.internet().password();
    }

    /***
     * Generates random query
     * @return random query string
     */
    public String getRandomIPAddress() {
        return faker.internet().ipV4Address();
    }

    /***
     * Generates random domain name
     * @return random domain name
     */
    public String getRandomDomainName() {
        return faker.internet().domainName();
    }

    /***
     * Generates random Building Number
     * @return random Building Number string
     */
    public String getRandomBuildingNumber() {
        return faker.address().buildingNumber();
    }

    /***
     * Generates random city
     * @return random city string
     */
    public String getRandomCity() {
        return faker.address().city();
    }

    /***
     * Generates random streetName
     * @return streetName  string
     */
    public String getRandomStreetName() {
        return faker.address().streetName();
    }

    /***
     * Generates random Country
     * @return random country string
     */
    public String getRandomCountry() {
        return faker.address().country();
    }

    /***
     * Generates random zipcode
     * @return random zipcode string
     */
    public String getRandomZipCode() {
        return faker.address().zipCode();
    }

    /***
     * Generates random Number
     * @return random Number String
     */
    public String getRandomNumber(int digit) {
        return faker.number().digits(digit);
    }

    /***
     * Generates random Number between
     * @return random Number integer
     */
    public int getRandomNumberBetween(int start, int end) {
        return faker.number().numberBetween(start, end);
    }

    /***
     * Generates random alphanumeric string
     * @return random alphanumeric string
     */
    public String getRandomAlphaNumericData(int digit, boolean includeUpperCase, boolean includeDigit) {
        return faker.lorem().characters(digit, includeUpperCase, includeDigit);
    }

    /***
     * Generates random string
     * @return random string
     */
    public String getRandomStringData(int digit, boolean includeUpperCase, boolean includeDigit) {
        if (includeUpperCase)
            return faker.lorem().characters(digit, true, includeDigit).toUpperCase();
        else
            return faker.lorem().characters(digit, false, includeDigit).toLowerCase();
    }

    /***
     * Generates random phone number string
     * @return random phone number string
     */
    public String getRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    /***
     * Generates random Cell number string
     * @return random Cell number string
     */
    public String getRandomMobileNumber() {
        return faker.phoneNumber().cellPhone();
    }

    /***
     * Generates random job title
     * @return random job title string
     */
    public String getRandomJobTitle() {
        return faker.job().title();
    }

    /***
     * Generates random job position
     * @return random job position string
     */
    public String getRandomJobPosition() {
        return faker.job().position();
    }

    /***
     * Generates random job seniority
     * @return random job seniority string
     */
    public String getRandomJobSeniority() {
        return faker.job().seniority();
    }

    /***
     * Generates random job KeySkills
     * @return random job KeySkills string
     */
    public String getRandomJobKeySkills() {
        return faker.job().keySkills();
    }

    /***
     * Generates random credit Card Number
     * @return random credit Card Number string
     */
    public String getRandomCreditCardNumber() {
        return faker.business().creditCardNumber();
    }

    /***
     * Generates random credit Card Type
     * @return random credit Card Type string
     */
    public String getRandomCreditCardType() {
        return faker.business().creditCardType();
    }

    /***
     * Generates random credit Card Expiry
     * @return random credit Card Expiry string
     */
    public String getRandomCreditCardExpiry() {
        return faker.business().creditCardExpiry();
    }

    /***
     * Generates random Product Name
     * @return random Product Name string
     */
    public String getRandomProductName() {
        return faker.commerce().productName();
    }

    /***
     * Generates random Promotion Code
     * @return random Promotion Code string
     */
    public String getRandomPromotionCode(int digit) {
        return faker.commerce().promotionCode(digit);
    }

    /***
     * Generates random Department
     * @return random Department string
     */
    public String getRandomDepartment() {
        return faker.commerce().department();
    }

    /***
     * Generates random material
     * @return random material string
     */
    public String getRandomMaterial() {
        return faker.commerce().material();
    }

    /***
     * Generates random Price
     * @return random Price string
     */
    public String getRandomPrice() {
        return faker.commerce().price();
    }

    /***
     * Generates random Color
     * @return random Color string
     */
    public String getRandomColor() {
        return faker.color().name();
    }

    /***
     * Generates random Currency Name
     * @return random Currency Name string
     */
    public String getRandomCurrencyName() {
        return faker.currency().name();
    }

    /***
     * Generates random Currency Code
     * @return random Currency Code string
     */
    public String getRandomCurrencyCode() {
        return faker.currency().code();
    }

    /***
     * Generates random Sex
     * @return random Sex string
     */
    public String getRandomSex() {
        return faker.demographic().sex();
    }

    /***
     * Generates random Marital Status
     * @return random Marital Status string
     */
    public String getRandomMaritalStatus() {
        return faker.demographic().maritalStatus();
    }

    /***
     * Generates random educational Attainment
     * @return random educationalAttainment string
     */
    public String getRandomEducationalAttainment() {
        return faker.demographic().educationalAttainment();
    }

    /***
     * Generates random BirthDate
     * @return random BirthDate string
     */
    public String getRandomBirthDate() {
        return faker.date().birthday().toString();
    }

    /***
     * Generates random Birth Date between
     * @return random Birth Date between string
     */
    public String getRandomBirthDateBetween(int minAge, int maxAge) {
        return faker.date().birthday(minAge, maxAge).toString();
    }

 //    public static void main(String[] args) {

        /*System.out.println("First Name: " + getRandomFirstName());
        System.out.println("Middle Name: " + getRandomMiddleName());
        System.out.println("Last Name: " + getRandomLastName());
        System.out.println("User Name:" + getRandomUserName());
        System.out.println("Full Name: " + getRandomFullName());

        System.out.println("Email Address: " + getRandomEmailAddress());
        System.out.println("Password: " + getRandomPassword());
        System.out.println("IP Address: " + getRandomIPAddress());
        System.out.println("Domain Name: " + getRandomDomainName());

        System.out.println("Building Number: " + getRandomBuildingNumber());
        System.out.println("City: " + getRandomCity());
        System.out.println("Street Name: " + getRandomStreetName());
        System.out.println("Country Name: " + getRandomCountry());
        System.out.println("Zip Code: " + getRandomZipCode());

        System.out.println("Number: " + getRandomNumber(10));
        System.out.println("Number: " + "01" + getRandomNumber(7));
        System.out.println("Number Between: " + getRandomNumberBetween(1000, 9999));

        System.out.println("Alphanumeric Value: " + getRandomAlphaNumericData(10, true, true));
        System.out.println("Alphanumeric Value: " + getRandomAlphaNumericData(10, true, false));
        System.out.println("String Value: " + getRandomStringData(10, true, false));

        System.out.println("Phone Number: " + getRandomPhoneNumber());
        System.out.println("Mobile Number: " + getRandomMobileNumber());

        System.out.println("Job Title: " + getRandomJobTitle());
        System.out.println("Job Position: " + getRandomJobPosition());
        System.out.println("Job Seniority: " + getRandomJobSeniority());
        System.out.println("Job Key Skills: " + getRandomJobKeySkills());

        System.out.println("Credit Card Number: " + getRandomCreditCardNumber());
        System.out.println("Credit CardT ype: " + getRandomCreditCardType());
        System.out.println("Credit Card Expiry: " + getRandomCreditCardExpiry());

        System.out.println("Product Name: " + getRandomProductName());
        System.out.println("Promotion Code: " + getRandomPromotionCode(4));
        System.out.println("Department: " + getRandomDepartment());
        System.out.println("Material: " + getRandomMaterial());
        System.out.println("Price: " + getRandomPrice());
        System.out.println("Color: " + getRandomColor());

        System.out.println("Currency Name: " + getRandomCurrencyName());
        System.out.println("Currency Code: " + getRandomCurrencyCode());

        System.out.println("Sex: " + getRandomSex());
        System.out.println("Marital Status: " + getRandomMaritalStatus());
        System.out.println("Educational Attainment: " + getRandomEducationalAttainment());

        System.out.println("Birth Date: " + getRandomBirthDate());
        System.out.println("Birth Date Between: " + getRandomBirthDateBetween(18, 99));*/
    //}
}

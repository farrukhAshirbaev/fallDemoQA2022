package HomeWork.RegistrationForm;

import com.github.javafaker.Faker;

public class Users {
    String fName = generateFakeFirstName();
    String lName = generateFakeLastName();
    String eMail = generateFakeEmail();
    String age = generateFakeNumber();
    String salary = generateFakeSalary();
    String department = generateFakeDepartment();
    static Faker faker = new Faker();



    public static String generateFakeFirstName(){return faker.name().firstName();}
    public static String generateFakeLastName(){return faker.name().lastName();}
    public static String generateFakeEmail(){return faker.internet().emailAddress();}
    public static String generateFakeNumber(){return faker.number().digit();}
    public static String generateFakeSalary(){return faker.number().digit();}
    public static String generateFakeDepartment(){return faker.country().name();}
}

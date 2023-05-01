import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<String> registrationNumbers = new ArrayList<>();
    private static final int maxCarCount = 3;
    private String firstName;
    private String lastName;
    private String address;
    private int carsCount = 0;
    private int id;

    public Person() {
        this.firstName = "unknown";
        this.lastName = "unknown";
        this.address = "unknown";
        this.carsCount = 0;
    }

    public Person(String firstName, String lastName, String address, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.id = id;
    }

    public Person(String firstName, String lastName, String address, int id, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.id = id;
        this.registrationNumbers.add(car.getRegistrationNumber());
        carsCount++;
    }

    public void addCarRegistrationNumber(String registrationNumber) {
        if (carsCount < maxCarCount) {
            registrationNumbers.add(registrationNumber);
            carsCount++;
            System.out.println("Registration number added correctly");
        } else {
            System.out.println("Person can't have more cars!");
        }
    }

    public void removeCarRegistrationNumber(String registrationNumber) {
        if (!registrationNumbers.contains(registrationNumber)) {
            System.out.println("Person doesn't have cars with that registration numbers!");
        } else {
            registrationNumbers.remove(registrationNumber);
            System.out.println("Registration number deleted correctly");
            carsCount--;
        }
    }

    public static int getMaxCarCount() {
        return maxCarCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCarsCount() {
        return carsCount;
    }

    public void setCarsCount(int carsCount) {
        this.carsCount = carsCount;
    }

    @Override
    public String toString() {
        return "\nPerson: " + id +
                "\nRegistrationNumbers = " + registrationNumbers +
                "\nFirstName = " + firstName +
                "\nLastName = " + lastName +
                "\nAddress = " + address +
                "\nCarsCount = " + carsCount + "\n";
    }
}
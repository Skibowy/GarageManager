import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersonView {

    private CarView carView;
    PersonView(CarView carView){
        this.carView = carView;
    }

    public Person getPerson(int id) {
        return peopleList.stream().filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no person with that id"));
    }

    Scanner scanner = new Scanner(System.in);
    public List<Person> peopleList = new ArrayList<>();
    private boolean shouldContinue = true;

    public void manage(){
        shouldContinue = true;
        while (shouldContinue) {
            System.out.println("\nSelect an option to continue:");
            System.out.println("------------*******------------");
            System.out.println("1. Add person");
            System.out.println("2. Add car registration number");
            System.out.println("3. Remove car registration number");
            System.out.println("4. Show details");
            System.out.println("5. Display people count");
            System.out.println("6. Back");
            System.out.println("------------*******------------\n");


            int userChoice = scanner.nextInt();

            switch (userChoice){
                case 1 -> addPerson();
                case 2 -> addCarRegistrationNumber();
                case 3 -> removeCarRegistrationNumber();
                case 4 -> details();
                case 5 -> System.out.println(peopleList.size());
                case 6 -> shouldContinue = false;
            }
        }
    }

    private void addCarRegistrationNumber(){
        Scanner scannerAddCarRegistrationNumber = new Scanner(System.in);
        System.out.println("Person id:");
        int id = scannerAddCarRegistrationNumber.nextInt();
        scannerAddCarRegistrationNumber.skip("\\R?");
        System.out.println("Registration number:");
        String registrationNumber = scannerAddCarRegistrationNumber.nextLine().toUpperCase();
        getPerson(id).addCarRegistrationNumber(registrationNumber);
    }

    private void removeCarRegistrationNumber(){
        Scanner scannerAddCarRegistrationNumber = new Scanner(System.in);
        System.out.println("Person id:");
        int id = scannerAddCarRegistrationNumber.nextInt();
        scannerAddCarRegistrationNumber.skip("\\R?");
        System.out.println("Registration number:");
        String registrationNumber = scannerAddCarRegistrationNumber.nextLine().toUpperCase();
        getPerson(id).removeCarRegistrationNumber(registrationNumber);
    }

    private void addPerson() {
        Scanner scannerAddPerson = new Scanner(System.in);
        System.out.println("First name:");
        String firstName = scannerAddPerson.nextLine();
        System.out.println("Last name:");
        String lastName = scannerAddPerson.nextLine();
        System.out.println("Address:");
        String address = scannerAddPerson.nextLine();
        System.out.println("Id:");
        int id = scannerAddPerson.nextInt();
        scannerAddPerson.skip("\\R?");
        System.out.println("Person added!");

        peopleList.add(new Person(firstName, lastName, address, id));
    }

    public void details(){
        for (Person person : peopleList){
            System.out.println(person.toString());
        }
    }

    public void fillPeople() {
        Person person1 = new Person("Bartosz", "Dawiskiba", "ul. Słowackiego 34", 1, carView.carList.get(0));
        Person person2 = new Person();
        person2.setFirstName("Jakub");
        person2.setLastName("Rybak");
        person2.setAddress("ul. Mickiewicza 12");
        person2.setId(2);
        person2.addCarRegistrationNumber(carView.carList.get(3).getRegistrationNumber());
        Person person3 = new Person("Mateusz", "Dawiskiba", "ul. Słowackiego 34", 3, carView.carList.get(5));
        peopleList.add(person1);
        peopleList.add(person2);
        peopleList.add(person3);
    }
}

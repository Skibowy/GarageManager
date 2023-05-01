import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarView {

    Scanner scanner = new Scanner(System.in);
    private boolean shouldContinue = true;
    public List<Car> carList = new ArrayList<>();

/*    public Car getCar(String number) {
        for (Car car : carList){
            if(car.getRegistrationNumber().equalsIgnoreCase(number)){
                return car;
            }
        }
        throw new NoSuchElementException("dupa zbita");
    }*/

    public Car getCar(String number) {
        return carList.stream()
                .filter(car -> car.getRegistrationNumber().equalsIgnoreCase(number))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no car with that registration number!"));
    }


    public void manage(){
        shouldContinue = true;
        while (shouldContinue) {
            System.out.println("\nSelect an option to continue:");
            System.out.println("------------*******------------");
            System.out.println("1. Add car");
            System.out.println("2. Calculate consumption");
            System.out.println("3. Calculate cost");
            System.out.println("4. Show details");
            System.out.println("5. Display car count");
            System.out.println("6. Back");
            System.out.println("------------*******------------\n");


        int userChoice = scanner.nextInt();

            switch (userChoice){
                case 1 -> addCar();
                case 2 -> calculateConsump();
                case 3 -> calculateCost();
                case 4 -> details();
                case 5 -> System.out.println(carList.size());
                case 6 -> shouldContinue = false;
            }
        }
    }

    public void details() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
    private void calculateConsump(){
        Scanner scannerConsump = new Scanner(System.in);
        System.out.println("Registration number:");
        String registrationNumber = scannerConsump.nextLine();
        System.out.println("Road length (km):");
        double roadLength = scannerConsump.nextDouble();
        System.out.println(getCar(registrationNumber).calculateConsump(roadLength));
    }
    private void calculateCost(){
        Scanner scannerCost = new Scanner(System.in);
        System.out.println("Registration number:");
        String registrationNumber = scannerCost.nextLine();
        System.out.println("Road length (km):");
        double roadLength = scannerCost.nextDouble();
        System.out.println("Petrol cost (zł):");
        double petrolCost = scannerCost.nextDouble();
        System.out.println(getCar(registrationNumber).calculateCost(roadLength, petrolCost));
    }
    private void addCar() {
        Scanner scannerAddCar = new Scanner(System.in);
        System.out.println("Brand:");
        String brand = scannerAddCar.nextLine();
        System.out.println("Model:");
        String modell = scannerAddCar.nextLine();
        System.out.println("Door count:");
        int doorCount = scannerAddCar.nextInt();
        System.out.println("Engine volume:");
        double engineVolume = scannerAddCar.nextDouble();
        System.out.println("Average Consumption:");
        double avgConsump = scannerAddCar.nextDouble();
        scannerAddCar.skip("\\R?");
        System.out.println("Registration number:");
        String registrationNumber = scannerAddCar.nextLine();

        System.out.println("Car added!");

        carList.add(new Car(brand, modell, doorCount, engineVolume, avgConsump, registrationNumber));
    }

    public void fillCars() {
        Car car1 = new Car();
        car1.setBrand("Ford");
        car1.setModell("Mondeo");
        car1.setDoorCount(5);
        car1.setEngineVolume(2.0);
        car1.setAvgConsump(5.6);
        car1.setRegistrationNumber("SC4420E");
        Car car2 = new Car("Alfa", "Romeo", 4, 1.9, 7.2, "SC7220X");
        System.out.println(car1);
        double routeConsumption = car2.calculateConsump(500);
        System.out.println("Route consumption: " + routeConsumption);
        double routeCost = car2.calculateCost(500, 7.89);
        System.out.println("Route cost: " + routeCost);
        Car car3 = new Car("Audi", "A8", 4, 3.0, 16.2, "SC570CN");
        Car car4 = new Car("Volkswagen", "Polo", 3, 1.4, 5.1, "SC12345");
        Car car5 = new Car("Audi", "A6", 4, 3.0, 7.6, "SC8888L");
        Car car6 = new Car("Citroen", "C2", 3, 1.1, 5.9, "SC7947R");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GarageView {

    private CarView carView;
    GarageView(CarView carView){
        this.carView = carView;
    }

    public Garage getGarage(String name) {
        return garageList.stream().filter(garage -> garage.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no garage with that name"));
    }

    Scanner scanner = new Scanner(System.in);
    public List<Garage> garageList = new ArrayList<>();
    private boolean shouldContinue = true;


    public void manage(){
        shouldContinue = true;
        while (shouldContinue) {
            System.out.println("\nSelect an option to continue:");
            System.out.println("------------*******------------");
            System.out.println("1. Add garage");
            System.out.println("2. Put the car in the garage");
            System.out.println("3. Drive the car out of the garage");
            System.out.println("4. Show details");
            System.out.println("5. Display garage count");
            System.out.println("6. Back");
            System.out.println("------------*******------------\n");


            int userChoice = scanner.nextInt();

            switch (userChoice){
                case 1 -> addGarage();
                case 2 -> carIn();
                case 3 -> carOut();
                case 4 -> details();
                case 5 -> System.out.println(garageList.size());
                case 6 -> shouldContinue = false;
            }
        }
    }

    private void carIn(){
        Scanner scannerCarIn = new Scanner(System.in);
        System.out.println("Garage name:");
        String name = scannerCarIn.nextLine();
        System.out.println("Registration number:");
        String registrationNumber = scannerCarIn.nextLine();
        getGarage(name).carIn(carView.getCar(registrationNumber));
    }

    private void carOut(){
        Scanner scannerCarOut = new Scanner(System.in);
        System.out.println("Garage name:");
        String name = scannerCarOut.nextLine();
        System.out.println("Registration number:");
        String registrationNumber = scannerCarOut.nextLine();
        getGarage(name).carOut(carView.getCar(registrationNumber));
    }

    private void addGarage() {
        Scanner scannerAddGarage = new Scanner(System.in);
        System.out.println("Name:");
        String name = scannerAddGarage.nextLine();
        System.out.println("Address:");
        String address = scannerAddGarage.nextLine();
        System.out.println("Capacity:");
        int capacity = scannerAddGarage.nextInt();
        scannerAddGarage.skip("\\R?");
        System.out.println("Garage added!");

        garageList.add(new Garage(name, address, capacity));
    }

    public void details(){
        for (Garage garage : garageList){
            System.out.println(garage.toString());
        }
    }
    public void fillGarages() {
        Garage garage1 = new Garage();
        garage1.setName("Hostel");
        garage1.setAddress("ul. Garażowa 1");
        garage1.setCapacity(2);
        garageList.add(garage1);
        Garage garage2 = new Garage("Stacherczak","al. Kościuszki 1", 2);
        garageList.add(garage2);
        garage2.carIn(carView.getCar("SC8888L"));
        garage2.carIn(carView.getCar("SC570CN"));
    }
}

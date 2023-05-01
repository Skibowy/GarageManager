import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarView carView = new CarView();
        carView.fillCars();
        GarageView garageView = new GarageView(carView);
        garageView.fillGarages();
        PersonView personView = new PersonView(carView);
        personView.fillPeople();

        System.out.println("\r\n=========================================\r\n");

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        System.out.println("Welcome to the Garage Manager!");
        while(shouldContinue){
            System.out.println("\nSelect an option to continue:");
            System.out.println("------------*******------------");
            System.out.println("1. Cars");
            System.out.println("2. Garages");
            System.out.println("3. People");
            System.out.println("4. Quit");
            System.out.println("------------*******------------\n");

            int userChoice = scanner.nextInt();
            scanner.skip("\\R?");

            switch (userChoice){
                case 1 -> carView.manage();
                case 2 -> garageView.manage();
                case 3 -> personView.manage();
                case 4 -> {
                    System.out.println("See you again!");
                    shouldContinue = false;
                }
            }
        }
    }
}
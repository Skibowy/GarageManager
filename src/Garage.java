import java.util.ArrayList;
import java.util.List;

public class Garage {
    private String name;
    private String address;
    private int carsCount;
    private int capacity;
    private List<Car> carList = new ArrayList<>();

    public Garage(){
        this.name = "unknown";
        this.address = "unknown";
        this.carsCount = 0;
        this.capacity = 0;
    }

    public Garage(String name, String address, int capacity){
        this.name = name;
        this.address = address;
        this.carsCount = 0;
        this.capacity = capacity;
    }

    public String getName(){ return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int _capacity) {
        this.capacity = _capacity;
    }

    public void carIn(Car car){
        if(carList.contains(car)){
            System.out.println("This car is already parked here!");
            return;
        }
        if (carList.size() >= capacity) {
            System.out.println("No space");
        } else {
            carList.add(car);
            System.out.println("The car was succesfully parked in Garage");
            carsCount++;
        }
    }

    public void carOut(Car car){
        if(!carList.contains(car)){
            System.out.println("Ludzie, nikogo tu nie ma!...");
        }
        else{
            carList.remove(car);
            System.out.println("The car succesfully left the Garage");
            carsCount--;
        }
    }

    @Override
    public String toString() {
        return "\nGarage: " + name +
                "\nCars = " + carList +
                "\nAddress = " + address +
                "\nCarsCount = " + carsCount +
                "\nCapacity = " + capacity + "\n";
    }
}
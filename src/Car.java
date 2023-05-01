public class Car {

    private String brand;
    private String modell;
    private int doorCount;
    private double engineVolume;
    private double avgConsump;
    private String registrationNumber;

    public Car(){
        this.brand = "unknown";
        this.modell = "unknown";
        this.doorCount = 0;
        this.engineVolume = 0.0F;
        this.avgConsump = 0.0;
        this.registrationNumber = "unknown";
    }

    public Car(String brand, String modell, int doorCount, double engineVolume, double avgConsump, String registrationNumber) {
        this.brand = brand;
        this.modell = modell;
        this.doorCount = doorCount;
        this.engineVolume = engineVolume;
        this.registrationNumber = registrationNumber;
        this.avgConsump = avgConsump;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String _brand) {
        this.brand = _brand;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String _model) {
        this.modell = _model;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int _doorCount) {
        this.doorCount = _doorCount;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double _engineVolume) {
        this.engineVolume = _engineVolume;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String _registrationNumber) {
        this.registrationNumber = _registrationNumber;
    }

    public double getAvgConsump() {
        return avgConsump;
    }

    public void setAvgConsump(double _avgConsump) {
        this.avgConsump = _avgConsump;
    }

    @Override
    public String toString() {
        return "\nCar:" +
                "\nBrand = " + brand +
                "\nModel = " + modell +
                "\nDoorCount = " + doorCount +
                "\nEngineVolume = " + engineVolume +
                "\nAvgConsump = " + avgConsump +
                "\nRegistrationNumber = " + registrationNumber + "\n";
    }

    public double calculateConsump(double roadLength){
        return (this.avgConsump * roadLength) / 100.0;
    }

    public double calculateCost(double roadLength, double petrolCost){
        return (calculateConsump(roadLength) * petrolCost);
    }
}
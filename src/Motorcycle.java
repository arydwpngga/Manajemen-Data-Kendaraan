public class Motorcycle extends Vehicle {

    public Motorcycle(int id, String brand, String model) {
        super(id, brand, model);
    }

    @Override // Polimorfisme: Overriding
    public String displayInfo() {
        return String.format("| %-2d | %-11s | %-10s | %-10s |", getId(), "Motorcycle", getBrand(), getModel());
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}
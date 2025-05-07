// Inheritance dari Vehicle
public class Car extends Vehicle {

    public Car(int id, String brand, String model) {
        super(id, brand, model); // super: panggil constructor dari superclass
    }

    @Override // ✅ Polimorfisme: Overriding
    public String displayInfo() {
        return String.format("| %-2d | %-11s | %-10s | %-10s |", getId(), "Car", getBrand(), getModel());
    }

    @Override
    public String getType() {
        return "Car";
    }
}

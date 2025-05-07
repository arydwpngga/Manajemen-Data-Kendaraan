// Inheritance: superclass untuk Car dan Motorcycle
public abstract class Vehicle {
    private int id;
    private String brand;
    private String model;

    public Vehicle() {} // Constructor kosong (overloading)

    public Vehicle(int id, String brand, String model) { // Constructor overloading
        this.id = id; // this: mengakses field dalam class
        this.brand = brand;
        this.model = model;
    }

    // Setter & Getter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    // Method abstract untuk overriding (polimorfisme: overriding)
    public abstract String displayInfo();

    // Method return
    public abstract String getType();
}

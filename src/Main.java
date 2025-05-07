import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleDAO dao = new VehicleDAO(); // Object DAO (manipulasi data)
        int choice;

        do {
            System.out.println("=== Vehicle Manager ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter type (Car/Motorcycle): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    Vehicle vehicle = type.equalsIgnoreCase("Car")
                        ? new Car(0, brand, model) // Object dan inheritance
                        : new Motorcycle(0, brand, model);
                    dao.addVehicle(vehicle); // Manipulasi objek (CRUD)
                }
                case 2 -> {
                    List<Vehicle> list = dao.getAllVehicles();
                    System.out.println("+----+-------------+------------+------------+");
                    System.out.println("| ID | Type        | Brand      | Model      |");
                    System.out.println("+----+-------------+------------+------------+");
                    for (Vehicle v : list) {
                        System.out.println(v.displayInfo()); // Overriding
                    }
                    System.out.println("+----+-------------+------------+------------+");
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter new model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter type (Car/Motorcycle): ");
                    String type = scanner.nextLine();
                    Vehicle vehicle = type.equalsIgnoreCase("Car")
                        ? new Car(id, brand, model)
                        : new Motorcycle(id, brand, model);
                    dao.updateVehicle(vehicle);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();
                    dao.deleteVehicle(id);
                }
            }
        } while (choice != 0);

        scanner.close(); //Menutup Scanner
    }
}

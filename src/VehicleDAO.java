import java.sql.*;
import java.util.*;

public class VehicleDAO {

    // CRUD - Add Vehicle (connect ke SQL + Create)
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (type, brand, model) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getType());
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getModel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                // ✅ Polimorfisme: objek dibuat secara dinamis berdasarkan tipe
                Vehicle vehicle = type.equalsIgnoreCase("Car")
                        ? new Car(id, brand, model)
                        : new Motorcycle(id, brand, model);
                list.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET brand=?, model=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setInt(3, vehicle.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

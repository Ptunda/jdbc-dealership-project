package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {

        this.dataSource = dataSource;

    }

    public void addVehicle(Vehicle vehicle) {


        String insertVehicleSQL = "INSERT INTO vehicles\n" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertVehiclePreparedStatement = connection.prepareStatement(insertVehicleSQL)
        ) {

            insertVehiclePreparedStatement.setString(1, vehicle.getVin());
            insertVehiclePreparedStatement.setString(2, vehicle.getMake());
            insertVehiclePreparedStatement.setString(3, vehicle.getModel());
            insertVehiclePreparedStatement.setInt(4, vehicle.getYear());
            insertVehiclePreparedStatement.setBoolean(5, vehicle.isSold());
            insertVehiclePreparedStatement.setString(6, vehicle.getColor());
            insertVehiclePreparedStatement.setString(7, vehicle.getColor());
            insertVehiclePreparedStatement.setInt(8, vehicle.getOdometer());
            insertVehiclePreparedStatement.setDouble(9, vehicle.getPrice());

            insertVehiclePreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error adding vehicle" + e.getMessage());

        }

    }

    public void removeVehicle(String VIN) {

        
        String removeVehicleSQL = "DELETE FROM vehicles\n" + "WHERE VIN = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement removeVehiclePreparedStatement = connection.prepareStatement(removeVehicleSQL)
        ) {

            removeVehiclePreparedStatement.setString(1, VIN);

            removeVehiclePreparedStatement.executeUpdate();

        }catch (SQLException e){

            System.out.println("Error removing vehicle. " + e.getMessage());

        }

    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        // TODO: Implement the logic to search vehicles by price range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        // TODO: Implement the logic to search vehicles by make and model
        return new ArrayList<>();
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        // TODO: Implement the logic to search vehicles by year range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByColor(String color) {
        // TODO: Implement the logic to search vehicles by color
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        // TODO: Implement the logic to search vehicles by mileage range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByType(String type) {
        // TODO: Implement the logic to search vehicles by type
        return new ArrayList<>();
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {

        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;

    }
}

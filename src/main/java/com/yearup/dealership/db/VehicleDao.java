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

        try (Connection connection = dataSource.getConnection();
             PreparedStatement removeVehiclePreparedStatement = connection.prepareStatement(removeVehicleSQL)
        ) {

            removeVehiclePreparedStatement.setString(1, VIN);

            removeVehiclePreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error removing vehicle. " + e.getMessage());

        }

    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {


        List<Vehicle> vehicles = new ArrayList<>();

        String searchByPriceRangeSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE price BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByPriceRangePreparedStatement = connection.prepareStatement(searchByPriceRangeSQL)
        ) {

            searchByPriceRangePreparedStatement.setDouble(1, minPrice);
            searchByPriceRangePreparedStatement.setDouble(2, maxPrice);

            try (ResultSet resultSet = searchByPriceRangePreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String userInputMake, String userInputModel) {


        List<Vehicle> vehicles = new ArrayList<>();

        String searchByMakeModelSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE make = ? AND model = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByMakeModelPreparedStatement = connection.prepareStatement(searchByMakeModelSQL)
        ) {

            searchByMakeModelPreparedStatement.setString(1, userInputMake);
            searchByMakeModelPreparedStatement.setString(2, userInputModel);

            try (ResultSet resultSet = searchByMakeModelPreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;

    }

    public List<Vehicle> searchByYearRange(int userInputMinYear, int userInputMaxYear) {


        List<Vehicle> vehicles = new ArrayList<>();

        String searchByMakeModelSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE year BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByMakeModelPreparedStatement = connection.prepareStatement(searchByMakeModelSQL)
        ) {

            searchByMakeModelPreparedStatement.setInt(1, userInputMinYear);
            searchByMakeModelPreparedStatement.setInt(2, userInputMaxYear);

            try (ResultSet resultSet = searchByMakeModelPreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;

    }

    public List<Vehicle> searchByColor(String userInputColor) {


        List<Vehicle> vehicles = new ArrayList<>();

        String searchByColorSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE color = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByColorPreparedStatement = connection.prepareStatement(searchByColorSQL)
        ) {

            searchByColorPreparedStatement.setString(1, userInputColor);


            try (ResultSet resultSet = searchByColorPreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int userInputMinMileage, int userInputMaxMileage) {


        List<Vehicle> vehicles = new ArrayList<>();

        String searchByMileageRangeSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE odometer BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByMileageRangePreparedStatement = connection.prepareStatement(searchByMileageRangeSQL)
        ) {

            searchByMileageRangePreparedStatement.setInt(1, userInputMinMileage);
            searchByMileageRangePreparedStatement.setInt(2, userInputMaxMileage);

            try (ResultSet resultSet = searchByMileageRangePreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;
    }

    public List<Vehicle> searchByType(String userInputType) {

        
        List<Vehicle> vehicles = new ArrayList<>();

        String searchByTypeSQL = "SELECT *\n" + "FROM vehicles\n" + "WHERE vehicleType = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement searchByTypePreparedStatement = connection.prepareStatement(searchByTypeSQL)
        ) {

            searchByTypePreparedStatement.setString(1, userInputType);


            try (ResultSet resultSet = searchByTypePreparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    String VIN = resultSet.getString(1);
                    String make = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    boolean sold = resultSet.getBoolean(5);
                    String color = resultSet.getString(6);
                    String vehicleType = resultSet.getString(7);
                    int odometer = resultSet.getInt(8);
                    double price = resultSet.getDouble(9);

                    Vehicle vehicle = new Vehicle(VIN, make, model, year, sold, color, vehicleType, odometer, price);

                    vehicles.add(vehicle);

                }

            }

        } catch (SQLException e) {

            System.out.println("Error finding vehicles. " + e.getMessage());

        }

        return vehicles;
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

package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {

    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {

        this.dataSource = dataSource;

    }

    public void addVehicleToInventory(String vin, int dealershipId) {


        String insertVehicleInInventorySQL = "INSERT INTO inventory\n" + "VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertVehiclePreparedStatement = connection.prepareStatement(insertVehicleInInventorySQL)
        ) {

            insertVehiclePreparedStatement.setInt(1, dealershipId);
            insertVehiclePreparedStatement.setString(2, vin);

            insertVehiclePreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error adding vehicle to inventory " + e.getMessage());

        }

    }

    public void removeVehicleFromInventory(String vin) {

        
        String removeVehicleFromInventorySQL = "DELETE FROM inventory\n" + "WHERE VIN = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement removeVehiclepreparedStatement = connection.prepareStatement(removeVehicleFromInventorySQL)
        ) {

            removeVehiclepreparedStatement.setString(1, vin);

            removeVehiclepreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error removing vehicle from inventory " + e.getMessage());

        }

    }
}

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

        // TODO: Implement the logic to add a vehicle to the inventory
        String insertVehicleInInventorySQL = "INSERT INTO inventory\n" + "VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement insertVehiclePreparedStatement = connection.prepareStatement(insertVehicleInInventorySQL)
        ){

            insertVehiclePreparedStatement.setInt(1, dealershipId);
            insertVehiclePreparedStatement.setString(2, vin);

            insertVehiclePreparedStatement.executeUpdate();

        } catch (SQLException e){

            e.printStackTrace();

        }

    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory
    }
}

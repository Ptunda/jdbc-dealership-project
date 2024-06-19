package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {

    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {

        this.dataSource = dataSource;

    }

    public void addSalesContract(SalesContract salesContract) {


        String insertSalesContractSQL = "INSERT INTO sales_contracts (contract_id, VIN, sales_date, price)\n" +
                                        "VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertLeaseContractPreparedStatement = connection.prepareStatement(insertSalesContractSQL)
        ) {

            insertLeaseContractPreparedStatement.setInt(1, salesContract.getContractId());
            insertLeaseContractPreparedStatement.setString(2, salesContract.getVin());
            insertLeaseContractPreparedStatement.setDate(3, Date.valueOf(salesContract.getSaleDate()));
            insertLeaseContractPreparedStatement.setDouble(4, salesContract.getPrice());

            insertLeaseContractPreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.err.println("Error adding lease contract " + e.getMessage());

        }

    }

}

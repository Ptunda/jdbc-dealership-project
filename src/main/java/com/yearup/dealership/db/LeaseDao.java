package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {

    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {

        this.dataSource = dataSource;

    }

    public void addLeaseContract(LeaseContract leaseContract) {


        String insertLeaseContractSQL = "INSERT INTO lease_contracts (contract_id, VIN, lease_start, lease_end, monthly_payment)\n" +
                                        "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertLeaseContractPreparedStatement = connection.prepareStatement(insertLeaseContractSQL)
        ) {

            insertLeaseContractPreparedStatement.setInt(1, leaseContract.getContractId());
            insertLeaseContractPreparedStatement.setString(2, leaseContract.getVin());
            insertLeaseContractPreparedStatement.setDate(3, Date.valueOf(leaseContract.getLeaseStart()));
            insertLeaseContractPreparedStatement.setDate(4, Date.valueOf(leaseContract.getLeaseEnd()));
            insertLeaseContractPreparedStatement.setDouble(5, leaseContract.getMonthlyPayment());

            insertLeaseContractPreparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error adding lease contract " + e.getMessage());

        }

    }
}

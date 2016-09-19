package com.formation.emma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.formation.emma.metier.Customer;

public class JDBCCustomerDAO implements CustomerDAO {

	private DataSource dataSource;

	@Override
	public Customer findCustomerById(int id) {
		Customer cust = null;
		String sql = "select*from customer where cust_id=?";
		Connection conn = null;
		PreparedStatement stat = null;

		try {
			conn = dataSource.getConnection();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet result = stat.executeQuery();

			if (result.next()) {
				cust = new Customer(result.getInt("cust_id"), result.getString("name"), result.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cust;
	}

	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql); //initialise l'entrée des valeurs
			ps.setInt(1, customer.getCust_Id()); // charge les valeurs dans le sql
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			System.out.println(ps.toString());

			ps.executeUpdate(); // execute sql dans la bdd

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

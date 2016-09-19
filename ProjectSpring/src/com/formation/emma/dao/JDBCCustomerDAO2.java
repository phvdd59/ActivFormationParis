package com.formation.emma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.formation.emma.metier.Customer;

public class JDBCCustomerDAO2 implements CustomerDAO {

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

//	public void insertCustomer(Customer customer) {
//
//		String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
//		Connection conn = null;
//
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, customer.getCust_Id());
//			ps.setString(2, customer.getName());
//			ps.setInt(3, customer.getAge());
//			ps.executeUpdate();
//			ps.close();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
//	}

	public void insertCustomer(Customer customer) {
		//insert into customer (cust_id,name,age) values (? , ? , ?);
		String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
//		String sql = "INSERT INTO CUSTOMER (NAME,AGE) values(?,?);"; //"?" permet de securiser les valeurs qu'on entre dans le sql
		Connection conn = null;
		PreparedStatement stat = null;

		try {
			conn = dataSource.getConnection();
			stat = conn.prepareStatement(sql); //initialise l'entrée des valeurs

			stat.setInt(1, customer.getCust_Id()); // charge les valeurs dans le sql
			stat.setString(2, customer.getName());
			stat.setInt(3, customer.getAge());
			System.out.println(stat.toString());

			stat.executeUpdate(sql); // execute sql dans la bdd

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

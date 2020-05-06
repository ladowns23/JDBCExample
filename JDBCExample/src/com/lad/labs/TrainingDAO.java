package com.lad.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TrainingDAO {
	List<Employee> employees = new ArrayList<>();

	public List<Employee> getAllEmployees() {
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527//trainingDb");
			stmt = conn.createStatement();
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			rs = stmt.executeQuery("select * from employee");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %n", rs.getMetaData().getColumnName(1),
					rs.getMetaData().getColumnName(2), rs.getMetaData().getColumnName(3),
					rs.getMetaData().getColumnName(4), rs.getMetaData().getColumnName(5));
			while (rs.next()) {
				long id = rs.getLong("EMPID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				int deptId = rs.getInt("DEPTID");
				int credits = rs.getInt("CREDITS");
				employees.add(new Employee(id, firstName, lastName, deptId, credits));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Collections.unmodifiableList(employees);
	}

}

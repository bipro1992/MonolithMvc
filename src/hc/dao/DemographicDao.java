package hc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hc.dto.Demographic;
import hc.dto.Employee;
import hc.dto.Employer;

public class DemographicDao {

	private Connection conn;

	@SuppressWarnings({ "resource"})
	public Employee getDemographicDetailsByEmployeeId(int employeeId) {

		conn = null;
		PreparedStatement preparedStatement = null;
		Employee employee = null;

		try {

			conn = ConnectionToDB.getConnect();

			String sql;
			sql = "SELECT demographic_id,employer_id FROM employee_details where employee_id = " + employeeId;
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
			
			if (rs.next()) {
				
				int employerId=rs.getInt("employer_id");
				
				sql = "SELECT * FROM Demographic where demographic_id = " + rs.getInt("demographic_id");
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

				ResultSet rs1 = preparedStatement.executeQuery(sql);

				if (rs1.next()) {

					employee= new Employee();
					Demographic demographic = new Demographic();

					demographic.setDemographicId(rs1.getInt("demographic_id"));
					demographic.setFirstName(rs1.getString("first_name"));
					demographic.setLastName(rs1.getString("last_name"));
					demographic.setAddress1(rs1.getString("address_1"));
					demographic.setAddress2(rs1.getString("address_2"));

					employee.setEmployeeId(employeeId);
					Employer er= new Employer();
					er.setEmployerId(employerId);
					employee.setEmployer(er);
					employee.setDemographic(demographic);
				}

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		} // end finally try

		return employee;

	}
	
	
	public void updateEmployee(Demographic demographic) {

		conn = null;
		PreparedStatement preparedStatement = null;

		try {

			conn = ConnectionToDB.getConnect();
			String sql;
			
				sql = "update Demographic set "
						+ "first_name=? "
						+ ",last_name=?,"
						+ "address_1=?,"
						+ "address_2=?"
						+"where demographic_id="+demographic.getDemographicId();
				preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setString(1, demographic.getFirstName());
				preparedStatement.setString(2, demographic.getLastName());
				preparedStatement.setString(3, demographic.getAddress1());
				preparedStatement.setString(4, demographic.getAddress2());

				preparedStatement.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (Exception se) {
				se.printStackTrace();
			}
		} //

	}


}

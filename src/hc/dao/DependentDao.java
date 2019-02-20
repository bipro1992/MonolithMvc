package hc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hc.dto.Demographic;
import hc.dto.Dependent;

public class DependentDao {

	private List<Dependent> dependents;

	private Connection conn;

	
	public List<Dependent> getDependents(int employeeId) {
		this.dependents = new ArrayList<>();

		conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = ConnectionToDB.getConnect();
			String sql;
			sql = "SELECT * FROM dependent_details where employee_id = " + employeeId;
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {
				
				Dependent dependent = new Dependent();
				dependent.setDependentId(rs.getInt("dependent_id"));
				dependent.setEmployeeId(employeeId);

				sql = "SELECT * FROM Demographic where demographic_id = " + rs.getInt("demographic_id");
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs1 = preparedStatement.executeQuery(sql);

				if (rs1.next()) {

					Demographic demographic = new Demographic();

					demographic.setDemographicId(rs1.getInt("demographic_id"));
					demographic.setFirstName(rs1.getString("first_name"));
					demographic.setLastName(rs1.getString("last_name"));
					demographic.setAddress1(rs1.getString("address_1"));
					demographic.setAddress2(rs1.getString("address_2"));

					dependent.setDemographic(demographic);

				}

				dependents.add(dependent);
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

		return dependents;
	}

}

package hc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hc.dto.Employer;

public class EmployerDao {

	private Connection conn;

	public Employer getEmployer(int employerId) {

		conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = ConnectionToDB.getConnect();

			String sql = "select * from employer where employer_id=" + employerId;
			preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);

			if (rs.next()) {
				Employer employer = new Employer();
				employer.setEmployerId(employerId);
				employer.setEmployerName(rs.getString("employer_name"));
				employer.setEmployerElection(rs.getDouble("election_amount"));

				return employer;
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

		return null;

	}

	public void updateEmployer(Employer employer) {

		conn = null;
		PreparedStatement preparedStatement = null;

		try {

			conn = ConnectionToDB.getConnect();
			String sql = "update employer set "
					+ "employer_name=? "
					+ ",election_amount=?"
					+"where employer_id="+employer.getEmployerId();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, employer.getEmployerName());
			preparedStatement.setDouble(2, employer.getEmployerElection());

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}

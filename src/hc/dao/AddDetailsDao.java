package hc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hc.dto.ClaimDetail;
import hc.dto.Dependent;
import hc.dto.Employee;
import hc.dto.Employer;

public class AddDetailsDao {

	private Connection conn;

	@SuppressWarnings("resource")
	public String addEmployee(Employee employee) {
		conn = null;
		PreparedStatement preparedStatement = null;
		String msg="";
		try {
			
			
			conn = ConnectionToDB.getConnect();

			String sql;
			//System.out.println(employee.getEmployer().getEmployerId());
			sql = "SELECT * FROM employer where employer_id = " + employee.getEmployer().getEmployerId();
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);

			if (rs.next()) {

				int employerId = rs.getInt("employer_id");

				// System.out.println("inside add");

				sql = "select max(demographic_id) as maxid from Demographic";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs1 = preparedStatement.executeQuery(sql);
				rs1.next();
				// System.out.println(rs1.getInt("maxid"));
				int maxId = rs1.getInt("maxid") + 1;
				// System.out.println(maxId);

				sql = "insert into Demographic values(?,?,?,?,?)";

				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				preparedStatement.setInt(1, maxId);
				preparedStatement.setString(2, employee.getDemographic().getFirstName());
				preparedStatement.setString(3, employee.getDemographic().getLastName());
				preparedStatement.setString(4, employee.getDemographic().getAddress1());
				preparedStatement.setString(5, employee.getDemographic().getAddress2());

				preparedStatement.executeUpdate();

				sql = "select max(employee_id) as maxid from employee_details";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs2 = preparedStatement.executeQuery(sql);

				// System.out.println(rs2.getInt("maxid"));
				rs2.next();
				int empmaxId = rs2.getInt("maxid") + 1;
				// System.out.println(employerId);

				sql = "insert into employee_details values(?,?,?)";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				preparedStatement.setInt(1, empmaxId);
				preparedStatement.setInt(2, maxId);
				preparedStatement.setInt(3, employerId);

				preparedStatement.executeUpdate();
				
				msg="Member has been successfully added with member ID: "+empmaxId;
				// preparedStatement.getConnection().commit();

				// System.out.println(rs1.getInt("maxid"));
				
				

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
		
		return msg;

	}

	@SuppressWarnings("resource")
	public String addClaim(ClaimDetail claimDetail) {

		conn = null;
		PreparedStatement preparedStatement = null;
		String msg="";
		try {
			
			conn = ConnectionToDB.getConnect();

			String sql="select * from employee_details where employee_id="+claimDetail.getEmployeeId();
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			
			if(rs.next())
			{
				sql = "select max(claim_detail_id) as maxid from claim_detail";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs1 = preparedStatement.executeQuery(sql);
				rs1.next();
				int maxId = rs1.getInt("maxid") + 1;
				
				sql="insert into claim_detail values(?,?,?,?,?,?)";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				preparedStatement.setInt(1,maxId);
				preparedStatement.setInt(2, claimDetail.getEmployeeId());
				preparedStatement.setDouble(3, claimDetail.getRequestedAmount());
				preparedStatement.setDouble(4, 0.0);
				preparedStatement.setDouble(5, 0.0);
				preparedStatement.setInt(6, 0);
				
				preparedStatement.executeUpdate();
				
				msg="Claim Detail has been successfully added with claim detail ID:"+maxId;
				
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
		} // en
		
		return msg;

	}
	
	
	
	@SuppressWarnings({ "resource"})
	public String addDependent(Dependent dependent)
	{
		conn = null;
		PreparedStatement preparedStatement = null;
		String msg="";
		try {

			conn = ConnectionToDB.getConnect();

			String sql;
			//System.out.println(employee.getEmployer().getEmployerId());
			sql = "SELECT * FROM employee_details where employee_id = " + dependent.getEmployeeId();
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);

			if (rs.next()) {

				

				// System.out.println("inside add");

				sql = "select max(demographic_id) as maxid from Demographic";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs1 = preparedStatement.executeQuery(sql);
				rs1.next();
				// System.out.println(rs1.getInt("maxid"));
				int maxId = rs1.getInt("maxid") + 1;
				// System.out.println(maxId);

				sql = "insert into Demographic values(?,?,?,?,?)";

				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				preparedStatement.setInt(1, maxId);
				preparedStatement.setString(2, dependent.getDemographic().getFirstName());
				preparedStatement.setString(3, dependent.getDemographic().getLastName());
				preparedStatement.setString(4, dependent.getDemographic().getAddress1());
				preparedStatement.setString(5, dependent.getDemographic().getAddress2());

				preparedStatement.executeUpdate();

				sql = "select max(dependent_id) as maxid from dependent_details";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rs2 = preparedStatement.executeQuery(sql);

				// System.out.println(rs2.getInt("maxid"));
				rs2.next();
				int depmaxId = rs2.getInt("maxid") + 1;
				// System.out.println(employerId);

				sql = "insert into dependent_details values(?,?,?)";
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				preparedStatement.setInt(1, depmaxId);
				preparedStatement.setInt(2, dependent.getEmployeeId());
				preparedStatement.setInt(3, maxId);

				preparedStatement.executeUpdate();
				
				msg="Dependent has been added with dependent ID: "+depmaxId;

				// preparedStatement.getConnection().commit();

				// System.out.println(rs1.getInt("maxid"));

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
		}
		
		return msg;// end finally tr
	}
	
	
	@SuppressWarnings("resource")
	public String addEmployer(Employer employer)
	{
		conn = null;
		PreparedStatement preparedStatement = null;
		String msg="";
		try {

			conn = ConnectionToDB.getConnect();

			String sql;
			//System.out.println(employee.getEmployer().getEmployerId());
			sql = "select max(employer_id) as maxid from employer";
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs1 = preparedStatement.executeQuery(sql);
			rs1.next();
			int maxId = rs1.getInt("maxid") + 1;
			
			sql="insert into employer values(?,?,?)";
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setInt(1, maxId);
			preparedStatement.setString(2, employer.getEmployerName());
			preparedStatement.setDouble(3, employer.getEmployerElection());
			
			preparedStatement.executeUpdate();
			
			msg="Employer has been added with Employer ID: "+maxId;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}finally {
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
		}
		
		return msg;//
	}

}

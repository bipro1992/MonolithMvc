package hc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hc.dto.ClaimDetail;
import hc.dto.Employer;

public class ClaimDetailDao {

	private List<ClaimDetail> claimDetailsObtained;
	
	private Connection conn;

	public List<ClaimDetail> fetchClaimDetailsByEmployeeID(int employeeId) {
		this.claimDetailsObtained = new ArrayList<ClaimDetail>();
		
		conn = null;
		PreparedStatement preparedStatement=null;
		
		try
		{
			
			
			conn=ConnectionToDB.getConnect();
			
			String sql;
		    sql = "SELECT * FROM claim_detail where employee_id = "+employeeId;
		    preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		    
		    
		    ResultSet rs = preparedStatement.executeQuery(sql);
			
			
		    while(rs.next()){
		         //Retrieve by column name
		    	 ClaimDetail claimDetail= new ClaimDetail();
		    	
		         int id  = rs.getInt("claim_detail_id");
		         int emp = rs.getInt("employee_id");
		         double rqst = rs.getDouble("requested_amount");
		         double paid = rs.getDouble("paid_amount");
		         double denied = rs.getDouble("denied_amount");
		         
		         claimDetail.setClaimDetailId(id);
		         claimDetail.setEmployeeId(emp);
		         claimDetail.setRequestedAmount(rqst);
		         claimDetail.setPaidAmount(paid);
		         claimDetail.setDeniedAmount(denied);
		         
		         
		         
		         
		         
		         
		         if(!(paid>0.0 ||denied>0.0))
		         {
		        	 claimDetail.setAdjudicatedElig(true);
		        	 claimDetail.setAdjudicated(false);
		         }
		         else{
		        	 claimDetail.setAdjudicatedElig(false);
		        	 claimDetail.setAdjudicated(true);
		         }
		         
		         this.claimDetailsObtained.add(claimDetail);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      preparedStatement.close();
		      conn.close();
		     
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(preparedStatement!=null)
		            preparedStatement.close();
		      }catch(Exception se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(Exception se){
		         se.printStackTrace();
		      }
		}//end finally try

		 return claimDetailsObtained;

		

	}
	
	
	
	public void updateClaimDetail(ClaimDetail claimDetail) {

		conn = null;
		PreparedStatement preparedStatement = null;

		try {

			conn = ConnectionToDB.getConnect();
			String sql = "update claim_detail set "
					+ "requested_amount=? "
					+ ",denied_amount=?"
					+"where claim_detail_id="+claimDetail.getClaimDetailId();
			preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setDouble(1, claimDetail.getRequestedAmount());
			preparedStatement.setDouble(2, claimDetail.getDeniedAmount());

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
	
	

	public List<ClaimDetail> getClaimDetailsObtained() {
		return claimDetailsObtained;
	}

	public void setClaimDetailsObtained(List<ClaimDetail> claimDetailsObtained) {
		this.claimDetailsObtained = claimDetailsObtained;
	}

}

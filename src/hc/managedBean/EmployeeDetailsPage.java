package hc.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.poi.hssf.util.HSSFColor.GREEN;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

import hc.dao.ClaimDetailDao;
import hc.dao.DemographicDao;
import hc.dao.DependentDao;
import hc.dao.EmployerDao;
import hc.dto.ClaimDetail;
import hc.dto.Demographic;
import hc.dto.Dependent;
import hc.dto.Employee;
import hc.dto.Employer;

@ManagedBean
@SessionScoped
public class EmployeeDetailsPage {

	private Integer employeeId;

	private Employee employee;

	private Employee empDemographic;
	
	private Employer employer;
	
	private int employerId;

	private List<ClaimDetail> claimDetails = new ArrayList<ClaimDetail>();

	private List<Dependent> dependent = new ArrayList<Dependent>();

	public EmployeeDetailsPage() {
		this.claimDetails = new ArrayList<>();
		dependent = new ArrayList<Dependent>();
		// this.demographic = new Demographic();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String fetchClaimDetails() {

		this.empDemographic = null;

		this.claimDetails = new ArrayList<ClaimDetail>();

		this.dependent = new ArrayList<Dependent>();
		
		this.setEmployer(null);

		// System.out.println(this.employeeId);

		if (this.employeeId != null) {

			this.claimDetails = new ClaimDetailDao().fetchClaimDetailsByEmployeeID(this.employeeId);

		}

		this.employeeId = null;

		return "";
	}

	public String fetchDemographicDetails() {

		this.empDemographic = new Employee();

		this.claimDetails = new ArrayList<ClaimDetail>();

		this.dependent = new ArrayList<Dependent>();
		
		//this.empDemographic=null;
		
		this.setEmployer(null);

		if (this.employeeId != null) {

			this.empDemographic = new DemographicDao().getDemographicDetailsByEmployeeId(employeeId);

			//this.employeeId = null;

		}
		return "";
	}

	public String adjudicateClaim(ClaimDetail claimDetail) {
		
//		Session session;
//	    String user = "test1";
//	    String password = "pwd1";
//
//	    String fromAddress = "biprokvs@gmail.com"; // newlycreateduser@localhost
//	    String toAddress = "biprokvs@gmail.com";
//
//	    // Create a mail session
//	    Properties properties = System.getProperties();
//	    properties.put("mail.transport.protocol", "smtp");
//	    properties.put("mail.transport.protocol.rfc822", "smtp");
//	    properties.put("mail.smtp.host", "localhost");
//	    properties.put("mail.smtp.port", "3025");
//	    properties.put("mail.debug", "true");
//	    properties.put("mail.smtp.localaddress", "127.0.0.1");
//	    session = Session.getInstance(properties, new Authenticator() {
//	        @Override
//	        protected PasswordAuthentication getPasswordAuthentication() {
//	            return new PasswordAuthentication("test1", "pwd1");
//	        }
//	    });
//
//	    try {
//	        Message message = new MimeMessage(session);
//	        message.setFrom(new InternetAddress(fromAddress));
//	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//	        message.setSubject("Email From my Greenmail");
//	        message.setText("Test Mail sent from My Greenmail!!");
//	        message.addHeader("X-THALES-ID", "1");
//	        message.addHeader("X-ROUTE-TO", "thalestest");
//	        message.addHeader("X-GROUND-TYPE", "GROUND");
//	        message.addHeader("X-ORIGINAL-FROM", "ambatltesttool");
//	        message.addHeader("X-EMBATL-ERROR", "");
//	        Transport.send(message);
//
//
//	        System.out.println("Email sent successfully from greenmail");
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
		
		

		return "";
	}

	public String fetchDependentDetails() {

		this.claimDetails = new ArrayList<ClaimDetail>();

		//this.employee = null;

		this.dependent = new ArrayList<>();

		this.empDemographic = null;
		
		this.setEmployer(null);

		if (this.employeeId != null) {

			this.dependent = new DependentDao().getDependents(employeeId);

			//this.employeeId = null;

		}
		return "";
	}
	
	public String fetchEmployerDetails()
	{
		this.claimDetails = new ArrayList<ClaimDetail>();

		//this.employee = null;

		this.dependent = new ArrayList<>();

		this.empDemographic = null;
		
		//this.employer=null;
		
		if(this.employerId!=0){
			this.setEmployer(new EmployerDao().getEmployer(employerId));
		}
		return "";
	}
	
	public String updateEmployerDetails()
	{
		EmployerDao dao= new EmployerDao();
		dao.updateEmployer(employer);
		this.employer= dao.getEmployer(employer.getEmployerId());
		
		
		return "";
	}
	
	
	public String updateClaimDetails(ClaimDetail claimDetail)
	{
		ClaimDetailDao dao= new ClaimDetailDao();
		dao.updateClaimDetail(claimDetail);
		this.claimDetails= dao.fetchClaimDetailsByEmployeeID(claimDetail.getEmployeeId());
		
		
		return "";
	}
	
	
	
	public String updateEmployeeDetails()
	{
		
		DemographicDao dao= new DemographicDao();
		Demographic demographic= new Demographic();
		
		
		
		demographic.setDemographicId(empDemographic.getDemographic().getDemographicId());
		demographic.setFirstName(empDemographic.getDemographic().getFirstName());
		demographic.setLastName(empDemographic.getDemographic().getLastName());
		demographic.setAddress1(empDemographic.getDemographic().getAddress1());
		demographic.setAddress2(empDemographic.getDemographic().getAddress2());
		dao.updateEmployee(demographic);
		this.empDemographic=dao.getDemographicDetailsByEmployeeId(empDemographic.getEmployeeId());
		return "";
	}
	
	public String updateDependentDetails(Dependent dependent)
	{
		
		DemographicDao dao= new DemographicDao();
		Demographic demographic= new Demographic();
		
		DependentDao dependentDao= new DependentDao();
		
		demographic.setDemographicId(dependent.getDemographic().getDemographicId());
		demographic.setFirstName(dependent.getDemographic().getFirstName());
		demographic.setLastName(dependent.getDemographic().getLastName());
		demographic.setAddress1(dependent.getDemographic().getAddress1());
		demographic.setAddress2(dependent.getDemographic().getAddress2());
		dao.updateEmployee(demographic);
		this.dependent=dependentDao.getDependents(dependent.getEmployeeId());
		
		return "";
	}
	

	public List<ClaimDetail> getClaimDetails() {
		return claimDetails;
	}

	public void setClaimDetails(List<ClaimDetail> claimDetails) {
		this.claimDetails = claimDetails;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmpDemographic() {
		return empDemographic;
	}

	public void setEmpDemographic(Employee empDemographic) {
		this.empDemographic = empDemographic;
	}

	public List<Dependent> getDependent() {
		return dependent;
	}

	public void setDependent(List<Dependent> dependent) {
		this.dependent = dependent;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}


}

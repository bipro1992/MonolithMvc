package hc.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hc.dao.AddDetailsDao;
import hc.dto.ClaimDetail;
import hc.dto.Demographic;
import hc.dto.Dependent;
import hc.dto.Employee;
import hc.dto.Employer;

@ManagedBean
@SessionScoped
public class AddDetailsPage {

	private Employee employee;
	private ClaimDetail claimDetail;
	private Dependent dependent;
	private Employer employer;
	private Demographic demographic;
	private String message;

	
	
	
	public AddDetailsPage() {
		this.employee= new Employee();
		this.claimDetail= new ClaimDetail();
		this.employer= new Employer();
		this.dependent=new Dependent();
		this.demographic= new Demographic();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ClaimDetail getClaimDetail() {
		return claimDetail;
	}

	public void setClaimDetail(ClaimDetail claimDetail) {
		this.claimDetail = claimDetail;
	}

	public Dependent getDependent() {
		return dependent;
	}

	public void setDependent(Dependent dependent) {
		this.dependent = dependent;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	public String addEmployee()
	{
		this.employee.setDemographic(demographic);
		this.employee.setEmployer(employer);
		this.message= new AddDetailsDao().addEmployee(employee);
		this.employee= new Employee();
		this.claimDetail= new ClaimDetail();
		this.employer= new Employer();
		this.dependent=new Dependent();
		this.demographic= new Demographic();
		
		return "";
	}
	
	public String addClaimDetail()
	{
		
		this.message= new AddDetailsDao().addClaim(claimDetail);
		this.employee= new Employee();
		this.claimDetail= new ClaimDetail();
		this.employer= new Employer();
		this.dependent=new Dependent();
		this.demographic= new Demographic();
		return "";
	}
	
	public String addDependent()
	{
		this.dependent.setDemographic(demographic);
		this.message= new AddDetailsDao().addDependent(dependent);
		this.employee= new Employee();
		this.claimDetail= new ClaimDetail();
		this.employer= new Employer();
		this.dependent=new Dependent();
		this.demographic= new Demographic();
		return "";
	}
	
	public String addEmployer()
	{
		this.message= new AddDetailsDao().addEmployer(employer);
		this.employee= new Employee();
		this.claimDetail= new ClaimDetail();
		this.employer= new Employer();
		this.dependent=new Dependent();
		this.demographic= new Demographic();
		return "";
	}


	public Demographic getDemographic() {
		return demographic;
	}

	public void setDemographic(Demographic demographic) {
		this.demographic = demographic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

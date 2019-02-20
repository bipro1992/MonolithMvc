package hc.dto;

public class Employer {

	private int employerId;
	private String employerName;
	private double employerElection;

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public double getEmployerElection() {
		return employerElection;
	}

	public void setEmployerElection(double employerElection) {
		this.employerElection = employerElection;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

}

package hc.dto;

public class ClaimDetail {

	private Integer claimDetailId;
	private Integer employeeId;
	private Double requestedAmount;
	private Double paidAmount;
	private Double deniedAmount;
	private boolean adjudicated;
	private boolean adjudicatedElig;
	

	public Integer getClaimDetailId() {
		return claimDetailId;
	}

	public void setClaimDetailId(Integer claimDetailId) {
		this.claimDetailId = claimDetailId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(Double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Double getDeniedAmount() {
		return deniedAmount;
	}

	public void setDeniedAmount(Double deniedAmount) {
		this.deniedAmount = deniedAmount;
	}

	public boolean isAdjudicatedElig() {
		return adjudicatedElig;
	}

	public void setAdjudicatedElig(boolean adjudicatedElig) {
		this.adjudicatedElig = adjudicatedElig;
	}

	public boolean isAdjudicated() {
		return adjudicated;
	}

	public void setAdjudicated(boolean adjudicated) {
		this.adjudicated = adjudicated;
	}

}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body
	style="background-color: linear-gradient(to bottom, #ccffcc 0%, #ff99cc 100%);">
	<f:view>
		


		<h:form>
			<div class="jumbotron text-center"
				style="margin-bottom: 03; background: linear-gradient(to bottom, #0066ff 5%, #ccccff 100%);">
				<div align="left"><a href="Home.jsp" style="color: white">Back</a></div>
				<h2 align="center">Member Details Search Portal</h2>
			</div>
			<br>
			<br>
			<div class="col-sm-12">
				<table align="center">
					<tr>
						<td>
							<p>This portal is made for searching Member and Employer
								details. Please provide the Member and Employer Id to get claim
								details,Employer Details,member demographic and dependent
								details</p>
						</td>
					</tr>

				</table>
			</div>
			<br>
			<br>
			<table align="center">
				<tr>
					<td>Member ID:<h:inputText
							styleClass="form-control form-control-sm"
							value="#{employeeDetailsPage.employeeId}"></h:inputText> <br>
						<h:panelGrid columns="3">
							<h:commandButton styleClass="btn btn-primary"
								action="#{employeeDetailsPage.fetchClaimDetails}"
								value="Get Claim Detail IDs"></h:commandButton>

							<h:commandButton styleClass="btn btn-primary"
								action="#{employeeDetailsPage.fetchDemographicDetails}"
								value="Get Demographic Details"></h:commandButton>

							<h:commandButton styleClass="btn btn-primary"
								action="#{employeeDetailsPage.fetchDependentDetails}"
								value="Get Dependent Details"></h:commandButton>
						</h:panelGrid> <br> <br> <h:dataTable var="i"
							styleClass="table table-bordered table-hover"
							value="#{employeeDetailsPage.claimDetails}"
							rendered="#{employeeDetailsPage.claimDetails.size()>0}"
							border="2">

							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Claim Detai ID"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="#{i.claimDetailId}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Member ID"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="#{i.employeeId}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Adjudicated"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="Yes" rendered="#{i.adjudicated}"></h:outputText>
									<h:outputText value="No" rendered="#{!i.adjudicated}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Requested Amount"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.requestedAmount}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Paid Amount"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="#{i.paidAmount}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Denied Amount"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.deniedAmount}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Adjucate Claim"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:commandButton value="adjudicate"
										styleClass="btn btn-primary"
										action="#{employeeDetailsPage.adjudicateClaim(i)}"
										rendered="#{i.adjudicatedElig}"></h:commandButton>
									<h:outputText value="Adjucation not possible"
										rendered="#{!i.adjudicatedElig}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Update"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:commandButton value="Update"
										action="#{employeeDetailsPage.updateClaimDetails(i)}"></h:commandButton>
								</center>
							</h:column>
						</h:dataTable> <h:dataTable var="i" value="#{employeeDetailsPage.dependent}"
							styleClass="table table-bordered table-hover"
							rendered="#{employeeDetailsPage.dependent.size()>0}" border="2">

							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Member ID"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="#{i.employeeId}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Dependent ID"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:outputText value="#{i.dependentId}"></h:outputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Dependent First Name"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.demographic.firstName}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Dependent Last Name"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.demographic.lastName}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Address 1"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.demographic.address1}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Address 2"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:inputText value="#{i.demographic.address2}"></h:inputText>
								</center>
							</h:column>
							<h:column>

								<f:facet name="header">
									<center>
										<h:outputText value="Update"></h:outputText>
									</center>
								</f:facet>
								<center>
									<h:commandButton value="Update" styleClass="btn btn-primary"
										action="#{employeeDetailsPage.updateDependentDetails(i)}"></h:commandButton>
								</center>
							</h:column>

						</h:dataTable> <h:panelGrid columns="7" border="2"
							styleClass="table table-bordered table-hover"
							rendered="#{employeeDetailsPage.empDemographic!=null }">
							<h:outputText value="Member ID"></h:outputText>
							<h:outputText value="Employer ID"></h:outputText>
							<h:outputText value="First Name"></h:outputText>
							<h:outputText value="Last Name"></h:outputText>
							<h:outputText value="Address 1"></h:outputText>
							<h:outputText value="Address 2"></h:outputText>
							<h:outputText value="Update if required"></h:outputText>
							<h:outputText
								value="#{employeeDetailsPage.empDemographic.employeeId}"></h:outputText>
							<h:outputText
								value="#{employeeDetailsPage.empDemographic.employer.employerId}"></h:outputText>
							<h:inputText
								value="#{employeeDetailsPage.empDemographic.demographic.firstName}"></h:inputText>
							<h:inputText
								value="#{employeeDetailsPage.empDemographic.demographic.lastName}"></h:inputText>
							<h:inputText
								value="#{employeeDetailsPage.empDemographic.demographic.address1}"></h:inputText>
							<h:inputText
								value="#{employeeDetailsPage.empDemographic.demographic.address2}"></h:inputText>
							<h:commandButton value="Update" styleClass="btn btn-primary"
								action="#{employeeDetailsPage.updateEmployeeDetails}"></h:commandButton>
						</h:panelGrid>
					</td>

				</tr>
				<tr>
					<td><br> Employer ID:<h:inputText
							styleClass="form-control form-control-sm"
							value="#{employeeDetailsPage.employerId}"></h:inputText> <br>
						<h:panelGrid columns="1">
							<h:commandButton styleClass="btn btn-primary"
								action="#{employeeDetailsPage.fetchEmployerDetails}"
								value="Get Employer Details"></h:commandButton>
						</h:panelGrid> <h:panelGrid columns="4" border="1"
							styleClass="table table-bordered table-hover"
							rendered="#{employeeDetailsPage.employer!=null}">
							<h:outputText value="Employer ID"></h:outputText>
							<h:outputText value="Employer Name"></h:outputText>
							<h:outputText value="Election provided by Employer"></h:outputText>
							<h:outputText value="Update if required"></h:outputText>
							<h:outputText value="#{employeeDetailsPage.employer.employerId}"></h:outputText>
							<h:inputText value="#{employeeDetailsPage.employer.employerName}"></h:inputText>
							<h:inputText
								value="#{employeeDetailsPage.employer.employerElection}"></h:inputText>
							<h:commandButton value="Update" styleClass="btn btn-primary"
								action="#{employeeDetailsPage.updateEmployerDetails}"></h:commandButton>
						</h:panelGrid></td>

				</tr>
			</table>

		</h:form>
	</f:view>
</body>
</html>
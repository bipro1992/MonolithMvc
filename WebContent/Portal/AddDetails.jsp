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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
							<p>This section is for adding Member ,Employer,dependent and
								claim details.</p>
						</td>
					</tr>

				</table>
			</div>

			<center>
				<br> <br>
				<h:outputText value="#{addDetailsPage.message}"
					rendered="#{addDetailsPage.message.length()>0}"></h:outputText>
			</center>
			<div class="panel panel-primary">
				<div class="alert alert-primary" role="alert">Add Claim</div>
				<center>
					<div class="panel-body">
						<h:panelGrid columns="2" border="1">
							<h:outputText value="Member Id"></h:outputText>
							<h:outputText value="Requested Amount"></h:outputText>
							<h:inputText value="#{addDetailsPage.claimDetail.employeeId}"
								required="true"></h:inputText>
							<h:inputText
								value="#{addDetailsPage.claimDetail.requestedAmount}"
								required="true"></h:inputText>
						</h:panelGrid>
						<h:commandButton value="Add Claim"
							action="#{addDetailsPage.addClaimDetail}"></h:commandButton>

					</div>
				</center>
			</div>

		</h:form>
		<br>
		<br>
		<h:form>
			<div class="alert alert-primary" role="alert">Add Employee</div>
			<center>
				<h:panelGrid columns="5" border="1">
					<h:outputText value="Employer Id"></h:outputText>
					<h:outputText value="Member First Name"></h:outputText>
					<h:outputText value="Member Last Name"></h:outputText>
					<h:outputText value="Address 1"></h:outputText>
					<h:outputText value="Address 2"></h:outputText>
					<h:inputText value="#{addDetailsPage.employer.employerId}"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.firstName }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.lastName }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.address1 }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.address2 }"></h:inputText>
				</h:panelGrid>
				<h:commandButton value="Add Employee"
					action="#{addDetailsPage.addEmployee }"></h:commandButton>
			</center>
		</h:form>
		<br>
		<br>
		<h:form>
			<div class="alert alert-primary" role="alert">Add Dependent</div>
			<center>
				<h:panelGrid columns="5" border="1">
					<h:outputText value="Member Id"></h:outputText>
					<h:outputText value="Member First Name"></h:outputText>
					<h:outputText value="Member Last Name"></h:outputText>
					<h:outputText value="Address 1"></h:outputText>
					<h:outputText value="Address 2"></h:outputText>
					<h:inputText value="#{addDetailsPage.dependent.employeeId}"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.firstName }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.lastName }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.address1 }"
						required="true"></h:inputText>
					<h:inputText value="#{addDetailsPage.demographic.address2 }"></h:inputText>
				</h:panelGrid>
				<h:commandButton value="Add Dependent"
					action="#{addDetailsPage.addDependent }"></h:commandButton>
			</center>
		</h:form>
		<br>
		<br>
		<h:form>
			<div class="alert alert-primary" role="alert">Add Employer</div>
			<center>
				<h:panelGrid columns="2" border="1">
					<h:outputText value="Employer Name"></h:outputText>
					<h:outputText value="Provided Election"></h:outputText>
					<h:inputText value="#{addDetailsPage.employer.employerName}"></h:inputText>
					<h:inputText value="#{addDetailsPage.employer.employerElection}"></h:inputText>
				</h:panelGrid>
				<h:commandButton value="Add Employer"
					action="#{addDetailsPage.addEmployer}"></h:commandButton>
			</center>
		</h:form>
		<br>
		<br>

	</f:view>
</body>
</html>
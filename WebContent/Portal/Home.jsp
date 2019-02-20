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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HC|Portal</title>
</head>
<body
	style="background-color: linear-gradient(to bottom, #ccffcc 0%, #ff99cc 100%);">
	<f:view>
		<h:form>
			<div class="jumbotron text-center"
				style="margin-bottom: 03; background: linear-gradient(to bottom, #0066ff 5%, #ccccff 100%);">
				<h2 align="center">Member Details Search Portal</h2>
			</div>
			<br>
			<br>
			<div class="col-sm-12">
				<table align="center">
					<tr>
						<td>
							<p>This portal is made for searching,adding and updationg
								Member and Employer details.click on below links to proceed</p>
						</td>
					</tr>

				</table>
			</div>

			<div class="col-lg-12">
				<h:commandLink styleClass="btn-primary btn-block btn-lg"
					action="AddDetails.jsp"
					value="Add Employer,Member, Dependent, Claims In this section"></h:commandLink>
			</div>
			<br>
			<br>
			<div class="col-lg-12">
				<h:commandLink styleClass="btn-primary btn-block btn-lg"
					action="EmployeeDetails.jsp"
					value="Fetch and update member , employer, dependent and claim details"></h:commandLink>
			</div>

			
				
			
		</h:form>
	</f:view>
</body>
</html>
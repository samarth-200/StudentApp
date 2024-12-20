<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
<%@ page import="com.student.dto.Student" %>
<%@ page import="com.student.dao.StudentSDAO" %>
<%@ page import="com.student.dao.StudentDAOImp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initialscale=1.0">
<title>Student Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<%HttpSession sess= request.getSession(false); %>
<%Student s=(Student)sess.getAttribute("Student"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Welcome <%=s.getName() %></a>
			<button class="navbar-toggler" type="button"
				data-bstoggle=" 
collapse" data-bs-target="#navbarNav" aria
				controls="navbarNav" aria-expanded="false"
				aria-label="Toggle 
navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
				<%if(s.getId()==1){ %>
			<li class="nav-item"><a class="nav-link" href="viewUsers.jsp">view data</a>
					</li>
					<%} %>
					<li class="nav-item"><a class="nav-link" href="ForgotPin.jsp">ResetPassword</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="Update.jsp">UpdateData</a></li>
					<li class="nav-item">
					<form action="Logout">
					<input type="Submit"  class="btn btn-danger" name="val" value="Logout"></input>
					</form>
					
					</li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
	<div class="container mt-4">
		<h1 class="text-center mb-4">Dashboard</h1>
	</div>
	<!-- User Section -->
	<div class="row">
		<div class="col-md-12">
			<h3>View Your Data</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Mail ID</th>
						<th>Branch</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
				
                        <tr>
                            <td><%= s.getId() %></td>
                            <td><%= s.getName() %></td>
                            <td><%= s.getPhoneno() %></td>
                            <td><%= s.getMailid() %></td>
                            <td><%= s.getBranch() %></td>
                            <td><%= s.getLocation() %></td>
                        </tr>
                        
				</tbody>
			</table>
		</div>
</body>
</html>
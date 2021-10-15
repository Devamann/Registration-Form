<%@page import="java.sql.ResultSet"%>
gt<%@page import="registration_form.Get_student_data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ResultSet rs = Get_student_data.Table();
	while (rs.next()) {
		out.println(rs.getString("name") + " " + rs.getString(2) + " " + rs.getString(3));
	}
	%>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile No.</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			rs = Get_student_data.Table();
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><a href="Delete_row?C1=<%=rs.getString(1)%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>
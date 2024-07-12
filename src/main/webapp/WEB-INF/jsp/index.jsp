<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <form action="/" method="get">
        <label>Name:</label>
        <input type="text" name="name" />
        <button type="submit">Search</button>
    </form>
    <form action="/" method="get">
        <button type="submit">Refresh</button>
    </form>
    <c:forEach var="employee" items="${listEmployees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.role}</td>
            <td>
                <a href="showFormForUpdate/${employee.id}">Update</a>
                <a href="deleteEmployee/${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="showNewEmployeeForm">Add New Employee</a>
</body>
</html>
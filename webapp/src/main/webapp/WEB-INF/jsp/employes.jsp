<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Employe page</title>
</head>
<body>

<h1>Author table</h1>
<h1>${requestScope.len}</h1>
<table border="1px solid black">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SURNAME</th>
        <th>DEPARTMENT</th>
        <th>PROJECT</th>
        <th>EMAIL</th>
        <th colspan="2">Actions</th>
    </tr>

    <c:forEach var="employe" items="${requestScope.employeList}">
    <tr>
        <td>${employe.getId()}</td>
        <td>${employe.getName()}</td>
        <td>${employe.getSurname()}</td>
        <td>${employe.getDepartment()}</td>
        <td>${employe.getProjectName()}</td>
        <td>${employe.getEmail()}</td>
        <td>
            <form action="Edit" method="post">
                <input type="hidden" name="authorId" value=${authors.getId()}>
                <input type="submit" value="Update">
            </form>
        </td>
        <td>
            <form action="Delete" method="post">
                <input type="hidden" name="commandType" value="delete">
                <input type="hidden" name="authorId" value=${authors.getId()}>
                <input type="submit" value="Delete">
            </form>
        </td>
        </tr>
    </c:forEach>

</table>

<br>

<input type="button" value="Add" onClick="document.location='authorAdd'">
</body>
</html>


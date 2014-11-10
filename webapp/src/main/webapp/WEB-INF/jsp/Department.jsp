<%@page import="com.getjavajob.phonebook.model.Employe"%>
<%@page import="java.util.TreeSet" %>
<%@page import="com.getjavajob.phonebook.service.EmployeService" %>
<html>
    <head>
        <title>Employe</title>
    </head>
    <body>
        EMPLOYE<br/>
        <table>
            <jsp:useBean id="EmployeService" class="com.getjavajob.phonebook.service.EmployeService" scope="page" />
            <c:set var="employes" value="${EmployeService.employeBase()}" />

            <tr>
                <th>
                    NAME
                </th>
                <th>
                    SURNAME
                </th>
                <th>
                    PROJECT_NAME
                </th>
                <th>
                    DEPARTMENT
                </th>
                <th>
                    TELEPHONE_LIST
                </th>
                <th>
                    EMAIL
                </th>
            </tr>
            <c:forEach var="employe" items="${employes}">
                <tr>                    <td>
                        ${employe.getName()}
                    </td>
                    <td>
                        ${employe.getSurname()}
                    </td>
                    <td>
                        ${employe.getProjectName()}
                    </td>
                    <td>
                        ${employe.getDepartment()}
                    </td>
                    <td>
                        <select> 
                            <c:set var="phones" value="${employe.getTelephone()}"/>
                                   <c:forEach var="phone" items="${phones.toString}">
                                    <option>${phone} </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            ${employe.getEmail()}
                        </td>
                        <td>
                            <form method="post" action="main.webapp.WEB-INF.jsp.employeEdit"/>
                            <input type="hidden" name ="employeId" value="${employe.getId()}" />
                            <input type="submit" value="change" />
                            </form>
                        </td>
                    </tr>
            </c:forEach>
        </table>
        <form method="post" action="main.webapp.WEB-INF.jsp.employeEdit"/>
        <input type="hidden" name ="employeId" value="0" />
        <input type="button" value="add" />
    </form>
</body>
</html>

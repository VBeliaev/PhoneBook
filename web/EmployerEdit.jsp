<%@page import="com.getjavajob.belyaev.model.Employe"%>
<%@page import="java.util.TreeSet" %>
<%@page import="com.getjavajob.model.modelBase.EmployeBase" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>EmployeEdit</title>
    </head>
    <body>
        EMPLOYE_EDIT<br/>
        <table>
            <jsp:useBean id="EmployeService" class="com.getjavajob.belyaev.services.EmployeService" scope="page" />
            <c:set var="employeId" scope ="page" value="${Integer.parseInt(requestScope.employeId)}"/>
            <c:set var="employe" value="${EmployeService.get(employeId)}" />

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
            <tr>
                <td>
                    <input type="text" name="employeName" value="${(employeId>0)? employe.getName():""}"/> 
                </td>
                <td>
                    <input type="text" name="employeSurname" value="${(employeId>0)? employe.getSurname():""}"/> 
                </td>
                <td>
                    <input type="text" name="employeProjectName" value="${(employeId>0)? employe.getProjectName():""}"/> 
                </td>
                <td>
                    <input type="text" name="employeDepartment" value="${(employeId>0)? employe.getDepartment():""}"/> 
                </td>
                <td>
                    <select> 
                        <c:set var="phones" value="${employe.getTelephone()}"
                               <c:forEach var="phone" items="${phones.toString}">
                                <option>${phone} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="text" name="employeEmail" value="${(authorId>0)? employe.getEmail():""}"/> 
                    </td>
                </tr>
            </table>
            <c:if test="$authorId <1 ">
                <input type="submit" value="add" >
                <c:if/>
                <c:if test="$authorId > 0">
                    <input type="submit" value="edit" >
                    <c:if/>

                </body>
            </html>
<%@ page isELIgnored="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
 <c:when test="${!empty empsData}">
   <table border="1" bgcolor="majenta" align="center">
     <tr>
       <th>Emp No</th><th>Ename</th><th>Job</th><th>Salary</th><th>Dept No</th><th>Operations</th>
     </tr>
   <c:forEach var="emp" items="${empsData}">
     <tr align="center">
        <td>${emp.empno }</td>
        <td>${emp.ename }</td>
        <td>${emp.job }</td>
        <td>${emp.sal }</td>
        <td>${emp.deptno }</td>
        <td><a href="emp_edit?no=${emp.empno}"><img src="resources/images/edit.jpg" width="40px" height="30px"></a>
            <a href="emp_delete?no=${emp.empno}" onclick="return confirm('Do You want delete')"><img src="resources/images/delete.jpg" width="40px" height="30px"></a>
            </td> 
      </tr>
   </c:forEach>
   </table>
 
 </c:when>
 <c:otherwise>
 <h1 style="color:red;text-align:centre">No Records Found</h1>
 </c:otherwise>
 
 </c:choose>
 
 <br><br>
 <center><h2 style="color:red text-align:center"><u>${resultMsg}</u></h2></center>
 <br><br>
 <center><h2><a href="./"><img src="resources/images/home.png" width="60px" height="50px">home</a></h2></center>
 
 <br>
 <center><h2><a href="add_emp"><img src="resources/images/add.png" width="60px" height="50px">Add Employee</a></h2></center>
 
 
 
 
 
 

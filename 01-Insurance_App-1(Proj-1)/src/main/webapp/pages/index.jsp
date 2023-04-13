<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--adding form-tag librery here to develope MVC form-->
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>
   
 <div class="container" >
   
   <h1 class="pb-3 pt-3">Report Applications</h1>
     
     <form:form action="search" modelAttribute="search" method="POST">

      <table>
     
          <tr>
               <td> Plane Name:</td>
                   
            <td>
                    <form:select path="planName">
                      <form:option value="">-Select-</form:option>
                      <form:options items="${names}"></form:options>
                   </form:select>
           </td>
              
                <td> Plane Status:</td>
                   <td>
                    <form:select path="planStatus">
                       <form:option value="">-Select-</form:option>
                        <form:options items="${status}"></form:options>
               </form:select>
               
               </td>
               
            
                  <td>Gender:</td>
                  <td>
                  <form:select path="gender">
                    <form:option value="">-Select-</form:option>
                    <form:option value="male" > Male</form:option>
                    <form:option value="fe-male">Fe-Male</form:option>
                   </form:select>
                </td>
                
                
                <tr>
                  <td>Start Date:</td>
                  <td>
                      <form:input path="planStartDate" type="date" />
                </td>
            
                
               
                  <td>End Date:</td>
                  <td>
                      <form:input path="planEndDate" type="date"/>
                </td>
             </tr>
                  <tr>
                    <td><a href="/" class="btn btn-warning ">Reset</a></td>
                     <td>
                          <input type="submit" value="Search" class="btn btn-primary" />
                     
                     </td>
                  
                  </tr>
               
          </tr>
      </table>
   
     </form:form>
               
           <hr/>
                 <table class="table table-success table-striped table-hover"  >
                 
                       <thead>
                       
                             <tr>
                             
                                  <th>S.No</th>
                                  <th>Citizen Name</th>
                                   <th>Gender</th>
                                  <th>Plan Name</th>
                                  <th>Plan Status</th>
                                  <th>Plan StartDate</th>
                                  <th>Plan EndDate</th>
                                  <th>Benefit Amt</th>
                             
                             </tr>
                       
                       </thead>
                            <tbody>
                                  <!-- plan is model key-->
                           <c:forEach  items="${plan}" var="plans" varStatus="index">
                             <tr>
                                 <td> ${index.count}</td>
                                    <td> ${plans.citizenName}</td>
                                      <td> ${plans.gender}</td>
                                     <td> ${plans.planName}</td>
                                      <td> ${plans.planStatus}</td>
                                       <td> ${plans.planStartDate}</td>
                                        <td> ${plans.planEndDate}</td>
                                       <td>${plans. benifitAmt }</td>
                             </tr>
                           
                           </c:forEach>
                           <tr>
                            <c:if test="${empty plan }">
                            <td colspan="8" style="text-align: center"> No record found</td>
                            </c:if>
                       </tr>
                          </tbody>
                 
                 </table>
           
           <hr/>
       Export:<a href="excel">Excel</a> <a href="pdf">Pdf</a>
     
</div>   
   
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
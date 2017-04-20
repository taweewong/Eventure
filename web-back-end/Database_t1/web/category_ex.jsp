<%-- 
    Document   : category_ex
    Created on : Apr 11, 2017, 12:35:14 PM
    Author     : Taweewong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/category_ex.css">
        <%@include  file="navbar_jsp.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>
        <!-- CONTAINER ! -->
        <% LinkedList<Model.Event> ke = new LinkedList<Model.Event>();

            ke = (LinkedList<Model.Event>) session.getAttribute("event_list");
            //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
            System.out.println(ke.get(0).getEvent_name());

        %>
        <div class="container-fluid">
            <div class="wrapper center-block">
                <div class="title">
                    <div><h1>Technical</h1></div>
                </div>
                <div class="show-case">

                    <% for (Model.Event i : ke) {%>
                    <div class="box col-xs-12 col-sm-4">
                        <div><img src="assets/css/pic/NoImageAvailable.png" width="200"></div>                      
                        <div class="detail">                               
                            <%--<c:forEach  var="i" items="${array}">
                            <%-- NAME : ${i.getEvent_name}" 
                            System.out.println("aaaaaa");
                        </c:forEach> --%>            
                            <h3><%= i.getEvent_name()%></h3>
                            <h4><i class="fa fa-map-marker" aria-hidden="true"></i> <%= i.getLocation()%>   </h4>
                            <h4><i class="fa fa-clock-o" aria-hidden="true"></i> <%= i.getDuration()%></h4>
                        </div>
                    </div>
                    <% }%>


                </div>
            </div>

        </div>
    </body>
    <%@include  file="footer.html" %>

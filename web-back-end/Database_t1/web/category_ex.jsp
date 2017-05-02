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
        <title>Category</title>
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
                    <div><h1>
                            <% if (ke.get(0).getCate_id().equals("01")) { %>
                            Technical
                            <% } else if (ke.get(0).getCate_id().equals("02")) {%>
                            Art & Music
                            <% } else if (ke.get(0).getCate_id().equals("03")) {%>
                            Sport & Health
                            <% } else if (ke.get(0).getCate_id().equals("04")) {%>
                            Community
                            <% } else if (ke.get(0).getCate_id().equals("05")) {%>
                            Food
                            <% } else if (ke.get(0).getCate_id().equals("06")) {%>
                            IT
                            <% } else if (ke.get(0).getCate_id().equals("07")) {%>
                            Other
                            <% } %>
                        </h1></div>
                </div>
                <div class="show-case">

                    <% for (Model.Event i : ke) {%>
                    <a class="box col-xs-12 col-sm-4 col-md-3" href="Event_Servlet?eid=<%= i.getEvent_id()%>">
                        <div class="img-div"><img class="img-show" src="<%= i.getImage()%>" width="200"></div>                      
                        <div class="detail">                               
                            <%--<c:forEach  var="i" items="${array}">
                            <%-- NAME : ${i.getEvent_name}" 
                            System.out.println("aaaaaa");
                        </c:forEach> --%>            
                            <h3><%= i.getEvent_name()%></h3>
                            <h4><i class="fa fa-map-marker" aria-hidden="true"></i> <%= i.getLocation()%>   </h4>
                            <h4><i class="fa fa-clock-o" aria-hidden="true"></i> <%= i.getDate_event()%></h4>
                        </div>
                    </a>
                    <% }%>


                </div>
            </div>

        </div>
    </body>
    <%@include  file="footer.html" %>

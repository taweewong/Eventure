<%-- 
    Document   : search_event
    Created on : Apr 22, 2017, 1:11:25 AM
    Author     : thitikron_gun
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Event</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/category_ex.css">
        <%@include  file="navbar_jsp.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>
        <!-- CONTAINER ! -->
        
        <%  
            int ST = (int) session.getAttribute("ST");
            String EVENT_NAME = (String) session.getAttribute("EVENT_SEARCH");
            System.out.println(EVENT_NAME);
            if(ST == 1){ %>
            <div class="container-fluid">
            <div class="wrapper center-block">
                <div class="title">
                    <div><h2> We were unable to find results "<%= EVENT_NAME %>" .</h2></div>
                    Search Tips<br>
                    Double check your spelling.<br>
                    Try using single words (e.g. concert, seminar).<br>
                    Try searching for an item that is less specific.<br>
                    You can always narrow your search result later.<br>
                </div>
                

                    
                    
        <%}
        else{
            
            
            
            LinkedList<Model.Event> ke = new LinkedList<Model.Event>();
            
            ke = (LinkedList<Model.Event>) session.getAttribute("event_list");
            //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
            //System.out.println(ke.get(0).getEvent_name());
         
        %>
        <div class="container-fluid">
            <div class="wrapper center-block">
                <div class="title">
                    <div><h3>We've found <%= ke.size() %> event "<%= EVENT_NAME %>" for you.</h3></div>
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
                            <h2><%= i.getEvent_name()%></h2>
                            <h4><i class="fa fa-map-marker" aria-hidden="true"></i> <%= i.getLocation()%>   </h4>
                            <h4><i class="fa fa-clock-o" aria-hidden="true"></i> <%= i.getDuration()%></h4>
                        </div>
                    </div>
                    <% }}%>


                </div>
            </div>

        </div>
    </body>
    <%@include  file="footer.html" %>

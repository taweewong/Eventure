<%-- 
    Document   : history
    Created on : Apr 11, 2017, 2:19:52 PM
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
        <link rel="stylesheet" type="text/css" href="assets/css/history.css">
        <%@include  file="navbar_jsp.jsp" %>
    <body>
        <!-- CONTAINER ! -->
        
          <% 
          LinkedList<Model.History> kh = new LinkedList<Model.History>();
            
           kh = (LinkedList<Model.History>)session.getAttribute("history_list");
           System.out.println(kh.get(0).getDate_reserve());
  
        %>
        
        <div class="container">
            <div class="title">
                <h1>History</h1>
            </div>
            <div class="his-head">
                <div class="col-xs-2">
                    <p class="date">Date</p>
                </div>
                <div class="col-xs-3">
                    <p class="event">Event</p>
                </div>
                <div class="col-xs-3" class="text-row">
                    <p class="location">Location</p>
                </div>
                <div class="col-xs-4" class="text-row">
                    <p class="etc">search<span><input type="text" name="search" class="search"></span></p>		
                </div>
                <!-- List -->
                <% for(Model.History i: kh){ 
                System.out.println(i.getDate_reserve());
                %>
                
                <div class="his-list col-xs-12">
                    <div class="col-xs-2 box">
                        <p class="text date-list"> <%= i.getDate_reserve() %> </p>
                    </div>
                    <div class="col-xs-3 box">
                        <p class="text event-list"><%= i.getEvent_name() %></p>
                    </div>
                    <div class="col-xs-3 box">
                        <p class="text locate-list"><%=i.getLocation() %></p>
                    </div>		
                </div>
                
                <%}%>
                
                
                
                
                
            </div>


        </div>
    </body>
    <%@include  file="footer.html" %>
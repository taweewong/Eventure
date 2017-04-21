<%-- 
    Document   : my_event
    Created on : Apr 21, 2017, 12:11:29 AM
    Author     : Taweewong
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>My Event</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/my_event.css">
        <%@include file="navbar_jsp.jsp" %>
    <body>
        <div class="container">
            <div class="rows head">
                <div class="col-xs-12 title">
                    <h1>My Events</h1>
                </div>
            </div>
            <% LinkedList<Model.Event> ke = new LinkedList<Model.Event>();

            ke = (LinkedList<Model.Event>) session.getAttribute("my_event");
            //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
            System.out.println(ke.get(0).getEvent_name());

        %>
            <div class="rows box">
                <div class="box-head">
                    <div class="col-xs-3">Event</div>
                    <div class="col-xs-2">Date</div>
                    <div class="col-xs-2">Time</div>
                    <div class="col-xs-3">Location</div>
                    <div class="col-xs-2">View</div>
                </div>
                <div class="box-body">
                    
                    <% for (Model.Event i : ke) {%>
                    <form action="Manage_event_Servlet">
                        <div class="event-rows">
                            <div class="col-xs-3"><%= i.getEvent_name()%></div>
                            <div class="col-xs-2"><%= i.getDate_event()%></div>
                            <div class="col-xs-2"><%= i.getEvent_start()%></div>
                            <div class="col-xs-3"><%= i.getLocation()%></div>
                            <div>

                                <%--<a class="btn btn-default manage-btn" name="event" value="<%= i.getEvent_id() %>" href="Manage_event_Servlet" role="button">view</a>--%>
                            </div>
                                <div class="col-xs-2">
                                    <input type="submit" class="btn btn-default manage-btn" name="event" value="<%= i.getEvent_id() %>" >
                                </div>
                        </div>
                    </form>
                    
                   <%}%>
                    
                </div>
            </div>		
        </div>
    </body>
    <%@include file="footer.html" %>

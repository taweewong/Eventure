<%-- 
    Document   : manage_event
    Created on : Apr 21, 2017, 12:03:33 AM
    Author     : Taweewong
--%>

<%@page import="Model.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Event</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/manage_event.css">
        <%@include file="navbar_jsp.jsp" %>

    <body>
        <div class="container-fluid">
            <div class="head-pic">
                <img class="head-pic-crop" src="assets/css/pic/anthony-delanoix-48936.jpg">
                <%
                    Model.Event event = new Event();
                    event = (Model.Event) session.getAttribute("event_id_inf");
                    System.out.println(event.getEvent_name());

                %>
            </div>
            <div class="container">
                <div class="row">
                    <div class="topic col-xs-12">
                        <div class="box">
                            <h1><%= event.getEvent_name()%></h1>
                            <div class="place-n-time">
                                <h4><i class="fa fa-map-marker" aria-hidden="true"></i> <%= event.getLocation()%> </h4>
                                <h4><i class="fa fa-clock-o" aria-hidden="true"></i> <%= event.getDate_event()%> | <%= event.getEvent_start()%></h4>
                            </div>
                        </div>
                        <div class="box">
                            <form action="create_form.jsp">
                                <button type="submit" class="btn btn-default manage-btn" name="create" value="<%= event.getEvent_id()%>">Create Application Form</button>
                            </form>
                            <br>
                            <%-- <a type="button" class="btn btn-default manage-btn">Create Application Form</a> --%>

                            <form action="Join_req_Servlet">
                                <button type="submit" class="btn btn-default manage-btn" name="event" value="<%= event.getEvent_id()%>">View Join Request</button>
                            </form>
                            <%--<a class="btn btn-default manage-btn" name="event" value="<%= event.getEvent_id() %>" href="Join_req_Servlet" role="button">View join request</a>--%>
                            <%--<button type="button" class="btn btn-default manage-btn">View join request</button>--%>

                        </div>
                    </div>
                </div>


            </div>

        </div>
    </body>
    <%@include file="footer.html" %>

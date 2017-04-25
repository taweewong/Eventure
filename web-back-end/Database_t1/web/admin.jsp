<%-- 
    Document   : admin
    Created on : Apr 24, 2017, 12:18:31 AM
    Author     : thitikron_gun
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Panel</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/admin.css">
        <%@include  file="navbar_jsp.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body>

        <!-- CONTAINER ! -->
        <div class="container">
            <div class="title">
                <h1>Admin Panel</h1>
            </div>
            <div class="his-head">

                <div class="content">
                    <ul class="nav nav-pills color">
                        <li class="active"><a data-toggle="pill" href="#event">Event</a></li>
                        <li><a data-toggle="pill" href="#member">Member</a></li>
                        <div class="search-input">
                            <p>search <span><input type="text" name="search"></span></p>
                        </div>
                    </ul>
                    <div class="tab-content">
                        <div id="event" class="tab-pane fade in active">
                            <div class="col-xs-2">
                                <p class="event_id">Event ID</p>
                            </div>
                            <div class="col-xs-3">
                                <p class="event">Event Name</p>
                            </div>
                            <div class="col-xs-3" class="text-row">
                                <p class="organizer">Organizer</p>
                            </div>
                            <!-- List -->

                            <% LinkedList<Model.Event> events = new LinkedList<Model.Event>();
                                ServletContext ctx = getServletContext();
                                Connection conn = (Connection) ctx.getAttribute("connection");
                                Model.Keep_Event ke = new Model.Keep_Event(conn);
                                ke.query_event();
                                events = (LinkedList<Model.Event>) ke.getEvents();
                                //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
                                //System.out.println(events.get(0).getEvent_name());
                                for (Model.Event i : events) {
                            %>

                            <div class="his-list col-xs-12">
                                <div class="col-xs-2 box">
                                    <p class="text date-list"><%= i.getEvent_id()%></p>
                                </div>
                                <div class="col-xs-3 box">
                                    <p class="text event-list"><%= i.getEvent_name()%></p>
                                </div>
                                <div class="col-xs-4 box">
                                    <p class="text locate-list"><%= i.getOrganizer()%></p>
                                </div>
                                <form action="Admin_Servlet" method="POST">
                                    <div class="col-xs-2"><button type="submit" name="event_id" value="<%= i.getEvent_id()%>" class="btn btn-default manage-btn">Delete</button></div>
                                </form>

                            </div>
                            <% } %>
                        </div>

                        <div id="member" class="tab-pane fade">
                            <div class="col-xs-2">
                                <p class="user_id">User ID</p>
                            </div>
                            <div class="col-xs-3">
                                <p class="user">Username</p>
                            </div>
                            <div class="col-xs-4" class="text-row">
                                <p class="name">Name</p>
                            </div>


                            <%
                                LinkedList<Model.User> users = new LinkedList<Model.User>();
                                users = (LinkedList<Model.User>) session.getAttribute("User_list");

                                Model.Keep_User ku = new Model.Keep_User(conn);
                                ku.show_user_all();
                                users = (LinkedList<Model.User>) ku.getUsers();
                                for (Model.User k : users) {%>
                            <!-- List -->
                            <div class="his-list col-xs-12">
                                <div class="col-xs-2 box">
                                    <p class="text date-list"><%= k.getUser_id()%> </p>
                                </div>
                                <div class="col-xs-3 box">
                                    <p class="text event-list"><%= k.getUsername()%> </p>
                                </div>
                                <div class="col-xs-4 box">
                                    <p class="text locate-list"><%= k.getFirstname()%> <%= k.getLastname()%></p>
                                </div>
                                <form action="Admin_Servlet" method="POST">
                                    <div class="col-xs-2"><button type="submit" name="user_id" value="<%= k.getUser_id()%>" class="btn btn-default manage-btn">Delete</button></div>
                                </form>
                            </div>
                            <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
    <%@include  file="footer.html" %>


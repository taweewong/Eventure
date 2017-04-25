<%-- 
    Document   : my_event
    Created on : Apr 21, 2017, 12:11:29 AM
    Author     : Taweewong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                List<Model.Event> ke_array = new ArrayList<Model.Event>(ke);
                //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
                //System.out.println(ke.get(0).getEvent_name());

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

                    <% for (Model.Event i : ke_array) {%>
                    <form action="Manage_event_Servlet" id="myForm"></form>
                        <div class="event-rows">
                            <div class="col-xs-3"><%= i.getEvent_name()%></div>
                            <div class="col-xs-2"><%= i.getDate_event()%></div>
                            <div class="col-xs-2"><%= i.getEvent_start()%></div>
                            <div class="col-xs-3"><%= i.getLocation()%></div>
                            <div>

                                <%--<a class="btn btn-default manage-btn" name="event" value="<%= i.getEvent_id() %>" href="Manage_event_Servlet" role="button">view</a>--%>
                            </div>
                            <div class="col-xs-2">
                                <button form="myForm" type="submit" class="btn btn-default manage-btn" name="event" value="<%= i.getEvent_id()%>" >View</button>
                                <button type="button" class="btn btn-default delete-btn" name="delete-event" data-toggle="modal" data-target="#myModal<%= i.getEvent_id()%>" value="<%= i.getEvent_id()%>" >Delete</button>
                            </div>
                            
                            <!-- Modal -->
                            <div class="modal fade" id="myModal<%= i.getEvent_id()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">Delete Confirmation</h4>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure to delete <%= i.getEvent_name()%>
                                        </div>
                                        <div class="modal-footer">
                                            <form action="Delete_event_Servlet" method="POST">
                                                <button type="submit" name="event_id" value="<%= i.getEvent_id()%>" class="btn btn-primary delete-btn">Delete</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal -->
                            
                        </div>

                    <%}%>

                </div>
            </div>		
        </div>
    </body>
    <%@include file="footer.html" %>

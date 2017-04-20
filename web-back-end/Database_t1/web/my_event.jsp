<%-- 
    Document   : my_event
    Created on : Apr 21, 2017, 12:11:29 AM
    Author     : Taweewong
--%>

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
            <div class="rows box">
                <div class="box-head">
                    <div class="col-xs-3">Event</div>
                    <div class="col-xs-2">Date</div>
                    <div class="col-xs-2">Time</div>
                    <div class="col-xs-3">Location</div>
                    <div class="col-xs-2">View</div>
                </div>
                <div class="box-body">
                    <div class="event-rows">
                        <div class="col-xs-3">Untitled Event</div>
                        <div class="col-xs-2">01-01-2017</div>
                        <div class="col-xs-2">13.00 - 17.00</div>
                        <div class="col-xs-3">Somewhere on Earth</div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">View</button></div>
                    </div>
                    <div class="event-rows">
                        <div class="col-xs-3">Untitled Event</div>
                        <div class="col-xs-2">01-01-2017</div>
                        <div class="col-xs-2">13.00 - 17.00</div>
                        <div class="col-xs-3">Somewhere on Earth</div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">View</button></div>
                    </div>
                    <div class="event-rows">
                        <div class="col-xs-3">Untitled Event</div>
                        <div class="col-xs-2">01-01-2017</div>
                        <div class="col-xs-2">13.00 - 17.00</div>
                        <div class="col-xs-3">Somewhere on Earth</div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">View</button></div>
                    </div>
                    <div class="event-rows">
                        <div class="col-xs-3">Untitled Event</div>
                        <div class="col-xs-2">01-01-2017</div>
                        <div class="col-xs-2">13.00 - 17.00</div>
                        <div class="col-xs-3">Somewhere on Earth</div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">View</button></div>
                    </div>	
                </div>
            </div>		
        </div>
    </body>
    <%@include file="footer.html" %>

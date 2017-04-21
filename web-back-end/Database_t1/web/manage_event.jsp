<%-- 
    Document   : manage_event
    Created on : Apr 21, 2017, 12:03:33 AM
    Author     : Taweewong
--%>

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
                
                
                
                %>
            </div>
            <div class="container">
                <div class="row">
                    <div class="topic col-xs-12">
                        <div class="box">
                            <h1>Untitled Event</h1>
                            <div class="place-n-time">
                                <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                                <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>
                            </div>
                        </div>
                        <div class="box">
                            <form action="create_form.jsp">
                            <button type="button" class="btn btn-default manage-btn">Create Application Form</button>
                            <button type="button" class="btn btn-default manage-btn">View join request</button>
                            </form>
                        </div>
                    </div>
                </div>


            </div>

        </div>
    </body>
    <%@include file="footer.html" %>

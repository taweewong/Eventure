<%-- 
    Document   : event
    Created on : Apr 11, 2017, 2:12:52 PM
    Author     : Taweewong
--%>
<%@page import="Model.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/event.css">
        <%@include  file="navbar_jsp.jsp" %>
    <body>
        <!-- CONTAINER ! -->
        
        <% Model.Event event = new Model.Event();
        
           event = (Model.Event)session.getAttribute("event_session");
           
        %>
        
        
        
        <div class="container">
            <div class="title">
                <h1><%= event.getEvent_name() %></h1>
            </div>
            <div class="content">
                <ul class="nav nav-pills color">
                    <li class="active"><a data-toggle="pill" href="#home">Home</a></li>
                    <li><a data-toggle="pill" href="#member">Member</a></li>
                </ul>
                <div class="tab-content">
                    <div id="home" class="tab-pane fade in active">
                        <div class="home-pic">
                            <img src="assets/css/pic/anthony-delanoix-48936.jpg" class="home-pic-crop">
                        </div>
                        <div class="small-tab">
                            <div class="small-content"><h3><%= event.getEvent_name() %></h3></div>
                            <div class="small-content"><p><%= event.getCate_id() %></p></div>
                            <div class="small-content"><p><%= event.getLocation() %></p></div>
                            <div class="small-content"><p><%= event.getDuration()  %></p></div>
                        </div>
                        <div class="detail">
                            <p>&emsp; <%= event.getDetail() %> </p>
                            
                        </div>
                    </div>
                    <div id="member" class="tab-pane fade">
                        <h3>Organizer</h3>
                        <div class="member-list">
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>Timothy S. Green</h3>
                                <p>Organizer</p>
                            </div>
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>Kenneth A. Roberson</h3>
                                <p>Organizer</p>
                            </div>
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>David M. Gonzalez</h3>
                                <p>Organizer</p>
                            </div>
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>Clara R. Sisemore</h3>
                                <p>Organizer</p>
                            </div>
                        </div>
                        <h3>Member</h3>
                        <div class="member-list">
                        
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>Jared S. Taylor</h3>
                                <p>Member</p>
                            </div>
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>Robert S. Dixon</h3>
                                <p>Member</p>
                            </div>
                            <div class="person">
                                <img src="assets/css/pic/profile-icon.png">
                                <h3>David E. Payne</h3>
                                <p>Member</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include  file="footer.html" %>

<%-- 
    Document   : event
    Created on : Apr 11, 2017, 2:12:52 PM
    Author     : Taweewong
--%>

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
        <div class="container">
            <div class="title">
                <h1>Untitled Event</h1>
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
                            <div class="small-content"><h3>Untitled Event 1</h3></div>
                            <div class="small-content"><p>Art & Music</p></div>
                            <div class="small-content"><p>Somewhere on Earth</p></div>
                            <div class="small-content"><p>03/09/2017 | 13.00</p></div>
                        </div>
                        <div class="detail">
                            <p>&emsp; Untitled Event 1 has been organized by Member 001 and Member 002 to share their years of professional photography knowledge and expertise with those who love photography and want to improve their skills through organized excursions, photo walks, photo tours, 1 on 1 lessons and themed workshops...learning more about photography through the sharing of ideas and information in the process of becoming better photographers. </p>
                            <p>&emsp; We are also a social group with planned gatherings for members to come together to enjoy new and old friends in a relaxed, fun and informative setting. It is a way to meet other people who share your interest in photography and to network with other photographers who live in, or are traveling through Thailand. 
                            </p>
                            <p>&emsp; Membership is free, as are all social get-togethers, photo walks and most excursions. Our private classes, tours and workshops are normally fee based, clearly posted with sign-up instructions. We strive to keep group activities free. 
                            </p>
                            <p>&emsp; Our goal is to promote photography as a means of personal expression and as a creative activity with the members of the group. We are especially interested in working with the emerging photographer to help develop their talents. 
                            </p>
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
                                <h3>David E. Holderman</h3>
                                <p>Member</p>
                            </div>
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

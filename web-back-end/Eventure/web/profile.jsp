<%-- 
    Document   : profile
    Created on : Apr 11, 2017, 4:06:43 PM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/profile.css"/>
        <%@include file="navbar_jsp.jsp" %>
    <body>
        <!-- CONTAINER ! -->
        <div class="container">
            <div class="wrapper center-block">
                <div class="col-lg-6 col-xs-12" id="left">
                    <div><img src="assets/css/pic/profile-icon.png" width="300" class="img-circle"></div>
                    <h2>Event Entvee</h2>
                    <a href="#" id="change-img">Change profile image</a>
                </div>
                <div class="col-lg-6 col-xs-12" id="right">
                    <div class="header">
                        <div><h1>My Profile</h1></div>
                        <div><a href="#">edit my profile</a></div>
                    </div>
                    <form action="" method="POST">
                        <h4>First name :</h4>
                        <input type="text" name="fname" class="form-input">
                        <h4>Last name :</h4>
                        <input type="text" name="lname" class="form-input">
                        <h4>Mobile phone number :</h4>
                        <input type="text" name="phone" class="form-input">
                        <h4>Birth date</h4>
                        <input type="date" name="bdate" class="form-input">
                        <h4>Email</h4>
                        <input type="text" name="email" class="form-input">
                    </form>	
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.html" %>
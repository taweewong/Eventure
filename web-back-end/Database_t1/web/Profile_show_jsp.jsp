<%-- 
    Document   : Profile_jsp
    Created on : Apr 9, 2017, 3:17:13 PM
    Author     : thitikron_gun
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,900" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/profile_show.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, user-scalable=false;">
        <%@include file="navbar_jsp.jsp" %>
    <body>

        <!-- CONTAINER ! -->
        <% Model.User user = new Model.User();

            user = (Model.User) session.getAttribute("user_session");

        %>

        <div class="container">
            <div class="wrapper center-block">
                <div class="col-lg-6 col-xs-12" id="left">
                    <div><img src="<%= user.getImage()%>" width="300" class="img-circle"></div>
                    <h2><%= user.getFirstname()%> <%= user.getLastname()%></h2>
                </div>
                <div class="col-lg-6 col-xs-12" id="right">
                    <div class="header">

                    <div><h1> My Profile </h1></div>
                        <div><a href="Profile_jsp.jsp">Edit profile</a></div>
                    </div>

                    <form action="" method="POST">
                        <h4>First name : </h4>
                        <input type="text" name="fname" value="<%= user.getFirstname()%>" class="form-input" disabled="">
                        <h4>Last name :</h4>
                        <input type="text" name="lname" value="<%= user.getLastname()%>" class="form-input" disabled="">
                        <h4>Mobile phone number :</h4>
                        <input type="text" name="phone" value="<%= user.getPhone()%>" class="form-input" disabled="">
                        <h4>Birth date</h4>
                        <input type="date" name="bdate" value="<%= user.getBdate()%>" class="form-input" disabled="">
                        <h4>Email</h4>
                        <input type="text" name="email" value="<%= user.getEmail()%>" class="form-input" disabled="">
                    </form>	
                </div>
            </div>
        </div>


    </body>
    <%@include file="footer.html" %>


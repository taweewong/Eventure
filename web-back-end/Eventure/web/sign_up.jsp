<%-- 
    Document   : sign_up
    Created on : Apr 11, 2017, 4:26:21 PM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/sign_in.css"/>
        <%@include file="navbar_jsp.jsp" %>
    <body>
        <div class="container">
            <div class="row">
                <div class="box col-md-8 col-md-offset-2">
                    <h3>Sign up</h3>
                    <p>Already member ? <a href="sign_in.jsp">sign in</a></p>
                    <div class="form">
                        <form method="POST">
                            <h4>Username :</h4>
                            <input type="text" name="username" class="form-input">
                            <h4>Email :</h4>
                            <input type="text" name="email" class="form-input"><br>
                            <h4>Password :</h4>
                            <input type="password" name="password" class="form-input"><br>
                            <h4>Confirm Password :</h4>
                            <input type="password" name="password-con" class="form-input"><br>
                            <br>
                            <p>Please enter personal information, We will contact by your mobile phone number.</p>
                            <h4>First name :</h4>
                            <input type="text" name="fname" class="form-input"><br>
                            <h4>Last name :</h4>
                            <input type="text" name="lname" class="form-input"><br>
                            <h4>Mobile phone number :</h4>
                            <input type="text" name="mobile" class="form-input"><br>
                            <h4>Birth Date :</h4>
                            <input type="date" name="bdate" class="form-input"><br>

                            <input type="submit" name="submit" value="Sign up" id="submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
<%@include file="footer.html" %>

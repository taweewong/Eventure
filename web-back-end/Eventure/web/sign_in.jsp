<%-- 
    Document   : sign_in
    Created on : Apr 11, 2017, 4:19:08 PM
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
                    <h3>Sign in</h3>
                    <p>Havn't registered yet ? <a href="sign_up.jsp">sign up</a></p>
                    <div class="form">
                        <form method="POST" action="NewServlet">
                            <h4>Username :</h4>
                            <input type="text" name="username" class="form-input">
                            <h4>Password :</h4>
                            <input type="password" name="password" class="form-input"><br>
                            <a href="#">Forget your password ?</a><br>
                            <input type="submit" name="submit" value="Sign in" id="submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.html" %>

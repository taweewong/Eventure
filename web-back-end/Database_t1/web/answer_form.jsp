<%-- 
    Document   : create_form
    Created on : Apr 20, 2017, 11:15:22 PM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Application Form</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/create_form.css">
        <%@include file="navbar_jsp.jsp" %>

    <body>
        <div class="container">
            <div class="rows title-box">
                <h1>Create Form</h1>
            </div>
            <div class="rows input-box">
                <form action="Create_form_Servlet">
                    <div id="input-name-div">
                        <h3>
                            Form name : 
                            <input class="name-input" type="text" name="event_name" id="event-name">
                        </h3>
                    </div>
                    <br>
                    <div id="my-form">
                        <div class="question">
                            <h3>Question 1 <span><i class="fa fa-trash-o" aria-hidden="true"></i></span></h3>
                            <textarea id="q1" class="input-question" rows="1" name="answer1"></textarea>
                            <hr align="left">
                            <br>
                        </div>
                    </div>

                        
                    <button class="btn btn-default" id="add-btn" type="button">Add question</button>
                    <br><br><br>
                    <button class="btn btn-success submit-btn" type="submit">submit</button>

                    
          
                </form>
            </div>
        </div>
        <script type="text/javascript" src="assets/js/create_form.js"></script>
    </body>
    <%@include file="footer.html" %>

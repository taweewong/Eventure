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
                <h1>Application Form</h1>
            </div>
            <%
                String event_id = (String) session.getAttribute("event_id_join");
            %>

            <div class="rows input-box">
                <form action="Answer_form_Servlet">



                    <div id="input-name-div">
                        <h3>
                            Form Name
                        </h3>
                    </div>
                    <br>
                    <div id="my-form">

                        <!-- Loop -->

                        <div class="answer">
                            <h3>Question 1</h3>
                            <textarea id="q1" class="input-question" rows="1" name="answer1"></textarea>
                            <hr align="left">
                            <br>
                        </div>

                        <!-- Loop -->
                        
                    </div>



                    <br><br><br>
                    <button class="btn btn-success submit-btn" type="submit" name="event_anwer_form" value="<%= event_id%>" >submit</button>



                </form>
            </div>
        </div>
        <script type="text/javascript" src="assets/js/answer_form.js"></script>
    </body>
    <%@include file="footer.html" %>
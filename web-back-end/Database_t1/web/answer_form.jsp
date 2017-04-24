<%-- 
    Document   : create_form
    Created on : Apr 20, 2017, 11:15:22 PM
    Author     : Taweewong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Real_Question"%>
<%@page import="Model.Question"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Model.Keep_Question"%>
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
                //String event_id = (String) session.getAttribute("event_id_join");
                Model.Event event_id = (Model.Event) session.getAttribute("event_session");
                System.out.println("event_join : >>>>>>>>>>>>>>>>>>>>>>>>>>>" + event_id.getEvent_id());

                LinkedList<Model.Real_Question> question_real = new LinkedList<Model.Real_Question>();
                question_real = (LinkedList<Model.Real_Question>) session.getAttribute("question_answer_form");
                List<Model.Real_Question> question_real_array = new ArrayList<Model.Real_Question>(question_real);
            %>

            <div class="rows input-box">
                <form action="Keep_answer_Servlet">



                    <div id="input-name-div">
                        <h3>
                            
                            <%= question_real_array.get(0).getForm_name() %>
                        </h3>
                    </div>
                    <br>
                    <div id="my-form">
                        
                        <!-- Loop -->
                        <% for(Model.Real_Question i: question_real_array) {%>
                        <div class="answer">
                            <h3><%= i.getQuestion() %></h3>
                            <textarea id="q1" class="input-question" rows="1" name="answer1"></textarea>
                            <hr align="left">
                            <br>
                        </div>

                        <!-- Loop -->
                        <% } %>
                    </div>



                    <br><br><br>
                    <input type="hidden" name="event_answer_form" value="<%= event_id.getEvent_id() %>">
                    <button class="btn btn-success submit-btn" type="submit">submit</button>



                </form>
            </div>
        </div>
        <script type="text/javascript" src="assets/js/answer_form.js"></script>
    </body>
    <%@include file="footer.html" %>
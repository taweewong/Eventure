<%-- 
    Document   : create_event
    Created on : Apr 21, 2017, 12:37:45 AM
    Author     : Taweewong
--%>

<%@page import="Model.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Eventure</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/edit_event.css">

        <%@include file="navbar_jsp.jsp" %>
    <body>
        <!-- CONTAINER ! -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
        <div class="container">
            <div class="row">
                <div class="box col-md-8 col-md-offset-2">
                    <h1 class="header">Edit Eventure</h1>
                    <% 
                        Event event = (Event) session.getAttribute("event_session");
                    %>
                    <form action="Update_event_Servlet" method="post" id="create_form">
                        <div class="dropdown" align="right">

                            <select class="selectpicker" name="category" form="create_form" title="select category" required>
                                <option value="01" >Technical</option>
                                <option value="02">Art & Music</option>
                                <option value="03">Sport & Health</option>
                                <option value="04">Community</option>
                                <option value="05">Food</option>
                                <option value="06" >IT</option>
                                <option value="07">Others</option>
                            </select>

                        </div>
                        <br>

                        <div class="form">
                            <div class="event">
                                Event Name : <input type="text" name="event_name" size="70" value="<%= event.getEvent_name() %>"><br><br>
                            </div>
                            <div class="form-input">
                                Date : <input type="date" name="date" value="<%= event.getDate_event()%>"></input> &nbsp; Time : <input type="time" name="time" value="<%= event.getEvent_start()%>"> &nbsp; Location : <input type="text" name="location" size="24" value="<%= event.getLocation() %>">
                                <br><br>
                                Organizer : <input type="text" name="organizer" value="<%= event.getOrganizer() %>"></input>
                                <br><br><br>      
                            </div>
                            <div class="big-box">
                                Event description : <br>
                                <textarea name="event_desc" rows="8" cols="84"><%= event.getDetail() %></textarea><br><br>
                            </div>
                            
                            <div class="sbutton">
                                <div class="button">
                                    <input type="submit" name="submit" value="Create Eventure" id="submit"> &nbsp; or &nbsp; <a href="index.jsp" id="blue">Discard</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.html" %>


<%-- 
    Document   : create_event
    Created on : Apr 21, 2017, 12:37:45 AM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Eventure</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/create_event.css">
        <%@include file="navbar_jsp.jsp" %>
    <body>
        <!-- CONTAINER ! -->
        
        <div class="container">
            <div class="row">
                <div class="box col-md-8 col-md-offset-2">
                    <h1 class="header">Create Eventure</h1>
                    <form action="Create_event_Servlet" method="post">
                    <div class="dropdown" align="right">
                        
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            Category :
                            <span class="caret"></span>
                        </button>

                        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                            <li ><a>Technical <input type="hidden" value="01" name="cate_id"/></a></li>
                            <li ><a>Art & Music <input type="hidden" value="02" name="cate_id"/></a></li>
                            <li ><a>Sport & Health <input type="hidden" value="03" name="cate_id"/></a></li>
                            <li ><a>Community <input type="hidden" value="04" name="cate_id"/></a></li>
                            <li ><a>Food <input type="hidden" value="05" name="cate_id"/></a></li>
                            <li ><a>IT <input type="hidden" value="06" name="cate_id"/></a></li>
                            <li ><a>Others <input type="hidden" value="07" name="cate_id"/></a></li>
                        </ul>

                    </div>
                    <br>
                                    
                        <div class="form">
                            <div class="event">
                                Event Name : <input type="text" name="event_name" size="70"><br><br>
                            </div>
                            <div class="form-input">
                                Date : <input type="date" name="date"></input> &nbsp; Time : <input type="time" name="time"> &nbsp; Location : <input type="text" name="location" size="24">
                                <br><br><br>
                            </div>
                            <div class="big-box">
                                Event description : <br>
                                <textarea name="event_desc" rows="8" cols="84"></textarea><br><br>
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


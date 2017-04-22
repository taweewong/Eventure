<%-- 
    Document   : index
    Created on : Apr 11, 2017, 3:24:40 PM
    Author     : Taweewong
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Model.Keep_Event"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Eventure</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/index.css"/>
        <%@include file="navbar_jsp.jsp" %>
    <body>
       
        <!-- CONTAINER -->
        <div class="container-fluid" id="big-pic">
            <div class="content">
                <h1>Explore more with us.</h1>
            </div>	
        </div>

        <div class="container-fluid">
            <!-- Category -->
            <form action="category_ex_Servlet" method="POST">
                <div class=category>
                    <button class="btn btn-default cate" type="submit" value="01" name="cate_ex" >Technical</button>
                    <button class="btn btn-default cate" type="submit" value="02" name="cate_ex" >Art & Music</button>
                    <button class="btn btn-default cate" type="submit" value="03" name="cate_ex" >Sport & Health</button>
                    <button class="btn btn-default cate" type="submit" value="04" name="cate_ex" >Community</button>
                    <button class="btn btn-default cate" type="submit" value="05" name="cate_ex" >Food</button>
                    <button class="btn btn-default cate" type="submit" value="06" name="cate_ex" >IT</button>
                    <button class="btn btn-default cate" type="submit" value="07" name="cate_ex" >Other</button>
                </div>

            </form>
            <!-- Upcoming -->
            <div class="upcoming">
                <div>
                    <div><h3>UPCOMMING EVENTS</h3></div>
                    <div class="see-all">see all</div>
                </div>
                <% LinkedList<Model.Event> events = new LinkedList<Model.Event>();
                    ServletContext ctx = getServletContext();
                    Connection conn = (Connection) ctx.getAttribute("connection");
                    Model.Keep_Event ke = new Model.Keep_Event(conn);
                    ke.query_time();
                    events = (LinkedList<Model.Event>) ke.getEvents();
                    //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
                    //System.out.println(events.get(0).getEvent_name());

                %>

                <div id="up-showcase">
                    <% for(Model.Event i: events) {%>
                    <a class="event-thumbnail" href="Event_Servlet" value="<% i.getEvent_id(); %>">
                        <div class=up-block>
                            <img class="up_pic" src="assets/css/pic/NoImageAvailable.png" width="210">
                            <h4><%= i.getEvent_name()%></h4>
                            <h5><i class="fa fa-map-marker" aria-hidden="true"></i> <%= i.getLocation()%></h5>
                            <h5><i class="fa fa-clock-o" aria-hidden="true"></i> <%= i.getDate_event()%> | <%= i.getEvent_start()%></h5>					
                        </div>
                    </a>
                    
                    <%}%>
                </div>
            </div>

            <!-- Explore -->
            <% LinkedList<Model.Event> explore = new LinkedList<Model.Event>();
                    
                    Model.Keep_Event kep = new Model.Keep_Event(conn);
                    kep.query_explore();
                    explore = (LinkedList<Model.Event>) kep.getEvents();
                    //Model.Event[] array = ke.toArray(new Model.Event[ke.size()]);
                    System.out.println(explore.get(0).getEvent_name());

                %>
            <div class="explore row">
                <div>
                    <div><h3>EXPLORE EVENTS</h3></div>					
                </div>
                <div id="exp-showcase" class="col-lg-12">
                    <% for(Model.Event i: explore) {%>
                    <% System.out.println("aaa"); %>
                    <a class="event-thumbnail" href="Event_Servlet" value="<% i.getEvent_id(); %>">
                        <div class="exp-block">
                            <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                            <h3><%= i.getEvent_name()%></h3>
                            <h4><i class="fa fa-map-marker" aria-hidden="true"></i> <%= i.getLocation() %></h4>
                            <h4><i class="fa fa-clock-o" aria-hidden="true"></i> <%= i.getDate_event()%> | <%= i.getEvent_start()%></h4>	
                        </div>
                    </a>
                    <% } %>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.html" %>

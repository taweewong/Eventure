<%-- 
    Document   : join_req
    Created on : Apr 20, 2017, 11:52:02 PM
    Author     : Taweewong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Keep_Question"%>
<%@page import="Model.Question"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Request</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/join_req.css">
        <%@include file="navbar_jsp.jsp" %>

    <body>
        <div class="container">
            <div class="rows head">
                <div class="col-xs-12 title">
                    <h1>Join Request</h1>
                </div>
            </div>
            <%
                //Model.Event event = new Model.Event();
                ServletContext ctx = getServletContext();
                Connection conn = (Connection) ctx.getAttribute("connection");
                LinkedList<Model.User> user_join = new LinkedList<>();
                //LinkedList<Model.Question> question = new LinkedList<Question>();
                String event = (String) session.getAttribute("event_join");
                user_join = (LinkedList<Model.User>) session.getAttribute("user_join");
                List<Model.User> user_join_array = new ArrayList<Model.User>( user_join);
                //LinkedList<Model.Question> question = new LinkedList<Question>();
                //question = (LinkedList<Model.Question>) session.getAttribute("question_join");

            %>
            <div class="rows box">
                <div class="box-body">
                    <% for (Model.User i : user_join_array) {%>
                    <div class="event-rows">
                        <div class="col-xs-8 detail-box">

                            <img class="img-circle" src="assets/css/pic/profile-icon.png" width="100">
                            <div class="request-name">
                                <h3><%= i.getFirstname() + " " + i.getLastname()%></h3>
                                <!-- <h4>View answer</h4> -->

                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" name="viewanswer" data-target="#<%= i.getUser_id()%>" value="<%= i.getUser_id()%>">
                                    View Answer
                                </button>

                            </div>
                        </div>
                        <form action="Approve_Servlet">
                            <div class="col-xs-2"><button type="submit" class="btn btn-default manage-btn" name="approve" value="<%= i.getUser_id() %>">Approve</button></div>
                        </form>
                        <form action="Reject_Servlet">
                            <div class="col-xs-2"><button type="submit" class="btn btn-default manage-btn" name="reject" value="<%= i.getUser_id() %>">Reject</button></div>
                        </form>                             
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="<%= i.getUser_id()%>" class="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <!-- <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                </div> -->
                                <div class="modal-body">
                                    <div>
                                        <img class="img-circle" src="assets/css/pic/profile-icon.png" width="75">
                                    </div>
                                    <div class="text-row">
                                        <h5>Name</h5>
                                        <% System.out.println(i.getFirstname() + " kuy " + i.getLastname());
                                            Keep_Question kq = new Keep_Question(conn);
                                            System.out.println(event+"userrrrrrrrrrrrrr"+i.getUser_id());
                                            kq.query_question(i.getUser_id(), event);
                                            session.setAttribute("question_join", kq.getQuestions());
                                            LinkedList<Model.Question> question = new LinkedList<>();
                                            question = (LinkedList<Model.Question>) kq.getQuestions();
                                            List<Model.Question> question_array = new ArrayList<Model.Question>(question);
                                        %>
                                        <h3 id="applicant-detail"><%= i.getFirstname() + " " + i.getLastname()%></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>E-mail</h5>
                                        <h3 id="applicant-detail"><%= i.getEmail()%></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>Age</h5>
                                        <h3 id="applicant-detail"><%= i.getBdate()%></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>Phone</h5>
                                        <h3 id="applicant-detail"><%= i.getPhone()%></h3>
                                    </div>
                                    <div class="rows modal-btn">
                                        <form action="Approve_Servlet">
                                            <div class="col-xs-4"><button type="submit" class="btn btn-default" name="approve" value="<%= i.getUser_id() %>">Approve</button></div>
                                        </form>
                                        <form action="Reject_Servlet">
                                            <div class="col-xs-4"><button type="submit" class="btn btn-default" name="reject" value="<%= i.getUser_id() %>">Reject</button></div>
                                        </form>
                                    </div>
                                    <div id="line"></div>
                                    <div class="q-form">
                                        <% for (Model.Question j : question_array) {%>
                                        <div class="question">
                                            <h4><%= j.getQUESTION()%> ?</h4>
                                        </div>
                                        <div class="answer">
                                            <p><%= j.getANSWER()%></p>
                                        </div>
                                        <% } %>
                                    </div>
                                </div>
                                <!-- <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                </div> -->
                            </div>
                        </div>
                    </div>
                    <!-- Modal -->
                    <%}%>
                </div>
            </div>		
        </div>
    </body>
    <%@include file="footer.html" %>

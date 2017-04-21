<%-- 
    Document   : join_req
    Created on : Apr 20, 2017, 11:52:02 PM
    Author     : Taweewong
--%>

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
                LinkedList<Model.User> user_join = new LinkedList<Model.User>();
                String event = (String) session.getAttribute("event_join");
                user_join = (LinkedList<Model.User>) session.getAttribute("user_join");

            %>
            <div class="rows box">
                <div class="box-body">
                    <% for(Model.User i: user_join){ %>
                    <div class="event-rows">
                        <div class="col-xs-8 detail-box">
                            
                            <img class="img-circle" src="assets/css/pic/profile-icon.png" width="100">
                            <div class="request-name">
                                <h3><%= i.getFirstname()+" "+i.getLastname() %></h3>
                                <!-- <h4>View answer</h4> -->
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                                    View Answer
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">Approve</button></div>
                        <div class="col-xs-2"><button type="button" class="btn btn-default manage-btn">Reject</button></div>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                                        <h3 id="applicant-detail"><%= i.getFirstname()+" "+i.getLastname() %></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>E-mail</h5>
                                        <h3 id="applicant-detail"><%= i.getEmail() %></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>Age</h5>
                                        <h3 id="applicant-detail"><%= i.getBdate() %></h3>
                                    </div>
                                    <div class="text-row">
                                        <h5>Phone</h5>
                                        <h3 id="applicant-detail"><%= i.getPhone() %></h3>
                                    </div>
                                    <div class="rows modal-btn">
                                        <div class="col-xs-4"><button type="button" class="btn btn-default">Approve</button></div>
                                        <div class="col-xs-4"><button type="button" class="btn btn-default">Reject</button></div>
                                    </div>
                                    <div id="line"></div>
                                    <div class="q-form">
                                        <div class="question">
                                            <h4>1+1 = ?</h4>
                                        </div>
                                        <div class="answer">
                                            <p>2</p>
                                        </div>
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

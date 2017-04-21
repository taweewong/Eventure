<%-- 
    Document   : navbar_jsp
    Created on : Apr 11, 2017, 11:12:39 AM
    Author     : Taweewong
--%>

<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,900" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="assets/css/navbar.css">
<!--<link rel="stylesheet" type="text/css" href="assets/css/footer.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, user-scalable=false;">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<header>
    <!-- NAV BAR -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">EVENTURE</a>
            </div>
            <div class="rows">
                <div class="col-lg-4 col-md-4 col-sm-4" id="search-div">
                    <div class="input-group" id="search-group">
                        <input type="text" class="form-control" id="search-bar" placeholder="Search events">
                        <span class="input-group-addon" id="search-btn">GO!</span>
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <%
                        if (session.getAttribute("status")==null || (Boolean) session.getAttribute("status") == false) {
                    %>
                    <ul class="nav navbar-nav navbar-right menu">
                        
                        <li><a href="sign_in.jsp">Sign in</a></li>
                        <li><a href="sign_up.jsp" id="blue">Sign up</a></li>
                    </ul>
                    <% } else { %>
                    <ul class="nav navbar-nav navbar-right menu">
                        <li><a id="blue" href="create_event.jsp">Create event</a></li>
                        <li>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" id="main-menu" type="button" data-toggle="dropdown">
                                    <img class="img-rounded" src="assets/css/pic/profile-icon.png" alt="Trolltunga Norway" width="50">
                                    <span id="menu-name"><span>Sea Methas</span> <i class="fa fa-chevron-down" aria-hidden="true"></i></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="Profile_jsp.jsp">Profile</a></li>
                                    <li><a href="My_event_Servlet">My event</a></li>
                                    <li><a href="History_Servlet">History</a></li>
                                    <li><a href="Sign_out_Servlets">Sign out</a></li>
                                </ul>
                            </div>
                        </li>
                        
                    </ul>
                    <% }%>
                </div><!-- /.navbar-collapse -->
            </div>

    </nav>
</header>


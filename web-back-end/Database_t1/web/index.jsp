<%-- 
    Document   : index
    Created on : Apr 11, 2017, 3:24:40 PM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical</title>
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
            <div class=category>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet';">Technical</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">Art & Music</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">Sport & Health</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">Community</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">Food</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">IT</button>
                <button class="btn btn-default cate" value="tech" onclick="location.href='category_ex_Servlet.java';">Other</button>
            </div>

            <!-- Upcoming -->
            <div class="upcoming">
                <div>
                    <div><h3>UPCOMMING EVENTS</h3></div>
                    <div class="see-all">see all</div>
                </div>
                <div id="up-showcase">
                    <div class=up-block>
                        <img class="up_pic" src="assets/css/pic/NoImageAvailable.png" width="210">
                        <h3>UNTITLED EVENT 1</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>					
                    </div>
                    <div class=up-block>
                        <img class="up_pic" src="assets/css/pic/NoImageAvailable.png" width="210">
                        <h3>UNTITLED EVENT 2</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class=up-block>
                        <img class="up_pic" src="assets/css/pic/NoImageAvailable.png" width="210">
                        <h3>UNTITLED EVENT 3</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class=up-block>
                        <img class="up_pic" src="assets/css/pic/NoImageAvailable.png" width="210">
                        <h3>UNTITLED EVENT 4</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                </div>
            </div>

            <!-- Explore -->
            <div class="explore row">
                <div>
                    <div><h3>EXPLORE EVENTS</h3></div>					
                </div>
                <div id="exp-showcase" class="col-lg-12">
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 5</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 6</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 7</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 8</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 9</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 10</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 11</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 12</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                    <div class="exp-block">
                        <img class="up_pic" src="assets/css/pic/noImageAvailable.jpg" width="300">
                        <h3>UNTITLED EVENT 13</h3>
                        <h4><i class="fa fa-map-marker" aria-hidden="true"></i> Somewhere on Earth</h4>
                        <h4><i class="fa fa-clock-o" aria-hidden="true"></i> 03/009/2017 | 13.00</h4>	
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="footer.html" %>

<%-- 
    Document   : sign_up
    Created on : Apr 11, 2017, 4:26:21 PM
    Author     : Taweewong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="assets/css/sign_in.css"/> 
        
        <%@include file="navbar_jsp.jsp" %>
    <body>
        <div class="container">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
            
            <div class="row">
                <div class="box col-md-8 col-md-offset-2">
                    <h3>Sign up</h3>
                    <p>Already member ? <a href="sign_in.jsp">sign in</a></p>
                    <div class="form">
                        <form action="Sign_up_Servlet" method="POST" id="signup_form">
                            <p id="just-star" style="color: red;">* is required</p>
                            <h4>Username : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="text" name="username" class="form-input" required>
                            <h4>Email : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="text" name="email" class="form-input" required><br>
                            <h4>Password : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="password" name="password" id="pass" class="form-input" required><br>
                            <h4>Confirm Password : <span id="just-star" style="color: red;">*</span> <span id="message"></span></h4>
                            <input type="password" name="password-con" id="pass-con" class="form-input" required ><br>
                            <br>
                            <p>Please enter personal information, We will contact by your mobile phone number.</p>
                            <h4>First name : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="text" name="fname" class="form-input" required><br>
                            <h4>Last name : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="text" name="lname" class="form-input" required><br>
                            <h4>Gender : <span id="just-star" style="color: red;">*</span></h4>
                            <select class="selectpicker" name="gender" form="signup_form" title="Select gender" required>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select><br><br>
                            <h4>Mobile phone number : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="text" name="mobile" class="form-input" required><br>
                            <h4>Birth Date : <span id="just-star" style="color: red;">*</span></h4>
                            <input type="date" name="bdate" class="form-input" required><br>
                            <h4>Address :</h4>
                            <input type="text" name="address" class="form-input"><br>
                            <h4>Occupation :</h4>
                            <input type="text" name="occupation" class="form-input"><br>

                            <input type="submit" name="submit" value="Sign up" id="submit">
                            
                        </form>
                        <script type="text/javascript" src="assets/js/sign_up.js"></script>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
    
    <%@include file="footer.html" %>
    

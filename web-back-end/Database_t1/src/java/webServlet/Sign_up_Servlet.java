/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thitikron_gun
 */
@WebServlet(name = "Sign_up_Servlet", urlPatterns = {"/Sign_up_Servlet"})
public class Sign_up_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
 /* TODO output your page here. You may use following sample code. */
            String Username = request.getParameter("username");
            String Email = request.getParameter("email");
            String Password = request.getParameter("password");
            String Password_Con = request.getParameter("password-con");
            String Fname = request.getParameter("fname");
            String Lname = request.getParameter("lname");
            String Mobile = request.getParameter("mobile");
            String Bdate = request.getParameter("bdate");
            String Gender = request.getParameter("gender");
            String Address = request.getParameter("address");
            String Occ = request.getParameter("occupation");
            String Image = "assets/image/profile_img/default.png";

            if (!(Password_Con.equals(Password))) {
                response.sendRedirect("sign_up.jsp");
                return;
            }

            if (Address.equals("")) {
                Address = "";
            }
            if (Occ == null) {
                Occ = "";
            }

            int acc;
            int user_id;

            String eventid = "0000";
            String adminid = null;

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");

            Statement stmt;
            Statement get_acc;
            Statement get_userid;
            try {
                //Add Acount ID
                get_acc = conn.createStatement();
                ResultSet res = get_acc.executeQuery("Select max(account_id) From ACCOUNT;");

                res.next();
                acc = Integer.parseInt(res.getString("max(account_id)")) + 1;

                //Add User ID
                get_userid = conn.createStatement();
                ResultSet res1 = get_userid.executeQuery("Select max(user_id) From MUSER;");

                res1.next();
                user_id = Integer.parseInt(res1.getString("max(user_id)")) + 1;

                stmt = conn.createStatement();
                String sql1 = "INSERT INTO ACCOUNT VALUES ('" + acc + "','" + Fname + "','" + Lname + "','" + Email + "','" + Mobile + "','" + Bdate + "','" + Address + "','" + Occ + "','" + user_id + "','" + Image + "','" + Gender + "');";
                stmt.executeUpdate(sql1);
                System.out.println(sql1);

                String sql2 = "INSERT INTO MUSER VALUES ('" + user_id + "','" + Username + "','" + Password + "','" + acc + "','" + eventid + "','" + adminid + "');";
                stmt.executeUpdate(sql2);
                System.out.println(sql2);

            } catch (SQLException ex) {
                Logger.getLogger(Sign_up_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("sign_in.jsp");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

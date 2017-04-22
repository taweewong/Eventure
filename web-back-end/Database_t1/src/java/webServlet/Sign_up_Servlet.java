/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
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
            
            String acc = "0000";
            String age = "0001";
            String address = "0001";
            String occ = "0001";
            String userid = "0000";
            String eventid = "0000";
            String adminid = "0000";
                    
            
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            
            Statement stmt;
            Statement get_acc;
            Statement get_userid;
            try {
                get_acc = conn.createStatement();
                ResultSet res = get_acc.executeQuery("Select * From ACCOUNT;");
                while (res.next())
                {
                    acc = res.getString("ACCOUNT_ID");
                    int account_new = Integer.parseInt(acc);
                    account_new ++;
                    acc = account_new+""; 
//                    String.format("%04d", acc);
                }
                
                get_userid = conn.createStatement();
                ResultSet res1 = get_userid.executeQuery("Select * From MUSER;");
                while (res1.next())
                {
                    userid = res1.getString("USER_ID");
                    int userid_new = Integer.parseInt(userid);
                    userid_new ++;
                    userid = userid_new+""; 
                    
                }
                
                stmt = conn.createStatement();
                String sql1 = "INSERT INTO ACCOUNT VALUES ('"+acc+"','"+Fname+"','"+Lname+"','"+Email+"','"+Mobile+"','"+Bdate+"','"+age+"','"+address+"','"+occ+"','"+userid+"','TEST');" ;
                stmt.executeUpdate(sql1);
                System.out.println(sql1);
                
                
       
                String sql2 = "INSERT INTO MUSER VALUES ('"+userid+"','"+Username+"','"+Password+"','"+acc+"','0000');" ;
                stmt.executeUpdate(sql2);
                System.out.println(sql2);
                
                
                
                String sql3 = "INSERT INTO RESERVE VALUES ('"+userid+"','0','2017-04-13');" ;
                stmt.executeUpdate(sql3);
                System.out.println(sql3);
                

            } catch (SQLException ex) {
                Logger.getLogger(Sign_up_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            RequestDispatcher pg = request.getRequestDispatcher("sign_in.jsp");
            pg.forward(request, response);
            
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

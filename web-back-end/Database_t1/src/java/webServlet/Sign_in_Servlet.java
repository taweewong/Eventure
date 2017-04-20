/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.tomcat.jni.Buffer.address;

/**
 *
 * @author thitikron_gun
 */
@WebServlet(name = "Sign_in_Servlet", urlPatterns = {"/Sign_in_Servlet"})
public class Sign_in_Servlet extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession(true);

            
            Boolean status_login = false;
            
            
            
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            int login;
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM muser where USERNAME = '" + username + "'";
                
                ResultSet rs = stmt.executeQuery(sql);
                
                
                
                
                if (rs.next()) {
                    
                    System.out.println(rs.getString("USERNAME"));
                    if (rs.getString("USERNAME").equals(username) && rs.getString("PASSWORD").equals(password)) {
                        out.println("pass");
                        String sql1 = "SELECT * FROM ACCOUNT where USER_ID= '" + rs.getString("USER_ID") + "'";
                        
                        
                        
                        
                        stmt = null;
                        ResultSet rs1 = null;
                        stmt = conn.createStatement();
                        rs1 = stmt.executeQuery(sql1);
                        rs1.next();
                        session.setAttribute("username", username);
                            
                        User user = new User(username, password, rs1.getString("EMAIL"), rs1.getString("USER_ID"), rs.getString("EVENT_ID"), rs.getString("ADMIN_ID"), rs1.getString("ACCOUNT_ID"), rs1.getString("FIRST_NAME"), rs1.getString("LAST_NAME"), rs1.getString("B_DATE"), rs1.getString("ADDRESS"), rs1.getString("PHONE"));
                        session.setAttribute("user_session", user);
                        
                        
//                        status_login = true;
//                        session.setAttribute("status", status_login);
////                        
                        login = 1;
                        session.setAttribute("status", true);
                        
                        
                        
                        
                        RequestDispatcher pg = request.getRequestDispatcher("index.jsp");
                        pg.forward(request, response);
                        
                        
                        
                        
                        
                    } else {
                        out.println("not pass");
                        session.setAttribute("status", false);
                    }

                } else {
                    out.println("sign up");
                    session.setAttribute("status", false);
                    RequestDispatcher pg = request.getRequestDispatcher("sign_up.html");
                    pg.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Sign_in_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

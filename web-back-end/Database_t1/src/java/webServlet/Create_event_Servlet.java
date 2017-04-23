/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.Keep_Event;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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

/**
 *
 * @author thitikron_gun
 */
@WebServlet(name = "Create_event_Servlet", urlPatterns = {"/Create_event_Servlet"})
public class Create_event_Servlet extends HttpServlet {

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
            
            String event_name = request.getParameter("event_name");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String location = request.getParameter("location");
            String event_desc = request.getParameter("event_desc");
            String organizer = request.getParameter("organizer");
            String cate_id = request.getParameter("category");


            HttpSession session = request.getSession(true);

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            
            Keep_Event ke = new Keep_Event(conn);
            ke.query_event_id();
            
            
            
            
            String event_id = ke.getNum();
  
            int eventid_new = Integer.parseInt(event_id);
            eventid_new++;
            event_id = eventid_new + "";
            
            
            String duration = "0";   
            User userid = (User) session.getAttribute("user_session");
            System.out.println(userid.getUser_id()+"jjjjjjjj");
            Statement stmt;
            
            try {
                
                
                
             stmt = conn.createStatement();
             String sql1 = "INSERT INTO EVENT VALUES ("+event_id+",'"+event_name+"','"+location+"',"+duration+",'"+event_desc+"','"+organizer+"',"+userid.getUser_id()+",'"+cate_id+"','"+date+"','"+time+"', NULL);";
                stmt.executeUpdate(sql1);
                System.out.println(sql1);
                
                
                
                
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Create_event_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                
          
            
            RequestDispatcher pg = request.getRequestDispatcher("index.jsp");
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

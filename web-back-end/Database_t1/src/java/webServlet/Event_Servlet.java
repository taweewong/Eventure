/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.Event;
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

/**
 *
 * @author thitikron_gun
 */
@WebServlet(name = "Event_Servlet", urlPatterns = {"/Event_Servlet"})
public class Event_Servlet extends HttpServlet {

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
            
            String EVENT_ID ="0000";
            HttpSession session = request.getSession(true);

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");

            Statement stmt = null;
            
            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM EVENT where EVENT_ID = '" + EVENT_ID + "'";
                ResultSet rs = stmt.executeQuery(sql);
                
                stmt = null;
                ResultSet rs1 = null;
                stmt = conn.createStatement();
                rs1 = stmt.executeQuery(sql);
                rs1.next();
                
                session.setAttribute("EVENT_ID", EVENT_ID);

                Event event = new Event(EVENT_ID, rs1.getString("EVENT_NAME"), rs1.getString("LOCATION"), rs1.getString("DURATION"), rs1.getString("DETAIL"), rs1.getString("ORGANIZER"), rs1.getString("CATE_ID"));
                session.setAttribute("event_session", event);

                
           
                
                RequestDispatcher pg = request.getRequestDispatcher("event.jsp");
                pg.forward(request, response);
                        
                        
            } catch (SQLException ex) {
                Logger.getLogger(Event_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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

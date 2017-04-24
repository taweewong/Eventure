/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.Event;
import Model.Muser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Taweewong
 */
@WebServlet(name = "Edit_event_Servlet", urlPatterns = {"/Edit_event_Servlet"})
public class Edit_event_Servlet extends HttpServlet {

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
            
            String event_id = request.getParameter("event_id"); //request.getParameter("event_id")
            
            Event event = new Event();
            
            HttpSession session = request.getSession();

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");

            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM event WHERE event_id = '" + event_id + "';";

                ResultSet rs = stmt.executeQuery(sql);
                
                if (rs.next()) {
                    event.setEvent_id(event_id);
                    event.setEvent_name(rs.getString("EVENT_NAME"));
                    event.setLocation(rs.getString("LOCATION"));
                    event.setDetail(rs.getString("DETAIL"));
                    event.setOrganizer(rs.getString("ORGANIZER"));
                    event.setDate_event(rs.getDate("DATE_EVENT"));
                    event.setEvent_start(rs.getTime("EVENT_START"));
                    event.setImage(rs.getString("IMAGE"));
                }
                
                session.setAttribute("event_session", event);
                
                response.sendRedirect("edit_event.jsp");

                
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

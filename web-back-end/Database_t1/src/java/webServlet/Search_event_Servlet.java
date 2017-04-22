/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.Keep_Event;
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
@WebServlet(name = "Search_event_Servlet", urlPatterns = {"/Search_event_Servlet"})
public class Search_event_Servlet extends HttpServlet {

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
            String search_request = request.getParameter("search_request");
            System.out.println(search_request);
            
            HttpSession session = request.getSession(true);           
            Boolean status_login = false;
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            int ST=0;
            Statement stmt = null;

            try {
                stmt = conn.createStatement();
                
                String sql = "SELECT * FROM EVENT WHERE EVENT_NAME LIKE '%"+search_request+"%';";                
                ResultSet rs = stmt.executeQuery(sql);
                
                if (!rs.isBeforeFirst()) {
                    ST++;
                    session.setAttribute("EVENT_SEARCH", search_request);
                    session.setAttribute("ST", ST);
                    RequestDispatcher pg = request.getRequestDispatcher("search_event.jsp");
                    pg.forward(request, response);
                }
                
                Keep_Event S_event = new Keep_Event(conn);
                S_event.query_search_event(search_request);

                session.setAttribute("event_list", S_event.getEvents());
                session.setAttribute("ST", ST);
                session.setAttribute("EVENT_SEARCH", search_request);
                RequestDispatcher pg = request.getRequestDispatcher("search_event.jsp");
                pg.forward(request, response);
                
                
                
                if (rs.next()) {}
            } catch (SQLException ex) {
                Logger.getLogger(Search_event_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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

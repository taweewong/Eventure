/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import Model.Event;
import Model.Keep_Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
@WebServlet(name = "category_ex_Servlet", urlPatterns = {"/category_ex_Servlet"})
public class Category_ex_Servlet extends HttpServlet {

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
            HttpSession session = request.getSession(true);

            List <Event> events = null;
            
            Boolean status_login = false;
            
            String value = request.getParameter("cate_ex");
            System.out.println(value);
           
            
            String CATE_ID = request.getParameter("cate_ex");
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            int login;
            Statement stmt = null;
            
            try {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM CATEGORY JOIN EVENT USING (CATE_ID) WHERE CATE_ID = '"+CATE_ID+"'";
                ResultSet rs = stmt.executeQuery(sql);
                Keep_Event kevent = new Keep_Event(conn);
                kevent.show_cate_id(CATE_ID);

                session.setAttribute("event_list", kevent.getEvents());
                
                RequestDispatcher pg = request.getRequestDispatcher("category_ex.jsp");
                pg.forward(request, response);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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

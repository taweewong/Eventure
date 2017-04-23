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
@WebServlet(name = "Admin_Servlet", urlPatterns = {"/Admin_Servlet"})
public class Admin_Servlet extends HttpServlet {

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
                       
            String evnet_id = request.getParameter("evnet_id");
            String user_id = request.getParameter("user_id");
            System.out.println(evnet_id);
            
//            int evnet_id_num = Integer.parseInt(evnet_id);
//            int user_id_num = Integer.parseInt(user_id);
            
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            Statement stmt = null;
            
            
            
            if(evnet_id != null){
                int evnet_id_num = Integer.parseInt(evnet_id);
                try {
                    stmt = conn.createStatement();
                    String sql = "delete from EVENT where EVENT_ID = "+ evnet_id_num +";" ;  
                    String sql2 = "delete from FILL where EVENT_ID = "+ evnet_id_num +";" ; 
                    String sql3 = "delete from RESERVE where EVENT_ID = "+ evnet_id_num +";" ;
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);
                    stmt.executeUpdate(sql3);

                    } catch (SQLException ex) {
                        Logger.getLogger(Admin_Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            else if (user_id != null){
                  int user_id_num = Integer.parseInt(user_id);
                try {
                    stmt = conn.createStatement();
                    String sql = "delete from ACCOUNT where USER_ID = "+ user_id_num +";" ;
                    String sql2 = "delete from MUSER where USER_ID = "+ user_id_num +";" ;
                    String sql3 = "delete from RESERVE where USER_ID = "+ user_id_num +";" ;
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);
                    stmt.executeUpdate(sql3);

                    } catch (SQLException ex) {
                        Logger.getLogger(Admin_Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            
            
            
            RequestDispatcher pg = request.getRequestDispatcher("admin.jsp");
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

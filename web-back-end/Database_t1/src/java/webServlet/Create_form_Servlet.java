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

/**
 *
 * @author Sea
 */
@WebServlet(name = "Create_form_Servlet", urlPatterns = {"/Create_form_Servlet"})
public class Create_form_Servlet extends HttpServlet {

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
            String[] answer;

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            String title = request.getParameter("event_name");
            answer = request.getParameterValues("answer1");
            Statement stmt = null;
            Statement stmt1 = null;
            ResultSet rs;
            ResultSet rs1;
            try {
                stmt = conn.createStatement();
                stmt1 = conn.createStatement();
                rs1 = null;
                String get_form_id = "SELECT max(FORM_ID) maxform FROM application_form";
                rs1 = stmt1.executeQuery(get_form_id);
                rs1.next();
                int plus_form = Integer.parseInt( rs1.getString("maxform"));
                plus_form++;
                String sql1 = "INSERT INTO application_form VALUES("+plus_form+",'"+title+"')";
                stmt.executeUpdate(sql1);
                
                for (String i : answer) {
                    rs = null;
                    
                    String get_num = "SELECT max(QUESTION_ID) maxnum FROM question";
                    
                    
                    rs = stmt.executeQuery(get_num);
                    rs.next();
                    
                    int plus_num = Integer.parseInt( rs.getString("maxnum"));
                    
                    System.out.println(Integer.parseInt( rs.getString("maxnum")));
                    plus_num++;
                    
                    System.out.println(plus_form);
                    String sql = "INSERT INTO question VALUES("+plus_num+",'"+i+"',"+plus_form+")";
                    
                    stmt.executeUpdate(sql);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Create_form_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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

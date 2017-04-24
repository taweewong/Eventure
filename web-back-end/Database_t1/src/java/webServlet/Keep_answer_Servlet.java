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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sea
 */
@WebServlet(name = "Keep_answer_Servlet", urlPatterns = {"/Keep_answer_Servlet"})
public class Keep_answer_Servlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");
            String title = request.getParameter("event_name");
            String event_id = request.getParameter("event_answer_form");
            Model.User user_id = (Model.User) session.getAttribute("user_session");
            answer = request.getParameterValues("answer1");
            Statement stmt = null;
            Statement stmt1 = null;
            ResultSet rs;
            ResultSet rs1;
            LinkedList<Model.Real_Question> question = new LinkedList<Model.Real_Question>();
            question = (LinkedList<Model.Real_Question>) session.getAttribute("question_answer_form");
            int count = 0;
            try {
                stmt = conn.createStatement();
                stmt1 = conn.createStatement();
                
                rs1 = null;
                
                for (String i : answer) {
                    rs = null;
                    
                    String get_num = "SELECT max(ANSWER_ID) maxnum FROM ANSWER";
                    
                    
                    rs = stmt.executeQuery(get_num);
                    rs.next();
                    
                    int plus_num = Integer.parseInt( rs.getString("maxnum"));
                    
                    System.out.println(Integer.parseInt( rs.getString("maxnum")));
                    plus_num++;
                    
                    //System.out.println(plus_form);
                    String sql = "INSERT INTO answer VALUES("+plus_num+",'"+i+"',"+question.get(count).getQuestion_id()+")";
                    count++;
                    stmt.executeUpdate(sql);
                    System.out.println(user_id.getUser_id()+"       "+event_id);
                    String sql1 = "INSERT INTO fill VALUES('"+user_id.getUser_id()+"','"+plus_num+"')";
                    stmt.executeUpdate(sql1);
                    
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

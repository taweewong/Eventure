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
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Taweewong
 */
@WebServlet(name = "Update_event_Servlet", urlPatterns = {"/Update_event_Servlet"})
@MultipartConfig()
public class Update_event_Servlet extends HttpServlet {

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

            String event_name = request.getParameter("event_name");
            String location = request.getParameter("location");
            String detail = request.getParameter("event_desc");
            String organizer = request.getParameter("organizer");
            String event_start = request.getParameter("time");
            String date_event = request.getParameter("date");
            String cate_id = request.getParameter("category");

            String event_id = request.getParameter("event_id");

            Event event = new Event();

            HttpSession session = request.getSession();

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");

            String app = request.getServletContext().getRealPath("");
            String savepath = app + "assets/image/event_img/";
            Part part = request.getPart("file");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            
            

            if (!fileName.equals("")) {
                part.write(savepath + event_id + "_event_img.jpg");
                System.out.println("WRITED !");
            }

            String image;
            image = ("assets/image/event_img/" + event_id + "_event_img.jpg");

            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                String sql = "UPDATE event "
                        + "SET event_name = '" + event_name + "', "
                        + "location = '" + location + "', "
                        + "detail = '" + detail + "', "
                        + "organizer = '" + organizer + "', "
                        + "event_start = '" + event_start + "', "
                        + "cate_id = '" + cate_id + "', "
                        + "image = '" + image + "', "
                        + "date_event = '" + date_event + "'"
                        + "WHERE event_id = '" + event_id + "';";

                System.out.println(sql);

                stmt.executeUpdate(sql);

                event.setEvent_id(event_id);
                event.setEvent_name(event_name);
                event.setLocation(location);
                event.setDetail(detail);
                event.setOrganizer(organizer);
                //event.setDate_event(date_event);
                //event.setEvent_start(event_start);
                event.setImage(image);
                
                System.out.println("IMG eieiza : " + event.getImage());
                
                session.setAttribute("event_session", event);
                
                System.out.println("BOBO BOBO : " + ((Event) session.getAttribute("event_session")).getImage());

                response.sendRedirect("Event_Servlet?eid=" + event_id);

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

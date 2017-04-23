/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Update_profile_Servlet", urlPatterns = {"/Update_profile_Servlet"})
@MultipartConfig()
public class Update_profile_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Model.User user = new Model.User();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String bdate = request.getParameter("bdate");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String occupation = request.getParameter("occupation");

            user = (Model.User) session.getAttribute("user_session");

            System.out.println("USER_ID : " + user.getUser_id());

            ServletContext ctx = getServletContext();
            Connection conn = (Connection) ctx.getAttribute("connection");

            //IMAGE UPLOADER
            /*
                Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                InputStream fileContent = filePart.getInputStream();
                System.out.println("filename : " + fileName);
                
                //filePart.write(fileName);
                
                File file = new File("C:‪/Users/Taweewong/Downloads/doge.jpeg");
                file.createNewFile();
             */
            //new File(savepath).mkdir();
            String app = request.getServletContext().getRealPath("");
            String savepath = app + "assets\\image\\profile_img\\";
            Part part = request.getPart("file");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if (!fileName.equals("")) {
                part.write(savepath + user.getUser_id() + "_profile_img.jpg");
                System.out.println("WRITED !");
            }

            String image;
            image = ("assets/image/profile_img/" + user.getUser_id() + "_profile_img.jpg");

            //UPDATE DATA BASE
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                String sql = "UPDATE account "
                        + "SET first_name = '" + fname + "', "
                        + "last_name = '" + lname + "', "
                        + "email = '" + email + "', "
                        + "phone = '" + phone + "', "
                        + "b_date = '" + bdate + "', "
                        + "address = '" + address + "', "
                        + "occupation = '" + occupation + "', "
                        + "gender = '" + gender + "', "
                        + "image = '" + image + "'"
                        + "WHERE user_id = '" + user.getUser_id() + "'";

                stmt.executeUpdate(sql);

                user.setFirstname(fname);
                user.setLastname(lname);
                user.setEmail(email);
                user.setPassword(phone);
                user.setBdate(bdate);
                user.setAddress(address);
                user.setOccupation(occupation);
                user.setImage(image);
                user.setGender(gender);

            } catch (SQLException ex) {
                Logger.getLogger(Update_profile_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect("Profile_show_jsp.jsp");

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

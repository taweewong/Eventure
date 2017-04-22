/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webServlet.Category_ex_Servlet;

/**
 *
 * @author Sea
 */
public class Keep_User {
    List <User> users;
    Connection conn;
    
    
    
    public void show_user_lists(String EVENT_ID) {
        try {
            System.out.println(EVENT_ID);
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM account join muser using (USER_ID) join reserve using (USER_ID) join event using (EVENT_ID) where EVENT_ID ='"+EVENT_ID+"'";
            rs = stmt.executeQuery(sql);
//                System.out.println(sql);
            while (rs.next()) {
                System.out.println("user");
                User user_ex = new User();
                user_ex.setAccount_id(rs.getString("ACCOUNT_ID"));
                user_ex.setAddress(rs.getString("ADDRESS"));
                user_ex.setAdmin_id(rs.getString("ADMIN_ID"));
                user_ex.setBdate(rs.getString("B_DATE"));
                user_ex.setEmail(rs.getString("EMAIL"));
                user_ex.setEvent_id(rs.getString("EVENT_ID"));
                user_ex.setFirstname(rs.getString("FIRST_NAME"));
                user_ex.setLastname(rs.getString("LAST_NAME"));
                user_ex.setPassword(rs.getString("PASSWORD"));
                user_ex.setPhone(rs.getString("PHONE"));
                user_ex.setUser_id(rs.getString("USER_ID"));
                user_ex.setUsername(rs.getString("USERNAME"));
                
                
                
                
                
                users.add(user_ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public Keep_User(Connection conn){
        this.conn = conn;
        users = new LinkedList<User>();
    }
    public void removeItem(String EVENT_ID){
        users.remove(EVENT_ID);
    }
    
    
}

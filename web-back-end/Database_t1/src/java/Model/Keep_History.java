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
import javax.servlet.ServletContext;

/**
 *
 * @author thitikron_gun
 */
public class Keep_History {

    List <History> history;
    Connection conn;
    
    public Keep_History() {
    }
    

    public void show_history(String USER_ID) {
        try {
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT DATE_RESERVE, EVENT_NAME, LOCATION FROM RESERVE JOIN EVENT USING (USER_ID) where USER_ID ='1' GROUP BY EVENT_NAME;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                History ev = new History();
                ev.setUser_id(USER_ID);
                ev.setDate_reserve(rs.getString("DATE_RESERVE"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                history.add(ev);
            }
            
             } catch (SQLException ex) {
            Logger.getLogger(Keep_History.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public List<History> getHistory() {
        return history;
    }

    public Keep_History(Connection conn) {
        this.conn = conn;
        history = new LinkedList<History>();
    }
    
    public void removeItem(String USER_ID){
        history.remove(USER_ID);
    }
    
    
     private ServletContext getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import webServlet.Category_ex_Servlet;

/**
 *
 * @author thitikron_gun
 */
public class Keep_Event {

    List<Event> events;
    Connection conn;
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Keep_Event() {
    }

    public void show_cate_id(String CATE_ID) {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CATEGORY JOIN EVENT USING (CATE_ID) WHERE CATE_ID = '" + CATE_ID + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Event ev = new Event();
                ev.setCate_id(CATE_ID);
                ev.setDetail(rs.getString("DETAIL"));
                ev.setEvent_id(rs.getString("EVENT_ID"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                
                ev.setOrganizer(rs.getString("ORGANIZER"));
                ev.setDate_event(rs.getDate("DATE_EVENT"));
                ev.setEvent_start(rs.getTime("EVENT_START"));
                events.add(ev);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void query_time() {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CATEGORY JOIN EVENT USING (CATE_ID) ORDER BY DATE_EVENT limit 4";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Event ev = new Event();
                ev.setCate_id(rs.getString("CATE_ID"));
                ev.setDetail(rs.getString("DETAIL"));
                ev.setEvent_id(rs.getString("EVENT_ID"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                
                ev.setOrganizer(rs.getString("ORGANIZER"));
                ev.setDate_event(rs.getDate("DATE_EVENT"));
                ev.setEvent_start(rs.getTime("EVENT_START"));
                events.add(ev);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void query_explore() {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CATEGORY JOIN EVENT USING (CATE_ID) limit 8";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Event ev = new Event();
                ev.setCate_id(rs.getString("CATE_ID"));
                ev.setDetail(rs.getString("DETAIL"));
                ev.setEvent_id(rs.getString("EVENT_ID"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                
                ev.setOrganizer(rs.getString("ORGANIZER"));
                ev.setDate_event(rs.getDate("DATE_EVENT"));
                ev.setEvent_start(rs.getTime("EVENT_START"));
                events.add(ev);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void query_my_event(String USER_ID) {
        try {
            
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CATEGORY JOIN EVENT USING (CATE_ID) where user_id ='" + USER_ID + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Event ev = new Event();
                ev.setCate_id(rs.getString("CATE_ID"));
                ev.setDetail(rs.getString("DETAIL"));
                ev.setEvent_id(rs.getString("EVENT_ID"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                
                ev.setOrganizer(rs.getString("ORGANIZER"));
                ev.setDate_event(rs.getDate("DATE_EVENT"));
                ev.setEvent_start(rs.getTime("EVENT_START"));
                events.add(ev);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void query_event_information(String event_id) {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM event where event_id ='"+event_id+"'";
            rs = stmt.executeQuery(sql);

            rs.next();

            Event ev = new Event();
            ev.setCate_id(rs.getString("CATE_ID"));
            ev.setDetail(rs.getString("DETAIL"));
            ev.setEvent_id(rs.getString("EVENT_ID"));
            ev.setEvent_name(rs.getString("EVENT_NAME"));
            ev.setLocation(rs.getString("LOCATION"));
            
            ev.setOrganizer(rs.getString("ORGANIZER"));
            ev.setDate_event(rs.getDate("DATE_EVENT"));
            ev.setEvent_start(rs.getTime("EVENT_START"));
            ev.setDate_event(rs.getDate("DATE_EVENT"));
            ev.setEvent_start(rs.getTime("EVENT_START"));
            events.add(ev);

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void query_event_id() {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT MAX(EVENT_ID) maxevent FROM EVENT;";
            rs = stmt.executeQuery(sql);

            rs.next();

            this.num = (String) rs.getString("maxevent");

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    public void query_search_event(String EVENT_NAME) {
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EVENT WHERE EVENT_NAME LIKE '%"+EVENT_NAME+"%';";
            rs = stmt.executeQuery(sql);

            
            
            while (rs.next()) {

                Event ev = new Event();
                ev.setCate_id(rs.getString("CATE_ID"));
                ev.setDetail(rs.getString("DETAIL"));
                ev.setEvent_id(rs.getString("EVENT_ID"));
                ev.setEvent_name(rs.getString("EVENT_NAME"));
                ev.setLocation(rs.getString("LOCATION"));
                
                ev.setOrganizer(rs.getString("ORGANIZER"));
                ev.setDate_event(rs.getDate("DATE_EVENT"));
                ev.setEvent_start(rs.getTime("EVENT_START"));
                events.add(ev);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Event> getEvents() {
        return events;
    }

    public Keep_Event(Connection conn) {
        this.conn = conn;
        events = new LinkedList<Event>();
    }

    public void removeItem(String CAED_ID) {
        events.remove(CAED_ID);
    }

    private ServletContext getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

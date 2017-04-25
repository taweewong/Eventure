/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import webServlet.Category_ex_Servlet;

/**
 *
 * @author thitikron_gun
 */
public class Event implements Serializable{
    private String event_id;
    private String event_name;
    private String location;
    private String duration;
    private String detail;
    private String organizer;
    private String cate_id;
    private Date date_event;
    private Time event_start;
    private String user_id;
    private int Form_id;
    private String image;
    
    

    public Event(String event_id, String event_name, String location, String duration, String detail, String organizer, String cate_id, Date date_event, Time event_start, String user_id, int Form_id, String image) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.location = location;
        this.duration = duration;
        this.detail = detail;
        this.organizer = organizer;
        this.cate_id = cate_id;
        this.date_event = date_event;
        this.event_start = event_start;
        this.user_id = user_id;
        this.Form_id = Form_id;
        this.image = image;
    }

    public int getForm_id() {
        return Form_id;
    }

    public void setForm_id(int Form_id) {
        this.Form_id = Form_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

   
    
    
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    
    
    

    
    public Event() {
    }

    

    

    

    

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Time getEvent_start() {
        return event_start;
    }

    public void setEvent_start(Time event_start) {
        this.event_start = event_start;
    }

    
    
    
    
    
    
    
    
    private ServletContext getServletContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
}

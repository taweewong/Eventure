/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author thitikron_gun
 */
public class History {
    private String user_id;
     private String date_reserve;
      private String event_name;
       private String location;
       

    public History() {
    }

    public History(String user_id, String date_reserve, String event_name, String location) {
        this.user_id = user_id;
        this.date_reserve = date_reserve;
        this.event_name = event_name;
        this.location = location;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    
    
    
    

    public String getDate_reserve() {
        return date_reserve;
    }

    public void setDate_reserve(String date_reserve) {
        this.date_reserve = date_reserve;
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


    
    
    
}

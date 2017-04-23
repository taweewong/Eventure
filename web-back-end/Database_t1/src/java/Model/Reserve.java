/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sea
 */
public class Reserve {
    private String USER_ID;
    private String EVENT_ID;
    private String STATUS;
    private String JOIN;

    public String getJOIN() {
        return JOIN;
    }

    public void setJOIN(String JOIN) {
        this.JOIN = JOIN;
    }

    public Reserve(String USER_ID, String EVENT_ID, String STATUS, String JOIN) {
        this.USER_ID = USER_ID;
        this.EVENT_ID = EVENT_ID;
        this.STATUS = STATUS;
        this.JOIN = JOIN;
    }
    
    

    public Reserve() {
    }

    
    
    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getEVENT_ID() {
        return EVENT_ID;
    }

    public void setEVENT_ID(String EVENT_ID) {
        this.EVENT_ID = EVENT_ID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
    
    
}

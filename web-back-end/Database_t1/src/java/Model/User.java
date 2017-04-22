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
public class User {
    //SELECT * FROM account join muser using (USER_ID) join reserve using (USER_ID) join event using (EVENT_ID) where EVENT_ID = 0000
    
    private String username;
    private String password ;
    private String email;
    private String user_id;
    private String admin_id;
    private String event_id;
    private String account_id;
    private String firstname;
    private String lastname;
    private String bdate;
    private String address;
    private String phone;
    private String image;
    private String occupation;
    
    
    public User() {
    }

    public User(String username, String password, String email, String user_id, String event_id, String admin_id, String account_id, String firstname, String lastname, String bdate, String address, String phone, String image, String occupation) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.user_id = user_id;
        this.admin_id = admin_id;
        this.account_id = account_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bdate = bdate;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.occupation = occupation;
    }

   
    
    
    
    

    public String getEvent_id() {
        return event_id;
    }
    
   
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }
     
    
    

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    
    
    
    
}
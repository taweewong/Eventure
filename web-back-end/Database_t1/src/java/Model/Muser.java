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
public class Muser {
    private String user_id;
    private String username;
    private String password;
    private String account_id;
    private String admin_id;

    public Muser() {
    }

    
    
    
    public Muser(String user_id, String username, String password, String account_id, String admin_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.account_id = account_id;
        this.admin_id = admin_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    
    
}

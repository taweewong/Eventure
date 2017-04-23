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
public class Keep_Question {
    List<Question> questions;
    Connection conn;
    Reserve keep_reserve;

    public Reserve getKeep_reserve() {
        return keep_reserve;
    }

    public void setKeep_reserve(Reserve keep_reserve) {
        this.keep_reserve = keep_reserve;
    }

    

    
    
    public void query_question(String USER_ID, String EVENT_ID){
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM muser join fill using (USER_ID) join answer using (ANSWER_ID) join question using (QUESTION_ID) join application_form using (FORM_ID) join reserve r using (USER_ID) group by QUESTION_ID, USER_ID having r.EVENT_ID ='"+EVENT_ID+"' and USER_ID ='"+USER_ID+"';";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                Question qt = new Question();
                qt.setQUESTION_ID(rs.getInt("QUESTION_ID"));
                qt.setQUESTION(rs.getString("QUESTION"));
                qt.setFORM_ID(rs.getInt("FORM_ID"));
                qt.setANSWER_ID(rs.getInt("ANSWER_ID"));
                qt.setANSWER(rs.getString("ANSWER"));
                qt.setSTATUS(rs.getString("STATUS"));
                questions.add(qt);
                //questions.add(qt);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void status_join(String USER_ID, String EVENT_ID){
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM reserve WHERE USER_ID ='"+USER_ID+"' AND EVENT_ID ='"+EVENT_ID+"'";
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                
                System.out.println("test"+rs.getString("EVENT_ID"));
                Reserve reserve = new Reserve();
                reserve.setEVENT_ID(rs.getString("EVENT_ID"));
                reserve.setSTATUS(rs.getString("STATUS"));
                reserve.setUSER_ID(rs.getString("USER_ID"));
                reserve.setJOIN("1");
                //questions.add(qt);
                setKeep_reserve(reserve);
                
            }
            else{
                Reserve reserve = new Reserve();
                reserve.setJOIN("0");
                //questions.add(qt);
                setKeep_reserve(reserve);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Keep_Question(Connection conn) {
        this.conn = conn;
        questions = new LinkedList<>();
    }
    
    
    
    public List<Question> getQuestions() {
        return questions;
    }

    private void keep_reserve(Reserve reserve) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
}

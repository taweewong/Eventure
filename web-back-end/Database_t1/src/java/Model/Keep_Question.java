/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
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
public class Keep_Question implements Serializable{
    List<Question> questions;
    List<Real_Question> real_questions;
    Connection conn;
    Reserve keep_reserve;

    public Reserve getKeep_reserve() {
        return keep_reserve;
    }

    public void setKeep_reserve(Reserve keep_reserve) {
        this.keep_reserve = keep_reserve;
    }

    
    public void query_question_form(String EVENT_ID){
        try {

            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM event join question USING (FORM_ID) join application_form using (FORM_ID) where EVENT_ID='"+ EVENT_ID + "'"; 
            rs = stmt.executeQuery(sql);
            System.out.println(EVENT_ID+"         abc");
            while (rs.next()) {
                System.out.println("");
                System.out.println("real");
                Real_Question rqt = new Real_Question();
                rqt.setQuestion_id(rs.getInt("QUESTION_ID"));
                rqt.setQuestion(rs.getString("QUESTION"));
                rqt.setForm_id(rs.getInt("FORM_ID"));
                rqt.setForm_name(rs.getString("TITLE"));
                real_questions.add(rqt);
                //questions.add(qt);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category_ex_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void query_question(String USER_ID, String EVENT_ID){
        try {

            Statement stmt = null;
            ResultSet rs = null;
            ResultSet rs1 = null;
            stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            //String sql = "SELECT * FROM muser join fill using (USER_ID) join answer using (ANSWER_ID) join question using (QUESTION_ID) join application_form using (FORM_ID) join reserve r using (USER_ID) group by QUESTION_ID, USER_ID having r.EVENT_ID ='"+EVENT_ID+"' and USER_ID ='"+USER_ID+"';";
            String sql = "SELECT distinct * FROM fill join muser m using(USER_ID) join answer using(ANSWER_ID) join question using(QUESTION_ID) join application_form using(FORM_ID) join event using(FORM_ID) group by QUESTION_ID, m.USER_ID having m.USER_ID = "+ USER_ID + " and EVENT_ID =" + EVENT_ID +";";
            String sql1 = "SELECT * FROM reserve WHERE USER_ID ='"+USER_ID+"' AND EVENT_ID ='"+EVENT_ID+"'";
            rs = stmt.executeQuery(sql);
            rs1 = stmt1.executeQuery(sql1);
            while (rs.next()) {
                rs1.next();
                System.out.println("answer");
                Question qt = new Question();
                qt.setQUESTION_ID(rs.getInt("QUESTION_ID"));
                qt.setQUESTION(rs.getString("QUESTION"));
                qt.setFORM_ID(rs.getInt("FORM_ID"));
                qt.setANSWER_ID(rs.getInt("ANSWER_ID"));
                qt.setANSWER(rs.getString("ANSWER"));
                //qt.setSTATUS(rs1.getString("STATUS"));
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
        real_questions = new LinkedList<>();
    }

    public List<Real_Question> getReal_questions() {
        return real_questions;
    }
    
    
    
    
    public List<Question> getQuestions() {
        return questions;
    }

    private void keep_reserve(Reserve reserve) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
}

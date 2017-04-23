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
                questions.add(qt);
                //questions.add(qt);
                
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

    
    
    
    
    
    
    
}

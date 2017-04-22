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
public class Question {
    
    private int QUESTION_ID;
    private String QUESTION;
    private int FORM_ID;
    private int ANSWER_ID;
    private String ANSWER;

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }
    
    
    
    public Question(int QUESTION_ID, String QUESTION, int FORM_ID, int ANSWER_ID, String ANSWER) {
        this.QUESTION_ID = QUESTION_ID;
        this.QUESTION = QUESTION;
        this.FORM_ID = FORM_ID;
        this.ANSWER_ID = ANSWER_ID;
        this.ANSWER = ANSWER;
    }

    

    public Question() {
    }

    
    
    
    public int getQUESTION_ID() {
        return QUESTION_ID;
    }

    public void setQUESTION_ID(int QUESTION_ID) {
        this.QUESTION_ID = QUESTION_ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public int getFORM_ID() {
        return FORM_ID;
    }

    public void setFORM_ID(int FORM_ID) {
        this.FORM_ID = FORM_ID;
    }

    public int getANSWER_ID() {
        return ANSWER_ID;
    }

    public void setANSWER_ID(int ANSWER_ID) {
        this.ANSWER_ID = ANSWER_ID;
    }
    
    
            
    
}

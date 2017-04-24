/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Sea
 */
public class Real_Question implements Serializable{
    private int Question_id;
    private String Question;
    private int Form_id;
    private String Form_name;

    public Real_Question(int Question_id, String Question, int Form_id, String Form_name) {
        this.Question_id = Question_id;
        this.Question = Question;
        this.Form_id = Form_id;
        this.Form_name = Form_name;
    }

    
    
    public String getForm_name() {
        return Form_name;
    }

    public void setForm_name(String Form_name) {
        this.Form_name = Form_name;
    }

    

    public Real_Question() {
    }

    
    
    public int getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(int Question_id) {
        this.Question_id = Question_id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public int getForm_id() {
        return Form_id;
    }

    public void setForm_id(int Form_id) {
        this.Form_id = Form_id;
    }
    
    
}

package org.krams.tutorial.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by Proggeo on 5/26/2016.
 */

@Entity
@Table(name = "questions")
public class TestQuestion implements Serializable {

    private static final long serialVersionUID = -5527566248002296041L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "RIGHT_ANSWER")
    private String answer;

    @Column(name = "WRONG_ANSWER1")
    private String wrongAnswer1;

    @Column(name = "WRONG_ANSWER2")
    private String wrongAnswer2;

    @Column(name = "WRONG_ANSWER3")
    private String wrongAnswer3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}


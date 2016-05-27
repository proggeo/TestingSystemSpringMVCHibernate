package org.proggeo.testingsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Proggeo on 5/27/2016.
 */
@Entity
@Table(name = "entries")
public class Entry implements Serializable {

    private static final long serialVersionUID = -5527566248002296040L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "questionId")
    private Integer questionId;

    @Column(name = "answer")
    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

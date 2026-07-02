package com.ormlearn.model.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GROUP 4 — Hands-on 3: Quiz HQL Query
 *
 * Represents one answer option for a Question.
 *
 * TABLE: option  (mapped as "option" — care: reserved in some DBs, H2 is fine)
 * +-------+-------------------+----------+---------+
 * | op_id | op_text           | op_correct| op_qu_id|
 * +-------+-------------------+----------+---------+
 * | 1     | A framework       | TRUE     |  1      |
 * | 2     | A database        | FALSE    |  1      |
 * +-------+-------------------+----------+---------+
 *
 * RELATIONSHIP: Many Options → One Question
 */
@Entity
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text", nullable = false, length = 300)
    private String text;

    @Column(name = "op_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "op_qu_id")
    private Question question;

    public Option() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    @Override
    public String toString() {
        return "Option [id=" + id + ", text=" + text + ", correct=" + correct + "]";
    }
}

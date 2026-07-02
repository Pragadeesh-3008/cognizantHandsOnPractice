package com.ormlearn.model.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * GROUP 4 — Hands-on 3: Quiz HQL Query
 *
 * Represents a quiz question.
 *
 * TABLE: question
 * +-------+------------------------------+
 * | qu_id | qu_text                      |
 * +-------+------------------------------+
 * | 1     | What is Spring Boot?         |
 * +-------+------------------------------+
 *
 * RELATIONSHIP: One Question → Many Options
 */
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text", nullable = false, length = 500)
    private String text;

    @OneToMany(mappedBy = "question")
    private List<Option> options = new ArrayList<>();

    public Question() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<Option> getOptions() { return options; }
    public void setOptions(List<Option> options) { this.options = options; }

    @Override
    public String toString() {
        return "Question [id=" + id + ", text=" + text + "]";
    }
}

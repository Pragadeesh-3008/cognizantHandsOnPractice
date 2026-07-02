package com.ormlearn.model.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * GROUP 4 — Hands-on 3: Quiz HQL Query
 *
 * Represents one quiz attempt by a user.
 *
 * TABLE: attempt
 * +-------+----------+---------+
 * | at_id | at_us_id | at_date |
 * +-------+----------+---------+
 * | 1     | 1        |2024-01-10|
 * +-------+----------+---------+
 *
 * RELATIONSHIPS:
 *   Many Attempts → One User
 *   One Attempt → Many AttemptQuestions
 */
@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @Column(name = "at_date")
    private LocalDate date;

    @OneToMany(mappedBy = "attempt")
    private List<AttemptQuestion> attemptQuestions = new ArrayList<>();

    public Attempt() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public List<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(List<AttemptQuestion> aq) { this.attemptQuestions = aq; }

    @Override
    public String toString() {
        return "Attempt [id=" + id + ", user=" + (user != null ? user.getName() : "?")
                + ", date=" + date + "]";
    }
}

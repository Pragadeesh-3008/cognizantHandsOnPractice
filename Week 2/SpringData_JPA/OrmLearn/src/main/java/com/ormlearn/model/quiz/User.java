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
 * GROUP 4 — Hands-on 3: Quiz Attempt Details using HQL
 *
 * Represents a quiz participant.
 *
 * TABLE: users (not "user" — reserved word in SQL)
 * +-------+---------+-------------------+
 * | us_id | us_name | us_email          |
 * +-------+---------+-------------------+
 * | 1     | John    | john@example.com  |
 * +-------+---------+-------------------+
 *
 * RELATIONSHIP: One User → Many Attempts
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_name", nullable = false)
    private String name;

    @Column(name = "us_email", unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Attempt> attempts = new ArrayList<>();

    public User() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Attempt> getAttempts() { return attempts; }
    public void setAttempts(List<Attempt> attempts) { this.attempts = attempts; }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}

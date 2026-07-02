package com.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * GROUP 3 — Hands-on 3 (Entity Design), Hands-on 6 (Many-To-Many)
 *
 * JPA Entity representing a professional Skill.
 *
 * TABLE: skill
 * +-------+---------+
 * | sk_id | sk_name |
 * +-------+---------+
 * | 1     | Java    |
 * | 2     | Spring  |
 * +-------+---------+
 *
 * RELATIONSHIP: Many-to-Many (inverse side)
 * Employee is the owner (has @JoinTable).
 * Skill uses mappedBy="skills" to reference the owning field in Employee.
 *
 * mappedBy means:
 *   "The other side (Employee.skills) is responsible for the join table.
 *    Do NOT create another join table from this side."
 *
 * FETCH STRATEGY:
 * LAZY — employees set is not loaded until accessed.
 * In most cases you don't need all employees when working with a Skill.
 *
 * INTERVIEW Q: Why avoid EAGER on @ManyToMany?
 * A: EAGER on both sides causes Hibernate to execute multiple JOIN queries
 *    (N+1 problem), potentially loading the entire database into memory.
 */
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name", nullable = false, length = 100)
    private String name;

    /**
     * Inverse side of the Many-to-Many relationship.
     * mappedBy="skills" points to the `skills` field in Employee.
     * The actual join table is managed by Employee.
     */
    @ManyToMany(mappedBy = "skills")
    private Set<Employee> employees = new HashSet<>();

    // ---- Constructors ----
    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    // ---- Getters & Setters ----
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Employee> getEmployees() { return employees; }
    public void setEmployees(Set<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}

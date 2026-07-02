package com.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * GROUP 3 — Hands-on 3 (Entity Design), Hands-on 5 (One-To-Many)
 *
 * JPA Entity representing an organisational Department.
 *
 * TABLE: department
 * +-------+-----------------+
 * | de_id | de_name         |
 * +-------+-----------------+
 * | 1     | Engineering     |
 * | 2     | Marketing       |
 * +-------+-----------------+
 *
 * RELATIONSHIP: One Department → Many Employees
 *
 * @OneToMany(mappedBy = "department")
 *   - mappedBy points to the field name in Employee that owns the FK
 *   - This side does NOT own the FK column; Employee does
 *   - Avoids creating a separate join table
 *
 * FETCH TYPE EXPLANATION:
 * FetchType.LAZY (default for @OneToMany):
 *   - employeeList is NOT loaded from DB until accessed
 *   - Accessing it OUTSIDE a transaction throws LazyInitializationException
 *   - Solution: Use @Transactional in service, or JOIN FETCH in HQL
 *
 * FetchType.EAGER:
 *   - employeeList is ALWAYS loaded with Department
 *   - Can cause N+1 query problem (avoid for large collections)
 *
 * INTERVIEW Q: What is LazyInitializationException?
 * A: Thrown when a lazily-loaded proxy is accessed after the Hibernate
 *    session has been closed (outside @Transactional boundary).
 */
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "de_id")
    private int id;

    @Column(name = "de_name", nullable = false, length = 100)
    private String name;

    /**
     * One-to-Many: one department has many employees.
     * mappedBy="department" refers to the `department` field in Employee.
     * fetch=LAZY means employees are NOT loaded until accessed.
     *
     * Changing to EAGER: FetchType.EAGER — loads all employees immediately.
     * Avoid EAGER on large collections to prevent performance issues.
     */
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employeeList = new HashSet<>();

    // ---- Constructors ----
    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    // ---- Getters & Setters ----
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}

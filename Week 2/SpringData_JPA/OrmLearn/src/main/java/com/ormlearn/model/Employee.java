package com.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * GROUP 3 — Hands-on 3, 4, 5, 6 | GROUP 4 — HQL Queries
 *
 * JPA Entity representing an Employee.
 *
 * TABLE: employee
 * +-------+---------+-----------+--------------+--------+----------+
 * | em_id | em_name | em_salary | em_permanent | em_dob | em_de_id |
 * +-------+---------+-----------+--------------+--------+----------+
 *
 * RELATIONSHIPS:
 *   Many-to-One  → Department  (employee owns FK: em_de_id)
 *   Many-to-Many → Skill       (via junction table: employee_skill)
 *
 * ---- @ManyToOne Explanation (Hands-on 4) ----
 * Each employee belongs to ONE department.
 * The FK column (em_de_id) is in the employee table — Employee OWNS this relationship.
 * fetch=EAGER: Department is loaded immediately when Employee is fetched.
 *
 * Generated SQL for getEmployee(1):
 *   SELECT e.*, d.* FROM employee e
 *   LEFT JOIN department d ON e.em_de_id = d.de_id
 *   WHERE e.em_id = 1
 *
 * ---- @ManyToMany Explanation (Hands-on 6) ----
 * An employee can have many skills; a skill can belong to many employees.
 * @JoinTable creates the junction table "employee_skill":
 *   - joinColumns:        FK from employee_skill → employee (es_em_id)
 *   - inverseJoinColumns: FK from employee_skill → skill    (es_sk_id)
 *
 * Junction table: employee_skill
 * +-----------+-----------+
 * | es_em_id  | es_sk_id  |
 * +-----------+-----------+
 * | 1         | 1         |  (Alice → Java)
 * | 1         | 2         |  (Alice → Spring Boot)
 * +-----------+-----------+
 *
 * INTERVIEW Q: Which side should own @ManyToMany?
 * A: The side with @JoinTable is the owner. The other side uses mappedBy.
 *    Choose the entity that is the "primary" in the relationship.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private int id;

    @Column(name = "em_name", nullable = false, length = 100)
    private String name;

    @Column(name = "em_salary")
    private double salary;

    /**
     * Mapped to a boolean column.
     * TRUE = permanent employee, FALSE = contractual
     */
    @Column(name = "em_permanent")
    private boolean permanent;

    /**
     * Date of birth. LocalDate maps to SQL DATE.
     */
    @Column(name = "em_dob")
    private LocalDate dateOfBirth;

    /**
     * Many-To-One: Many employees → One department.
     * @JoinColumn defines the FK column in the employee table.
     * fetch=EAGER: department is loaded whenever employee is loaded.
     *
     * WHY EAGER here?
     * Employee details almost always need the department name.
     * Eagerly loading it avoids a separate query.
     * For OneToMany (collections), LAZY is safer.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "em_de_id")
    private Department department;

    /**
     * Many-To-Many: Employee ↔ Skill via employee_skill table.
     * fetch=LAZY: skills are NOT loaded until accessed.
     *
     * To load skills, use JOIN FETCH in HQL:
     *   "SELECT e FROM Employee e JOIN FETCH e.skills WHERE e.id = :id"
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_skill",
        joinColumns        = @JoinColumn(name = "es_em_id"),
        inverseJoinColumns = @JoinColumn(name = "es_sk_id")
    )
    private Set<Skill> skills = new HashSet<>();

    // ---- Constructors ----
    public Employee() {
    }

    // ---- Getters & Setters ----
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public boolean isPermanent() { return permanent; }
    public void setPermanent(boolean permanent) { this.permanent = permanent; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Set<Skill> getSkills() { return skills; }
    public void setSkills(Set<Skill> skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name
                + ", salary=" + salary + ", permanent=" + permanent
                + ", dob=" + dateOfBirth
                + ", department=" + (department != null ? department.getName() : "None")
                + "]";
    }
}

package application.timesheets.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "timesheets")
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    @Column(precision = 2,scale = 1)
    private BigDecimal hours;
    @Column(precision = 2,scale = 1)
    private BigDecimal overHours;
    @Column(nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigDecimal getOverHours() {
        return overHours;
    }

    public void setOverHours(BigDecimal overHours) {
        this.overHours = overHours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

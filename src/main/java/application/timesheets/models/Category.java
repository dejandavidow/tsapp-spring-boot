package application.timesheets.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "category_name",nullable = false,unique = true)
    private String name;
    public Category(){}
    public Category(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public int getId()
    {
        return  this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}

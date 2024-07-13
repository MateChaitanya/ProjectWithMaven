package com.map1;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Emp {
    
    @Id
    private int eid;
    
    @Column(name = "employee_name")
    private String name;
    
    @ManyToMany
    @JoinTable(
        name = "emp_project",
        joinColumns = @JoinColumn(name = "eid"),
        inverseJoinColumns = @JoinColumn(name = "pid")
    )
    private List<Project> projects;

    // Constructors
    public Emp() {
        super();
    }

    public Emp(int eid, String name, List<Project> projects) {
        super();
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    // Getters and setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

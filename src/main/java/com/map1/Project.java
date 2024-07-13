package com.map1;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
    
    @Id
    private int pid;
    
    @Column(name = "project_name")
    private String projectName;
    
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    // Constructors
    public Project() {
        super();
    }

    public Project(int pid, String projectName, List<Emp> emps) {
        super();
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }

    // Getters and setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}

package com.example.jsf.models;

import java.util.Date;

public class Employee {
    private int id;
    private String name,departement,email;
    private Date brthd;

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    private boolean edit;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public Employee(int id, String name, String departement, String email, Date brthd) {
        this.id = id;
        this.name = name;
        this.departement = departement;
        this.email = email;
        this.brthd = brthd;
    }

    public Employee(int id, String name, String departement, String email, Date brthd, boolean edit) {
        this.id = id;
        this.name = name;
        this.departement = departement;
        this.email = email;
        this.brthd = brthd;
        this.edit = edit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrthd() {
        return brthd;
    }

    public void setBrthd(Date brthd) {
        this.brthd = brthd;
    }

    public Employee(String name, String departement, String email, Date brthd) {
        this.id= -1;
        this.name = name;
        this.departement = departement;
        this.email = email;
        this.brthd = brthd;
    }

    public void aff() {
        System.out.println(name);
    }
}

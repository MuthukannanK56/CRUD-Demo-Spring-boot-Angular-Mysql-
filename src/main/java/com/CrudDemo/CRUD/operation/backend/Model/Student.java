package com.CrudDemo.CRUD.operation.backend.Model;

import jakarta.persistence.*;

@Entity
@Table(name  = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name ="name")
    private String name;

    @Column(name ="mobilenuber")
    private String mobilenumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    public Student() {

    }

    public Student(String name, String mobilenumber, String address, String email) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.address = address;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

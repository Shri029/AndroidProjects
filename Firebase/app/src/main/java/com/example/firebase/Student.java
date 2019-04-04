package com.example.firebase;

public class Student {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String dob;

    public Student(String id, String name, String phone, String email, String dob) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}

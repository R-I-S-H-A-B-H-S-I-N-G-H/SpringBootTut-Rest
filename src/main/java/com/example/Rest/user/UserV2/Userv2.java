package com.example.Rest.user.UserV2;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Userv2 {
    private Integer id;

    @Size(min = 2, max = 200)
    private String fname, lname;
    @Past
    private LocalDate dob;

    public Userv2() {
    }

    public Userv2(Integer id, @Size(min = 2, max = 200) String fname, @Size(min = 2, max = 200) String lname,
            @Past LocalDate dob) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + "]";
    }

}

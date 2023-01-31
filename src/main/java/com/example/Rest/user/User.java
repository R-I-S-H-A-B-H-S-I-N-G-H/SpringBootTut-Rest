package com.example.Rest.user;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Component
public class User {
    private Integer id;

    // @Size(min = 2)
    @NotBlank
    private String name;
    @Past
    private LocalDate dob;

    public User() {
    }

    public User(Integer id, String name, LocalDate dob) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}

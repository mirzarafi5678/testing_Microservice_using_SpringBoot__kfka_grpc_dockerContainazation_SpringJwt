package com.example23.demo.dto;

public class PatientRespondDto {
    private  String  id;
    private String name,dateOfBirth,dateOfRegister,email,address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public void setDateOfRegister(String dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfRegister() {
        return dateOfRegister;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

package com.example23.demo.dto;

import com.example23.demo.dto.Validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class PatienRequestDto {
    @NotBlank(message = "name is required")
    @Size( max = 50, message = "name must be between 3 and 50 characters")
    private String name;
    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    private String email;
    @NotBlank(message = "address is required")
    private String address;
    @NotBlank(message = "date of birth is required")
    private String dateOfBirth;
    @NotBlank(groups= CreatePatientValidationGroup.class, message = "date of register is required")
    private String dateOfRegister;

    public String getName() {
        return name;
    }



    public String getDateOfRegister() {
        return dateOfRegister;
    }



    public String getDateOfBirth() {
        return dateOfBirth;
    }



    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

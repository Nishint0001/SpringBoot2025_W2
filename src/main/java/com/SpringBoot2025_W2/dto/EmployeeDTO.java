package com.SpringBoot2025_W2.dto;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO
{
    private Long id;

    @NotBlank(message = "Enter Valid Name")
    @Size(min = 3,max = 10,message = "Length Should be in the range 3 and 10")
    private String name;

    @Email(message = "Email should be valid email")
    private String email;

    @Max(value = 100,message = "Age Cannot be greater than 100")
    @Min(value=18,message = "Age cannot be less than 18 ")
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    @NotBlank
    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be ADMIN OR USER ONLY...")
    private String role;

    public EmployeeDTO()
    {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getRole()
    {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

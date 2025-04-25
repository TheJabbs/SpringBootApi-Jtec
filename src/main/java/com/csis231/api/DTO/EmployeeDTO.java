package com.csis231.api.DTO;

public class EmployeeDTO {
    private String employeeUsername;
    private String employeePassword;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeUsername, String employeePassword) {
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}

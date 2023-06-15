package com.example.basicandroid.models;

public class EmployeeEntity {
    private String employeeCode;
    private String employeeFullName;
    private String employeeDepartment;

    public EmployeeEntity(String employeeCode,
                          String employeeFullName,
                          String employeeDepartment) {
        this.employeeCode = employeeCode;
        this.employeeFullName = employeeFullName;
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}

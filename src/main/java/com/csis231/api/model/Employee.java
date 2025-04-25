package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Employee implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;
    @Basic
    @Column(name = "restaurant_id", nullable = false, updatable = false, insertable = false)
    private Integer restaurantId;
    @Basic
    @Column(name = "employee_fname", nullable = false, length = 20)
    private String employeeFname;
    @Basic
    @Column(name = "employee_lname", nullable = false, length = 20)
    private String employeeLname;
    @Basic
    @Column(name = "employee_email", nullable = true, length = 30)
    private String employeeEmail;
    @Basic
    @Column(name = "employee_phone", nullable = false)
    private Integer employeePhone;
    @Basic
    @Column(name = "employee_gender", nullable = false)
    private byte[] employeeGender;
    @Basic
    @Column(name = "employee_hsalary", nullable = false, precision = 0)
    private Double employeeHsalary;
    @Basic
    @Column(name = "employee_status", nullable = false, length = 1)
    private String employeeStatus;
    @Basic
    @Column(name = "employee_username", nullable = false, length = 30)
    private String employeeUsername;
    @Basic
    @Column(name = "employee_password", nullable = false, length = 30)
    private String employeePassword;
    @Basic
    @Column(name = "employee_dob", nullable = false)
    private Date employeeDob;
    @Basic
    @Column(name = "employee_fire", nullable = true)
    private Date employeeFire;
    @Basic
    @Column(name = "employee_hire", nullable = true)
    private Date employeeHire;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurantByRestaurantId;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    @JsonIgnore
    private Collection<Labor> laborsByEmployeeId;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    @JsonIgnore
    private Collection<Orders> ordersByEmployeeId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getEmployeeFname() {
        return employeeFname;
    }

    public void setEmployeeFname(String employeeFname) {
        this.employeeFname = employeeFname;
    }

    public String getEmployeeLname() {
        return employeeLname;
    }

    public void setEmployeeLname(String employeeLname) {
        this.employeeLname = employeeLname;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Integer getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Integer employeePhone) {
        this.employeePhone = employeePhone;
    }

    public byte[] getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(byte[] employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Double getEmployeeHsalary() {
        return employeeHsalary;
    }

    public void setEmployeeHsalary(Double employeeHsalary) {
        this.employeeHsalary = employeeHsalary;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
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

    public Date getEmployeeDob() {
        return employeeDob;
    }

    public void setEmployeeDob(Date employeeDob) {
        this.employeeDob = employeeDob;
    }

    public Date getEmployeeFire() {
        return employeeFire;
    }

    public void setEmployeeFire(Date employeeFire) {
        this.employeeFire = employeeFire;
    }

    public Date getEmployeeHire() {
        return employeeHire;
    }

    public void setEmployeeHire(Date employeeHire) {
        this.employeeHire = employeeHire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (restaurantId != null ? !restaurantId.equals(employee.restaurantId) : employee.restaurantId != null)
            return false;
        if (employeeFname != null ? !employeeFname.equals(employee.employeeFname) : employee.employeeFname != null)
            return false;
        if (employeeLname != null ? !employeeLname.equals(employee.employeeLname) : employee.employeeLname != null)
            return false;
        if (employeeEmail != null ? !employeeEmail.equals(employee.employeeEmail) : employee.employeeEmail != null)
            return false;
        if (employeePhone != null ? !employeePhone.equals(employee.employeePhone) : employee.employeePhone != null)
            return false;
        if (!Arrays.equals(employeeGender, employee.employeeGender)) return false;
        if (employeeHsalary != null ? !employeeHsalary.equals(employee.employeeHsalary) : employee.employeeHsalary != null)
            return false;
        if (employeeStatus != null ? !employeeStatus.equals(employee.employeeStatus) : employee.employeeStatus != null)
            return false;
        if (employeeUsername != null ? !employeeUsername.equals(employee.employeeUsername) : employee.employeeUsername != null)
            return false;
        if (employeePassword != null ? !employeePassword.equals(employee.employeePassword) : employee.employeePassword != null)
            return false;
        if (employeeDob != null ? !employeeDob.equals(employee.employeeDob) : employee.employeeDob != null)
            return false;
        if (employeeFire != null ? !employeeFire.equals(employee.employeeFire) : employee.employeeFire != null)
            return false;
        if (employeeHire != null ? !employeeHire.equals(employee.employeeHire) : employee.employeeHire != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (employeeFname != null ? employeeFname.hashCode() : 0);
        result = 31 * result + (employeeLname != null ? employeeLname.hashCode() : 0);
        result = 31 * result + (employeeEmail != null ? employeeEmail.hashCode() : 0);
        result = 31 * result + (employeePhone != null ? employeePhone.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(employeeGender);
        result = 31 * result + (employeeHsalary != null ? employeeHsalary.hashCode() : 0);
        result = 31 * result + (employeeStatus != null ? employeeStatus.hashCode() : 0);
        result = 31 * result + (employeeUsername != null ? employeeUsername.hashCode() : 0);
        result = 31 * result + (employeePassword != null ? employeePassword.hashCode() : 0);
        result = 31 * result + (employeeDob != null ? employeeDob.hashCode() : 0);
        result = 31 * result + (employeeFire != null ? employeeFire.hashCode() : 0);
        result = 31 * result + (employeeHire != null ? employeeHire.hashCode() : 0);
        return result;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Collection<Labor> getLaborsByEmployeeId() {
        return laborsByEmployeeId;
    }

    public void setLaborsByEmployeeId(Collection<Labor> laborsByEmployeeId) {
        this.laborsByEmployeeId = laborsByEmployeeId;
    }

    public Collection<Orders> getOrdersByEmployeeId() {
        return ordersByEmployeeId;
    }

    public void setOrdersByEmployeeId(Collection<Orders> ordersByEmployeeId) {
        this.ordersByEmployeeId = ordersByEmployeeId;
    }

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            clone.setEmployeeId(this.employeeId);
            clone.setRestaurantId(this.restaurantId);
            clone.setEmployeeFname(this.employeeFname);
            clone.setEmployeeLname(this.employeeLname);
            clone.setEmployeeEmail(this.employeeEmail);
            clone.setEmployeePhone(this.employeePhone);
            clone.setEmployeeGender(this.employeeGender);
            clone.setEmployeeHsalary(this.employeeHsalary);
            clone.setEmployeeStatus(this.employeeStatus);
            clone.setEmployeeUsername(this.employeeUsername);
            clone.setEmployeePassword(this.employeePassword);
            clone.setEmployeeDob(this.employeeDob);
            clone.setEmployeeFire(this.employeeFire);
            clone.setEmployeeHire(this.employeeHire);
            clone.setRestaurantByRestaurantId(this.restaurantByRestaurantId);
            clone.setLaborsByEmployeeId(this.laborsByEmployeeId);
            clone.setOrdersByEmployeeId(this.ordersByEmployeeId);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package com.example.demoproject.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class Employee {
    private int id;
    private String registerUser;

    private String fullName;
    private Date registerDate;
    private Date birthDate;
    @Size(min = 5, message = "Enter at least 5 character...")
    private String position;

    public Employee() {
        super();
    }


    public Employee(int id, String user, String fullName,
                    Date registerDate, Date birthDate, String position) {
        this.id = id;
        this.registerUser = user;
        this.fullName = fullName;
        this.registerDate = registerDate;
        this.birthDate = birthDate;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(String registerUser) {
        this.registerUser = registerUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee [id=%s, registerUser=%s, fullName=%s, registerDate=%s, birthDate=%s, position=%s]", id,
                registerUser, fullName, registerDate, birthDate, position);
    }

}

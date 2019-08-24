package com.example.demoproject.service;

import com.example.demoproject.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<Employee>();
    private static int employeeCount = 5;

    static {
        employees.add(new Employee(1, "mahlagha", "Mahlagha Ramezani", new Date(), new Date(), "Java developer"));
        employees.add(new Employee(2, "mahlagha", "David Sampson", new Date(), new Date(), "Analyzer"));
        employees.add(new Employee(3, "mahlagha", "Ali Boush", new Date(), new Date(), "Dentist"));
        employees.add(new Employee(4, "mahlagha", "Taniya Jackson", new Date(), new Date(), "Student"));
        employees.add(new Employee(5, "mahlagha", "Jennifer Aniston", new Date(), new Date(), "Actor"));
    }

    public List<Employee> retrieveEmployees(String user) {
        List<Employee> filteredEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getRegisterUser().equals(user)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public Employee retrieveEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(String registerUser, String fullName, Date registerDate,
                            Date birthDate, String position) {
        employees.add(new Employee(++employeeCount, registerUser, fullName, registerDate, birthDate, position));
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void updateEmployee(Employee employee) {
        employees.remove(employee);
        employees.add(employee);
    }
}

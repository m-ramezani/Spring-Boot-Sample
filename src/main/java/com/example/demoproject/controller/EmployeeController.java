package com.example.demoproject.controller;

import com.example.demoproject.model.Employee;
import com.example.demoproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/employee-list", method = RequestMethod.GET)
    public String showEmployeeList(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("employees", employeeService.retrieveEmployees(name));
        return "employee-list";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.GET)
    public String showAddEmployeePage(ModelMap model) {
        model.addAttribute("employee", new Employee(0, getLoggedInUserName(model),
                "", new Date(), new Date(), ""));
        return "employee";
    }

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public String addEmployee(ModelMap model, @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee";
        }
        employeeService.addEmployee(getLoggedInUserName(model), employee.getFullName(), employee.getRegisterDate(),
                employee.getBirthDate(), employee.getPosition());
        return "redirect:/employee-list";
    }

    @RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee-list";
    }

    @RequestMapping(value = "/update-employee", method = RequestMethod.GET)
    public String showUpdateEmployee(ModelMap model, @RequestParam int id) {
        Employee employee = employeeService.retrieveEmployee(id);
        model.put("employee", employee);
        return "employee";
    }

    @RequestMapping(value = "/update-employee", method = RequestMethod.POST)
    public String updateEmployee(ModelMap model, @Valid Employee employee, BindingResult bindingResult) {

        employee.setRegisterUser(getLoggedInUserName(model));
        if (bindingResult.hasErrors()) {
            return "employee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employee-list";
    }

}

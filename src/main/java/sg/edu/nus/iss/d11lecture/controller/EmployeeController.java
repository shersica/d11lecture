package sg.edu.nus.iss.d11lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.d11lecture.model.Employee;

@RestController        //return object/data must use RestController. Use Controller for string html
@RequestMapping("/employees")
public class EmployeeController {
    
    @GetMapping(path = "/list")
    // @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ash", "Chew", "ashchew@gmail.com"));
        employees.add(new Employee("Alicia", "Ong", "aliciaong@gmail.com"));
        employees.add(new Employee("Aaron", "Chia", "aaronchia@gmail.com"));
        
        return employees;
    }
}

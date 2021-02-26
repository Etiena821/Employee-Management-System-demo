package com.myemployeee.controllers;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import com.myemployeee.service.AttendanceService;
import com.myemployeee.service.EmployeeService;
import com.myemployeee.service.impl.EmployeeServiceImplJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private AttendanceService attendanceService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService, AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/")
    public String viewAllEmployees(Model model) {
        model.addAttribute("listOfEmployee", employeeService.getListOfEmployees());
        return "index";
    }

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee, HttpSession session) {
       Employee savedEmployee = employeeService.addEmployee(employee);
       session.setAttribute("employee", savedEmployee);
        return "redirect:/employees/view-employee/" + savedEmployee.getId();
    }

    @GetMapping("/view-employee/{id}")
    public String viewEmployee(@PathVariable Long id, Model model, @SessionAttribute Employee employee) {

        model.addAttribute("employee", employee);
        model.addAttribute("employeeAttendance", attendanceService.getAttendanceByEmployee(employee));
        return "view-employee";
    }


    @GetMapping("/edit-employee/{id}")
    public String showEditEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

//    //delete Employee
//    @PostMapping("/delete-employee/{id}")
//    public String deleteEmployee(@PathVariable("id") long id, HttpSession session) {
//        Object userObj = session.getAttribute("user");
//        if (userObj == null) return "redirect:/auth/login";
//
//        Post post = postService.getPostById(id);
//        postService.deletePost(post);
//        return "redirect:/profile";
//    }


}

package com.myemployeee.controllers;

import com.myemployeee.model.Employee;
import com.myemployeee.model.User;
import com.myemployeee.service.EmployeeService;
import com.myemployeee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    private UserService userService;
    private EmployeeService employeeService;

    @Autowired
    public IndexController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping({"/employees"})
    public String index(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");

        if(user != null && userService.verifyLogin(user)) {
            model.addAttribute("employees", employeeService.getListOfEmployees());
            return "index";
        }

        return "redirect:/";
    }
}

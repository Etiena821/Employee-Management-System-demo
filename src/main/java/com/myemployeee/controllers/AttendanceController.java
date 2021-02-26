package com.myemployeee.controllers;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import com.myemployeee.service.AttendanceService;
import com.myemployeee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/employees")
public class AttendanceController {
    private AttendanceService attendanceService;
    private EmployeeService employeeService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService, EmployeeService employeeService) {
        this.attendanceService = attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping("/attendance")
    public String attendanceForm(Model model){
      model.addAttribute("attendance", new Attendance());
      return "attendance";
    }

    @PostMapping("/attendance")
    public String addAttendance(@ModelAttribute Attendance attendance, @SessionAttribute Employee employee){
        Attendance employeeAttendance = attendanceService.addEmployeeAttendance(attendance, employee );
        return "redirect:/employees/view-employee/" + employee.getId();
    }
}

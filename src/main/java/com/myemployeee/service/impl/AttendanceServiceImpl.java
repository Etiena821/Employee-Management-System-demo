package com.myemployeee.service.impl;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import com.myemployeee.repository.AttendanceRepository;
import com.myemployeee.service.AttendanceService;
import com.myemployeee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;
    private EmployeeService employeeService;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeService employeeService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
    }

    @Override
    public Attendance addEmployeeAttendance(Attendance attendance, Employee employee) {
            attendance.setEmployee(employee);
            return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findAttendanceByEmployee(employee);
    }
}

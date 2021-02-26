package com.myemployeee.service.impl;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import com.myemployeee.repository.AttendanceRepository;
import com.myemployeee.repository.EmployeeRepository;
import com.myemployeee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpa")
public class EmployeeServiceImplJPA implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private AttendanceRepository attendanceRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository, AttendanceRepository attendanceRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getListOfEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void addAttendance(Employee employee, List<Attendance> attendances) {

        Attendance wk1 = new Attendance();
        wk1.setMonday("absent");
        wk1.setTuesday("absent");
        wk1.setWednesday("present");
        wk1.setThursday("present");
        wk1.setFriday("absent");
        wk1.setEmployee(employee);
        attendanceRepository.save(wk1);

        Attendance wk2 = new Attendance();
        wk2.setMonday("present");
        wk2.setTuesday("absent");
        wk2.setWednesday("present");
        wk2.setThursday("present");
        wk2.setFriday("absent");
        wk2.setEmployee(employee);
        attendanceRepository.save(wk2);
    }

    @Override
    public List<Attendance> addEmployeeAttendance(Attendance attendance, Employee employee) {

        Set<Attendance> attendanceSet = employee.getAttendance();
        attendanceSet.add(attendance);
        employee.setAttendance(attendanceSet);
        employeeRepository.save(employee);
        return new ArrayList<>(employee.getAttendance());
    }
}

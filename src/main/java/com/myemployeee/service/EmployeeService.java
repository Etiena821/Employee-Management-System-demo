package com.myemployeee.service;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getListOfEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Employee employee);
    void addAttendance(Employee employee, List<Attendance> attendances);
    public List<Attendance> addEmployeeAttendance(Attendance attendance, Employee employee);
}

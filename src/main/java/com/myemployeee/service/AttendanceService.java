package com.myemployeee.service;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;

import java.util.List;

public interface AttendanceService {
   Attendance addEmployeeAttendance(Attendance attendance, Employee employee);
   List<Attendance> getAttendanceByEmployee(Employee employee);
}

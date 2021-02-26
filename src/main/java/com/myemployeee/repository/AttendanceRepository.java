package com.myemployeee.repository;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByIdAndEmployee(Long attendanceId, Employee employee);
    List<Attendance> findAttendanceByEmployee(Employee employee);
}

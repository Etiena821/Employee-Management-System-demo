package com.myemployeee.repository;

import com.myemployeee.model.Attendance;
import com.myemployeee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository< Employee, Long> {
    //List<Attendance> findAllByAttendanceE
}

package com.myemployeee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String weekNumber;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}

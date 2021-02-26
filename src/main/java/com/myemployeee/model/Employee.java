package com.myemployeee.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = ("first_names"))
    private String firstName;

    @NotBlank
    @Column(name = ("last_names"))
    private String lastName;

    @Column(name =("email"), unique = true)
    @NotBlank
    private String email;

    @Column(name=("phone_number"), unique = true)
    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Attendance> attendance = new HashSet<>();

}

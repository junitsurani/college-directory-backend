package com.college.directory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty_profiles")
public class FacultyProfile {
    @Id
    private Long userId;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private String officeHours;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}

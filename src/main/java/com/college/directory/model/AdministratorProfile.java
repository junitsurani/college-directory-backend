package com.college.directory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrator_profiles")
public class AdministratorProfile {
    @Id
    private Long userId;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}

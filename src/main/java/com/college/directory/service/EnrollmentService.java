package com.college.directory.service;

import com.college.directory.model.Enrollment;
import com.college.directory.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment getEnrollment(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public List<Enrollment> searchEnrollments(Long studentId, Long courseId) {
        // Implement search logic here
        return null;
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Enrollment existingEnrollment = getEnrollment(id);
        existingEnrollment.setCourse(enrollment.getCourse());
        existingEnrollment.setStudent(enrollment.getStudent());
        return enrollmentRepository.save(existingEnrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}

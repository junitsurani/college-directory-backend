package com.college.directory.controller;

import com.college.directory.model.Enrollment;
import com.college.directory.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return enrollmentService.getEnrollment(id);
    }

    @GetMapping("/search")
    public List<Enrollment> searchEnrollments(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.searchEnrollments(studentId, courseId);
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}

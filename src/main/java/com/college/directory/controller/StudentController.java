package com.college.directory.controller;

import com.college.directory.model.StudentProfile;
import com.college.directory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentProfile getStudentProfile(@PathVariable Long id) {
        return studentService.getStudentProfile(id);
    }

    @GetMapping("/search")
    public List<StudentProfile> searchStudents(@RequestParam String name, @RequestParam String department, @RequestParam String year) {
        return studentService.searchStudents(name, department, year);
    }

    @PostMapping
    public StudentProfile createStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentService.saveStudentProfile(studentProfile);
    }

    @PutMapping("/{id}")
    public StudentProfile updateStudentProfile(@PathVariable Long id, @RequestBody StudentProfile studentProfile) {
        return studentService.updateStudentProfile(id, studentProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentProfile(@PathVariable Long id) {
        studentService.deleteStudentProfile(id);
    }
}

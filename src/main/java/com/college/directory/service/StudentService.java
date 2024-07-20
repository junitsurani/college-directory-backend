package com.college.directory.service;

import com.college.directory.model.StudentProfile;
import com.college.directory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfile getStudentProfile(Long id) {
        return studentProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<StudentProfile> searchStudents(String name, String department, String year) {
        // Implement search logic here
        return null;
    }

    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public StudentProfile updateStudentProfile(Long id, StudentProfile studentProfile) {
        StudentProfile existingProfile = getStudentProfile(id);
        existingProfile.setPhoto(studentProfile.getPhoto());
        existingProfile.setDepartment(studentProfile.getDepartment());
        existingProfile.setYear(studentProfile.getYear());
        return studentProfileRepository.save(existingProfile);
    }

    public void deleteStudentProfile(Long id) {
        studentProfileRepository.deleteById(id);
    }
}

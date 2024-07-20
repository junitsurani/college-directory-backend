package com.college.directory.service;

import com.college.directory.model.FacultyProfile;
import com.college.directory.repository.FacultyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    public FacultyProfile getFacultyProfile(Long id) {
        return facultyProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public List<FacultyProfile> searchFaculties(String name, String department) {
        // Implement search logic here
        return null;
    }

    public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public FacultyProfile updateFacultyProfile(Long id, FacultyProfile facultyProfile) {
        FacultyProfile existingProfile = getFacultyProfile(id);
        existingProfile.setPhoto(facultyProfile.getPhoto());
        existingProfile.setDepartment(facultyProfile.getDepartment());
        existingProfile.setOfficeHours(facultyProfile.getOfficeHours());
        return facultyProfileRepository.save(existingProfile);
    }

    public void deleteFacultyProfile(Long id) {
        facultyProfileRepository.deleteById(id);
    }
}

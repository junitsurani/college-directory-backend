package com.college.directory.controller;

import com.college.directory.model.FacultyProfile;
import com.college.directory.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/{id}")
    public FacultyProfile getFacultyProfile(@PathVariable Long id) {
        return facultyService.getFacultyProfile(id);
    }

    @GetMapping("/search")
    public List<FacultyProfile> searchFaculties(@RequestParam String name, @RequestParam String department) {
        return facultyService.searchFaculties(name, department);
    }

    @PostMapping
    public FacultyProfile createFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        return facultyService.saveFacultyProfile(facultyProfile);
    }

    @PutMapping("/{id}")
    public FacultyProfile updateFacultyProfile(@PathVariable Long id, @RequestBody FacultyProfile facultyProfile) {
        return facultyService.updateFacultyProfile(id, facultyProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteFacultyProfile(@PathVariable Long id) {
        facultyService.deleteFacultyProfile(id);
    }
}

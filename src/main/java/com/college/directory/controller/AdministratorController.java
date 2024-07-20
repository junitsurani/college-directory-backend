package com.college.directory.controller;

import com.college.directory.model.AdministratorProfile;
import com.college.directory.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/{id}")
    public AdministratorProfile getAdministratorProfile(@PathVariable Long id) {
        return administratorService.getAdministratorProfile(id);
    }

    @GetMapping("/search")
    public List<AdministratorProfile> searchAdministrators(@RequestParam String name, @RequestParam String department) {
        return administratorService.searchAdministrators(name, department);
    }

    @PostMapping
    public AdministratorProfile createAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
        return administratorService.saveAdministratorProfile(administratorProfile);
    }

    @PutMapping("/{id}")
    public AdministratorProfile updateAdministratorProfile(@PathVariable Long id, @RequestBody AdministratorProfile administratorProfile) {
        return administratorService.updateAdministratorProfile(id, administratorProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministratorProfile(@PathVariable Long id) {
        administratorService.deleteAdministratorProfile(id);
    }
}

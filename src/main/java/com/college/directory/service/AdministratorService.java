package com.college.directory.service;

import com.college.directory.model.AdministratorProfile;
import com.college.directory.repository.AdministratorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorProfileRepository administratorProfileRepository;

    public AdministratorProfile getAdministratorProfile(Long id) {
        return administratorProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Administrator not found"));
    }

    public List<AdministratorProfile> searchAdministrators(String name, String department) {
        // Implement search logic here
        return null;
    }

    public AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorProfile) {
        return administratorProfileRepository.save(administratorProfile);
    }

    public AdministratorProfile updateAdministratorProfile(Long id, AdministratorProfile administratorProfile) {
        AdministratorProfile existingProfile = getAdministratorProfile(id);
        existingProfile.setPhoto(administratorProfile.getPhoto());
        existingProfile.setDepartment(administratorProfile.getDepartment());
        return administratorProfileRepository.save(existingProfile);
    }

    public void deleteAdministratorProfile(Long id) {
        administratorProfileRepository.deleteById(id);
    }
}

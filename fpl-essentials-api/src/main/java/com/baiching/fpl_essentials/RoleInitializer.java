package com.baiching.fpl_essentials;

import com.baiching.fpl_essentials.model.ERole;
import com.baiching.fpl_essentials.model.Role;
import com.baiching.fpl_essentials.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class RoleInitializer {
    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initializeRoles() {
        for (ERole role : ERole.values()) {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(role));
            }
        }
    }
}

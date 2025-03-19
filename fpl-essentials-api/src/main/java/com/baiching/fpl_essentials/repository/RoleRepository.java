package com.baiching.fpl_essentials.repository;

import com.baiching.fpl_essentials.model.ERole;
import com.baiching.fpl_essentials.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    Boolean existsByName(ERole name);
}

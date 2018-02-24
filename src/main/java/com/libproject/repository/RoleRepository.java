package com.libproject.repository;

import com.libproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Artur on 23.02.2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

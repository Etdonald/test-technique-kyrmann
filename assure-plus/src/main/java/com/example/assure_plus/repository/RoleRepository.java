package com.example.assure_plus.repository;

import com.example.assure_plus.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface  RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByNom(String nom);
}

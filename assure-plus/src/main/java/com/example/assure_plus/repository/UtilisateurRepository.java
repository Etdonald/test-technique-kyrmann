package com.example.assure_plus.repository;

import com.example.assure_plus.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {

    List<Utilisateur> findByRole_RoleId(UUID roleId);
}

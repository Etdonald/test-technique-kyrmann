package com.example.assure_plus.repository;

import com.example.assure_plus.entity.Permission;
import com.example.assure_plus.entity.UtilisateurPermission;
import com.example.assure_plus.model.UtilisateurPermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UtilisateurPermissionRepository extends JpaRepository<UtilisateurPermission, UtilisateurPermissionId> {

//    List<UtilisateurPermission> findByUtilisateur_UtilisateurId(UUID utilisateurId);

}

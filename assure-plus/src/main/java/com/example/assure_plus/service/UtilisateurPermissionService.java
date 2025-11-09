package com.example.assure_plus.service;

import com.example.assure_plus.dto.UtilisateurPermissionsDTO;
import com.example.assure_plus.entity.Permission;
import com.example.assure_plus.entity.Utilisateur;
import com.example.assure_plus.entity.UtilisateurPermission;
import com.example.assure_plus.model.UtilisateurPermissionId;
import com.example.assure_plus.repository.PermissionRepository;
import com.example.assure_plus.repository.UtilisateurPermissionRepository;
import com.example.assure_plus.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UtilisateurPermissionService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UtilisateurPermissionRepository utilisateurPermissionRepository;

    public void associerPermissions(UtilisateurPermissionsDTO dto) {
        Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        for (UUID permissionId : dto.getPermissionIds()) {
            Permission permission = permissionRepository.findById(permissionId)
                    .orElseThrow(() -> new RuntimeException("Permission introuvable : " + permissionId));

            // Créer la relation
            UtilisateurPermission up = new UtilisateurPermission();
            up.setUtilisateur(utilisateur);
            up.setPermission(permission);
            up.setId(new UtilisateurPermissionId(utilisateur.getUtilisateurId(), permission.getPermissionId()));

            utilisateurPermissionRepository.save(up);
        }
    }
}


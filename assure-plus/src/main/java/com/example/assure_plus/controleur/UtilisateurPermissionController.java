package com.example.assure_plus.controleur;

import com.example.assure_plus.dto.UtilisateurPermissionsDTO;
import com.example.assure_plus.service.UtilisateurPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurPermissionController {

    @Autowired
    private UtilisateurPermissionService utilisateurPermissionService;

    @PostMapping("/associer-permissions")
    public ResponseEntity<String> associerPermissions(@RequestBody UtilisateurPermissionsDTO dto) {
        utilisateurPermissionService.associerPermissions(dto);
        return ResponseEntity.ok("Permissions associées avec succès !");
    }
}

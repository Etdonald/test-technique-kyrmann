package com.example.assure_plus.controleur;

import com.example.assure_plus.dto.PermissionDTO;
import com.example.assure_plus.dto.RoleDTO;
import com.example.assure_plus.repository.PermissionRepository;
import com.example.assure_plus.repository.RoleRepository;
import com.example.assure_plus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/creer")
    public ResponseEntity<RoleDTO> creerRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.creerRole(roleDTO));
    }

    @GetMapping("/{roleId}/permissions")
    public ResponseEntity<Set<PermissionDTO>> getPermissionsParRole(@PathVariable UUID roleId) {
        return ResponseEntity.ok(roleService.getRoleAvecPermissions(roleId));
    }
}

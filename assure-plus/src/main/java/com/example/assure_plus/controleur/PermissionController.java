package com.example.assure_plus.controleur;

import com.example.assure_plus.dto.PermissionDTO;
import com.example.assure_plus.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @PostMapping("/creer")
    public ResponseEntity<PermissionDTO> creerPermission(@RequestBody PermissionDTO dto) {
        PermissionDTO created = permissionService.creerPermission(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> getPermissionParId(@PathVariable UUID id) {
        PermissionDTO dto = permissionService.getPermissionParId(id);
        return ResponseEntity.ok(dto);
    }
}

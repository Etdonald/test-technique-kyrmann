package com.example.assure_plus.controleur;

import com.example.assure_plus.dto.UtilisateurDTO;
import com.example.assure_plus.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/creer")
    public ResponseEntity<UtilisateurDTO> creerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        UtilisateurDTO created = utilisateurService.creerUtilisateur(utilisateurDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/lister")
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateur() {
        return ResponseEntity.ok(utilisateurService.getUtilisateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurParId(@PathVariable UUID id) {
        return ResponseEntity.ok(utilisateurService.getUtilisateurParId(id));
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<UtilisateurDTO>> getUtilisateurParRole(@PathVariable UUID roleId) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursParRole(roleId));
    }
}

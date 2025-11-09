package com.example.assure_plus.service;

import com.example.assure_plus.dto.UtilisateurDTO;
import com.example.assure_plus.entity.Permission;
import com.example.assure_plus.entity.Utilisateur;
import com.example.assure_plus.entity.UtilisateurPermission;
import com.example.assure_plus.mapper.PermissionMapper;
import com.example.assure_plus.mapper.RoleMapper;
import com.example.assure_plus.mapper.UtilisateurMapper;
import com.example.assure_plus.repository.PermissionRepository;
import com.example.assure_plus.repository.RoleRepository;
import com.example.assure_plus.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurDTO creerUtilisateur(UtilisateurDTO dto) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(dto);

        utilisateur.setRole(roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role introuvable")));

        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }

    public List<UtilisateurDTO>getUtilisateurs() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }


    public List<UtilisateurDTO> getUtilisateursParRole(UUID roleId) {
        return utilisateurRepository.findByRole_RoleId(roleId)
                .stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDTO getUtilisateurParId(UUID id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        UtilisateurDTO dto = utilisateurMapper.toDto(utilisateur);

        Set<UUID> permissionIds = utilisateur.getUtilisateurPermissions()
                .stream()
                .map(up -> up.getPermission().getPermissionId())
                .collect(Collectors.toSet());

        dto.setPermissionIds(permissionIds);

        return dto;
    }


}

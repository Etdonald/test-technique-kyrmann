package com.example.assure_plus.service;

import com.example.assure_plus.dto.PermissionDTO;
import com.example.assure_plus.dto.RoleDTO;
import com.example.assure_plus.entity.Permission;
import com.example.assure_plus.entity.Role;
import com.example.assure_plus.entity.Utilisateur;
import com.example.assure_plus.entity.UtilisateurPermission;
import com.example.assure_plus.mapper.PermissionMapper;
import com.example.assure_plus.mapper.RoleMapper;
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
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public RoleDTO creerRole(RoleDTO dto) {
        Role role = roleMapper.toEntity(dto);
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }



    public Set<PermissionDTO> getRoleAvecPermissions(UUID roleId) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findByRole_RoleId(roleId);

        Set<Permission> permissions = utilisateurs.stream()
                .flatMap(u -> u.getUtilisateurPermissions().stream())
                .map(UtilisateurPermission::getPermission)
                .collect(Collectors.toSet());

        return permissions.stream()
                .map(permissionMapper::toDto)
                .collect(Collectors.toSet());
    }

}

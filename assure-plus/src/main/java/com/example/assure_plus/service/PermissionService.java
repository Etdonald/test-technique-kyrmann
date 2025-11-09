package com.example.assure_plus.service;

import com.example.assure_plus.dto.PermissionDTO;
import com.example.assure_plus.entity.Permission;
import com.example.assure_plus.mapper.PermissionMapper;
import com.example.assure_plus.repository.PermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionMapper permissionMapper;

    public PermissionDTO creerPermission(PermissionDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);

        if (dto.getParentId() != null) {
            Permission parent = permissionRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent permission introuvable"));
            permission.setParent(parent);
        }

        permission = permissionRepository.save(permission);
        return permissionMapper.toDto(permission);
    }

    public List<PermissionDTO> getToutesPermissions() {
        return permissionRepository.findAll()
                .stream()
                .map(permissionMapper::toDto)
                .collect(Collectors.toList());
    }


    public PermissionDTO getPermissionParId(UUID id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission introuvable"));
        return permissionMapper.toDto(permission);
    }

}

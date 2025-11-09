package com.example.assure_plus.mapper;

import com.example.assure_plus.dto.UtilisateurDTO;
import com.example.assure_plus.entity.Utilisateur;
import com.example.assure_plus.entity.UtilisateurPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(source = "role.roleId", target = "roleId")
    @Mapping(source = "utilisateurPermissions", target = "permissionIds")
    UtilisateurDTO toDto(Utilisateur utilisateur);

    @Mapping(source = "roleId", target = "role.roleId")
    @Mapping(target = "utilisateurPermissions", ignore = true)
    Utilisateur toEntity(UtilisateurDTO dto);

    default Set<java.util.UUID> mapPermissionsToIds(Set<UtilisateurPermission> permissions) {
        if (permissions == null) return null;
        return permissions.stream()
                .map(up -> up.getPermission().getPermissionId())
                .collect(Collectors.toSet());
    }
}

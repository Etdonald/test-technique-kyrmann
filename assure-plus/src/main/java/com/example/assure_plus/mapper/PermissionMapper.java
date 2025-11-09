package com.example.assure_plus.mapper;

import com.example.assure_plus.dto.PermissionDTO;
import com.example.assure_plus.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "parent.permissionId", target = "parentId")
    PermissionDTO toDto(Permission permission);

    @Mapping(target = "parent", ignore = true)
    Permission toEntity(PermissionDTO dto);
}

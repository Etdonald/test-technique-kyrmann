package com.example.assure_plus.mapper;


import com.example.assure_plus.dto.RoleDTO;
import com.example.assure_plus.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toDto(Role role);

    Role toEntity(RoleDTO dto);
}

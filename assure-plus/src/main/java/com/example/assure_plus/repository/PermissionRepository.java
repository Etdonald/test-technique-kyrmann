package com.example.assure_plus.repository;

import com.example.assure_plus.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface  PermissionRepository extends JpaRepository<Permission, UUID> {
    Optional<Permission> findByCode(String code);

//    //permissions ayant un parent donné
//    List<Permission> findByParent_PermissionId(UUID parentId);

}

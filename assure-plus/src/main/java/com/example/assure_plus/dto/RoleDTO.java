package com.example.assure_plus.dto;

import java.util.UUID;

public class RoleDTO {

    private UUID roleId;
    private String nom;
    private String description;

    public RoleDTO(UUID roleId, String nom, String description) {
        this.roleId = roleId;
        this.nom = nom;
        this.description = description;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

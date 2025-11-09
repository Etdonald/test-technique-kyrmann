package com.example.assure_plus.dto;

import java.util.UUID;

public class PermissionDTO {

    private UUID permissionId;
    private String code;
    private String description;
    private UUID parentId;

    public PermissionDTO(UUID permissionId, String code, String description, UUID parentId) {
        this.permissionId = permissionId;
        this.code = code;
        this.description = description;
        this.parentId = parentId;
    }

    public UUID getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

}

package com.example.assure_plus.dto;

import java.util.List;
import java.util.UUID;

public class UtilisateurPermissionsDTO {
    private UUID utilisateurId;
    private List<UUID> permissionIds;

    public UtilisateurPermissionsDTO(UUID utilisateurId, List<UUID> permissionIds) {
        this.utilisateurId = utilisateurId;
        this.permissionIds = permissionIds;
    }

    public UUID getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(UUID utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public List<UUID> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<UUID> permissionIds) {
        this.permissionIds = permissionIds;
    }
}

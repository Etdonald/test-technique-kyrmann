package com.example.assure_plus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UtilisateurPermissionId implements Serializable {

    @Column(name = "utilisateur_id", columnDefinition = "uuid")
    private UUID utilisateurId;

    @Column(name = "permission_id", columnDefinition = "uuid")
    private UUID permissionId;
    

    public UtilisateurPermissionId() {
        
    }

    public UtilisateurPermissionId(UUID utilisateurId, UUID permissionId) {
    }

    public UUID getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(UUID utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public UUID getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }
}
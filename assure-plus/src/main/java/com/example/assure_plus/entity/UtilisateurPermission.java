package com.example.assure_plus.entity;


import com.example.assure_plus.model.AuditableEntity;
import com.example.assure_plus.model.UtilisateurPermissionId;
import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurpermission")
public class UtilisateurPermission extends AuditableEntity {

    @EmbeddedId
    private UtilisateurPermissionId id;

    @MapsId("utilisateurId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @MapsId("permissionId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

    public UtilisateurPermission() {
    }

    public UtilisateurPermission(UtilisateurPermissionId id, Utilisateur utilisateur, Permission permission) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.permission = permission;
    }

    public UtilisateurPermissionId getId() {
        return id;
    }

    public void setId(UtilisateurPermissionId id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
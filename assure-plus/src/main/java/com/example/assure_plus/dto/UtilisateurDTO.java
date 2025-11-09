package com.example.assure_plus.dto;

import com.example.assure_plus.model.LanguePreferee;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class UtilisateurDTO {

    private UUID utilisateurId;
    private String identifiant;
    private boolean estVerifie;
    private String email;
    private String password;
    private String telephone;
    private LanguePreferee languePreferee;
    private Instant dateDerniereConnexion;
    private String origineConnexion;
    private String lastLoginIp;
    private String canalParDefaut;
    private UUID roleId;
    private Set<UUID> permissionIds;


    public UtilisateurDTO(UUID utilisateurId, String identifiant, boolean estVerifie, String email,String password, String telephone, LanguePreferee languePreferee, Instant dateDerniereConnexion, String origineConnexion, String lastLoginIp, String canalParDefaut, UUID roleId, Set<UUID> permissionIds) {
        this.utilisateurId = utilisateurId;
        this.identifiant = identifiant;
        this.estVerifie = estVerifie;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.languePreferee = languePreferee;
        this.dateDerniereConnexion = dateDerniereConnexion;
        this.origineConnexion = origineConnexion;
        this.lastLoginIp = lastLoginIp;
        this.canalParDefaut = canalParDefaut;
        this.roleId = roleId;
        this.permissionIds = permissionIds;
    }

    public UUID getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(UUID utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public boolean isEstVerifie() {
        return estVerifie;
    }

    public void setEstVerifie(boolean estVerifie) {
        this.estVerifie = estVerifie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LanguePreferee getLanguePreferee() {
        return languePreferee;
    }

    public void setLanguePreferee(LanguePreferee languePreferee) {
        this.languePreferee = languePreferee;
    }

    public Instant getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public void setDateDerniereConnexion(Instant dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public String getOrigineConnexion() {
        return origineConnexion;
    }

    public void setOrigineConnexion(String origineConnexion) {
        this.origineConnexion = origineConnexion;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getCanalParDefaut() {
        return canalParDefaut;
    }

    public void setCanalParDefaut(String canalParDefaut) {
        this.canalParDefaut = canalParDefaut;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public Set<UUID> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<UUID> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

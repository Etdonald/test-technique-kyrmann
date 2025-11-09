package com.example.assure_plus.entity;

import com.example.assure_plus.model.AuditableEntity;
import com.example.assure_plus.model.LanguePreferee;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "utilisateur_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID utilisateurId;

    @Column(name = "identifiant", nullable = false, unique = true)
    private String identifiant;

    @Column(name = "est_verifie", nullable = false)
    private boolean estVerifie;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password = "motdepasseParDefaut";

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(name = "langue_preferee")
    private LanguePreferee languePreferee;

    @Column(name = "date_derniere_connexion")
    private Instant dateDerniereConnexion;

    @Column(name = "origine_connexion")
    private String origineConnexion;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "canal_par_defaut")
    private String canalParDefaut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UtilisateurPermission> utilisateurPermissions;

    public Utilisateur() {}

    public Utilisateur(UUID utilisateurId, String identifiant, boolean estVerifie, String email,String password, String telephone, LanguePreferee languePreferee, Instant dateDerniereConnexion, String origineConnexion, String lastLoginIp, String canalParDefaut, Role role, Set<UtilisateurPermission> utilisateurPermissions) {
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
        this.role = role;
        this.utilisateurPermissions = utilisateurPermissions;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<UtilisateurPermission> getUtilisateurPermissions() {
        return utilisateurPermissions;
    }

    public void setUtilisateurPermissions(Set<UtilisateurPermission> utilisateurPermissions) {
        this.utilisateurPermissions = utilisateurPermissions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

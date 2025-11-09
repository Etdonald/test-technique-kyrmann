CREATE TABLE public.permission
(
    permission_id UUID                        NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_by    VARCHAR(255),
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_by    VARCHAR(255),
    deleted       BOOLEAN                     NOT NULL,
    deleted_at    TIMESTAMP WITHOUT TIME ZONE,
    deleted_by    VARCHAR(255),
    actif         BOOLEAN                     NOT NULL,
    activate_at   TIMESTAMP WITHOUT TIME ZONE,
    activate_by   VARCHAR(255),
    code          VARCHAR(64)                 NOT NULL,
    description   VARCHAR(256),
    parent_id     UUID,
    CONSTRAINT pk_permission PRIMARY KEY (permission_id)
);

CREATE TABLE public.role
(
    role_id     UUID                        NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_by  VARCHAR(255),
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_by  VARCHAR(255),
    deleted     BOOLEAN                     NOT NULL,
    deleted_at  TIMESTAMP WITHOUT TIME ZONE,
    deleted_by  VARCHAR(255),
    actif       BOOLEAN                     NOT NULL,
    activate_at TIMESTAMP WITHOUT TIME ZONE,
    activate_by VARCHAR(255),
    nom         VARCHAR(64)                 NOT NULL,
    description VARCHAR(256),
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE public.utilisateur
(
    utilisateur_id          UUID                        NOT NULL,
    created_at              TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_by              VARCHAR(255),
    updated_at              TIMESTAMP WITHOUT TIME ZONE,
    updated_by              VARCHAR(255),
    deleted                 BOOLEAN                     NOT NULL,
    deleted_at              TIMESTAMP WITHOUT TIME ZONE,
    deleted_by              VARCHAR(255),
    actif                   BOOLEAN                     NOT NULL,
    activate_at             TIMESTAMP WITHOUT TIME ZONE,
    activate_by             VARCHAR(255),
    identifiant             VARCHAR(64)                 NOT NULL,
    est_verifie             BOOLEAN                     NOT NULL,
    email                   VARCHAR(256),
    telephone               VARCHAR(64),
    langue_preferee         VARCHAR(10),
    date_derniere_connexion TIMESTAMP WITHOUT TIME ZONE,
    origine_connexion       VARCHAR(255),
    last_login_ip           VARCHAR(255),
    canal_par_defaut        VARCHAR(255),
    role_id                 UUID                        NOT NULL,
    CONSTRAINT pk_utilisateur PRIMARY KEY (utilisateur_id)
);

CREATE TABLE public.utilisateurpermission
(
    created_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_by     VARCHAR(255),
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    updated_by     VARCHAR(255),
    deleted        BOOLEAN                     NOT NULL,
    deleted_at     TIMESTAMP WITHOUT TIME ZONE,
    deleted_by     VARCHAR(255),
    actif          BOOLEAN                     NOT NULL,
    activate_at    TIMESTAMP WITHOUT TIME ZONE,
    activate_by    VARCHAR(255),
    utilisateur_id UUID                        NOT NULL,
    permission_id  UUID                        NOT NULL,
    CONSTRAINT pk_utilisateurpermission PRIMARY KEY (utilisateur_id, permission_id)
);


ALTER TABLE public.utilisateurpermission
    ADD CONSTRAINT uc_3c6d9c8a44afe6b2bb8fe072f UNIQUE (utilisateur_id, permission_id);

ALTER TABLE public.utilisateur
    ADD CONSTRAINT uc_utilisateur_email UNIQUE (email);

ALTER TABLE public.utilisateur
    ADD CONSTRAINT uc_utilisateur_identifiant UNIQUE (identifiant);

ALTER TABLE public.utilisateur
    ADD CONSTRAINT uc_utilisateur_telephone UNIQUE (telephone);

ALTER TABLE public.permission
    ADD CONSTRAINT FK_PERMISSION_ON_PARENT FOREIGN KEY (parent_id) REFERENCES public.permission (permission_id);

ALTER TABLE public.utilisateurpermission
    ADD CONSTRAINT FK_UTILISATEURPERMISSION_ON_PERMISSIONID FOREIGN KEY (permission_id) REFERENCES public.permission (permission_id);

ALTER TABLE public.utilisateurpermission
    ADD CONSTRAINT FK_UTILISATEURPERMISSION_ON_UTILISATEURID FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur (utilisateur_id);

ALTER TABLE public.utilisateur
    ADD CONSTRAINT FK_UTILISATEUR_ON_ROLE FOREIGN KEY (role_id) REFERENCES public.role (role_id);
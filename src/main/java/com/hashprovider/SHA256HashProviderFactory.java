package com.hashprovider;

import org.keycloak.Config;
import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.credential.hash.PasswordHashProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class SHA256HashProviderFactory implements PasswordHashProviderFactory {

    public static final String ID = "sha256-salted";

    @Override
    public PasswordHashProvider create(KeycloakSession keycloakSession) {
        return new SHA256HashProvider(getId());
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return ID;
    }
}

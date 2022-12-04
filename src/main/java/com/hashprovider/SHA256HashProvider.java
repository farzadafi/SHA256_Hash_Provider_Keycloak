package com.hashprovider;

import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.credential.PasswordCredentialModel;

public class SHA256HashProvider implements PasswordHashProvider {

    private final String providerId;

    public SHA256HashProvider(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean policyCheck(PasswordPolicy passwordPolicy, PasswordCredentialModel passwordCredentialModel) {
        return false;
    }

    @Override
    public PasswordCredentialModel encodedCredential(String s, int i) {
        return null;
    }

    @Override
    public boolean verify(String s, PasswordCredentialModel passwordCredentialModel) {
        return false;
    }

    @Override
    public void close() {

    }
}

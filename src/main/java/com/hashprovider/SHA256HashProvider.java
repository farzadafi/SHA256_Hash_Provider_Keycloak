package com.hashprovider;

import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.credential.PasswordCredentialModel;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class SHA256HashProvider implements PasswordHashProvider {

    private final String providerId;
    public static final String ALGORITHM = "SHA-256";

    public SHA256HashProvider(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean policyCheck(PasswordPolicy passwordPolicy, PasswordCredentialModel passwordCredentialModel) {
        return this.providerId.equals(passwordCredentialModel.getPasswordCredentialData().getAlgorithm());
    }

    @Override
    public PasswordCredentialModel encodedCredential(String rawPassword, int iterations) {
        String salt = new String(generateSalt(), StandardCharsets.UTF_8);
        String encodedPassword = this.encode(rawPassword + salt, 27500);
        return PasswordCredentialModel.createFromValues(this.providerId, salt.getBytes(), 27500, encodedPassword);
    }

    @Override
    public boolean verify(String rawPassword, PasswordCredentialModel passwordCredentialModel) {
        String salt = new String(passwordCredentialModel.getPasswordSecretData().getSalt(), java.nio.charset.StandardCharsets.UTF_8);
        String encodedPassword = this.encode(rawPassword + salt, 27500);
        String hash = passwordCredentialModel.getPasswordSecretData().getValue();
        return encodedPassword.equals(hash);
    }

    @Override
    public String encode(String rawPassword, int iterations) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(rawPassword.getBytes());

            BigInteger bigInteger = new BigInteger(1, md.digest());

            System.out.printf("encoded final password is %s%n", String.format("%40x", bigInteger));
            return String.format("%040x", bigInteger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void close() {

    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return bytes;
    }
}

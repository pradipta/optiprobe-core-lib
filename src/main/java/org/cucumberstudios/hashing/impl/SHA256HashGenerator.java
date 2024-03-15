package org.cucumberstudios.hashing.impl;

import org.cucumberstudios.hashing.IHashGenerator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Implementation of {@link IHashGenerator} that generates a hash value using SHA-256 hashing algorithm.
 */
public class SHA256HashGenerator implements IHashGenerator {

    public static final String SHA_256 = "SHA-256";

    /**
     * Generates a hash value using SHA-256 hashing algorithm.
     *
     * @param uniqueReferenceId The unique reference ID to be hashed.
     * @return The generated hash value between 0 and 1000.
     * @throws IllegalArgumentException If the input uniqueReferenceId is null.
     */
    @Override
    public int generatehash(String uniqueReferenceId) {
        if (uniqueReferenceId == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(SHA_256);
            byte[] hashBytes = digest.digest(uniqueReferenceId.getBytes());
            int hash = byteArrayToInt(hashBytes);

            return Math.abs(hash % 1001);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return -1; // or throw an exception
        }
    }

    /**
     * Utility method to convert a byte array to an integer.
     *
     * @param bytes The byte array to be converted.
     * @return The integer value converted from the byte array.
     */
    private int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < bytes.length; i++) {
            value = (value << 8) | (bytes[i] & 0xFF);
        }
        return value;
    }
}

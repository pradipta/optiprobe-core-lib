package org.cucumberstudios.hashing.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SHA256HashGeneratorTest {

    @Test
    void generateHash_withNonNullInput() {
        SHA256HashGenerator hashGenerator = new SHA256HashGenerator(); // Instantiation added
        String input = "test_input";
        int hash = hashGenerator.generatehash(input);
        assertNotNull(hash);
        assertTrue(hash >= 0 && hash <= 1000);
    }

    @Test
    void generateHash_withNullInput() {
        SHA256HashGenerator hashGenerator = new SHA256HashGenerator(); // Instantiation added
        assertThrows(IllegalArgumentException.class, () -> hashGenerator.generatehash(null));
    }

//    @Test
//    void byteArrayToInt() {
//        SHA256HashGenerator hashGenerator = new SHA256HashGenerator(); // Instantiation added
//        byte[] bytes = {1, 2, 3, 4};
//        int value = hashGenerator.byteArrayToInt(bytes);
//        assertEquals(16909060, value);
//    }
}

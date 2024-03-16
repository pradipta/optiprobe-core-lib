package org.cucumberstudios.hashing.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

class SHA256HashGeneratorTest {

    @Test
    void testGenerateHash_withNonNullInput() {
        new TestRunner()
                .executeGeneratehash("test_input")
                .verifyGeneratedHashNotNull()
                .verifyIntegerWithinLimits();
    }

    @Test
    void testGenerateHash_withNullInput() {
        new TestRunner()
                .executeGeneratehash(null)
                .validateException(IllegalArgumentException.class);
    }

    class TestRunner {
        private SHA256HashGenerator sha256HashGenerator;
        private Throwable exception;
        private int generatedHash;
        private int anotherGeneratedHash;

        TestRunner() {
            initMocks(this);
            this.sha256HashGenerator = new SHA256HashGenerator();
        }
        public TestRunner executeGeneratehash(String input) {
            this.exception = catchThrowable(() ->
                    this.generatedHash =
                            sha256HashGenerator.generatehash(input));
            return this;
        }

        public TestRunner verifyGeneratedHashNotNull() {
            assertNotNull(this.generatedHash);
            return this;
        }

        public TestRunner verifyIntegerWithinLimits() {
            assertTrue(this.generatedHash >= 0 && this.generatedHash <= 1000);
            return this;
        }

        public TestRunner validateException(Class<IllegalArgumentException> expectedException) {
            assertThat(this.exception).isInstanceOf(expectedException);
            return this;
        }
    }
}


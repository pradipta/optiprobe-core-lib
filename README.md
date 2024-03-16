# Optiprobe Core Lib

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

OptiprobeCoreLib is a Java library that provides an implementation of the `IHashGenerator` interface, generating hash values using the SHA-256 (and more to come) hashing algorithm.

## Usage

```java
import org.cucumberstudios.hashing.impl.SHA256HashGenerator;
import org.cucumberstudios.hashing.IHashGenerator;

public class Example {
    public static void main(String[] args) {
        IHashGenerator hashGenerator = new SHA256HashGenerator();
        String uniqueReferenceId = "example_reference_id";
        int hashValue = hashGenerator.generateHash(uniqueReferenceId);
        System.out.println("Hash value: " + hashValue);
    }
}
```

## Installation

To use SHA256HashGenerator in your project, you can clone the repository and include it in your project as a library.

## License

This library is licensed under the MIT License. See the [LICENSE](LICENSE) file for details. TODO: add licence

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any bugs or feature requests.

## Author

SHA256HashGenerator is authored by [Pradipta](github.com/pradipta).


## Documentation

For more detailed information on how to use SHA256HashGenerator, refer to the [Javadoc](javadoc/index.html).

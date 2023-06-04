package eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators;

import java.math.BigInteger;

public class DigitPasswordGenerator implements PasswordGenerator<BigInteger> {

    @Override
    public BigInteger generatePassword() {
        return new BigInteger("123456789012");
    }
}

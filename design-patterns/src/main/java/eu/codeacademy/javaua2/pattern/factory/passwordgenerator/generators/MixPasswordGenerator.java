package eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators;

public class MixPasswordGenerator implements PasswordGenerator<String> {
    @Override
    public String generatePassword() {
        return "123abc";
    }
}

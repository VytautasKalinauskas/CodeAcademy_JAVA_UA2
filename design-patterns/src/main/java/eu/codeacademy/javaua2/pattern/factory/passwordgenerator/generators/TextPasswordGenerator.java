package eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators;

public class TextPasswordGenerator implements PasswordGenerator<String> {

    @Override
    public String generatePassword() {
        return "asDafRad";
    }
}

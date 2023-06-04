package eu.codeacademy.javaua2.pattern.factory.passwordgenerator.factory;

import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators.DigitPasswordGenerator;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators.MixPasswordGenerator;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators.PasswordGenerator;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators.TextPasswordGenerator;

public class GeneratorFactory {

    public PasswordGenerator getGenerator(String generatorType) {
        if (generatorType.equals("1")) {
            return new DigitPasswordGenerator();
        }

        if (generatorType.equals("2")) {
            return new TextPasswordGenerator();
        }

        if (generatorType.equals("3")) {
            return new MixPasswordGenerator();
        }

        return null;
    }
}

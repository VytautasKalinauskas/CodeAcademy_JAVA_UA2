package eu.codeacademy.javaua2.pattern.factory.passwordgenerator;


import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.factory.GeneratorFactory;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.generators.PasswordGenerator;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.menu.ConsoleMenu;
import eu.codeacademy.javaua2.pattern.factory.passwordgenerator.menu.MainMenu;

import java.io.IOException;

public class PasswordGeneratorApplication {

    private final ConsoleMenu mainMenu;

    public PasswordGeneratorApplication() {
        this.mainMenu = new MainMenu();
    }

    public void run() {
        mainMenu.print();
        try {
            String value = mainMenu.readInput();
            //TODO: PasswordGeneratorApplication factory should be called, read https://www.tutorialspoint.com.design_pattern.factory_pattern.htm

            PasswordGenerator passwordGenerator = new GeneratorFactory().getGenerator(value);
            System.out.println(passwordGenerator.generatePassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

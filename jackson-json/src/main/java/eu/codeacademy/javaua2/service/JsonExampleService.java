package eu.codeacademy.javaua2.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.codeacademy.javaua2.model.Car;
import eu.codeacademy.javaua2.model.Person;
import eu.codeacademy.javaua2.model.PersonChildrenMap;
import eu.codeacademy.javaua2.model.PersonFinancialObligation;
import eu.codeacademy.javaua2.model.PersonObligationMap;
import eu.codeacademy.javaua2.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class JsonExampleService {

    final ObjectMapper objectMapper = new ObjectMapper();

    public JsonExampleService() {
        // Don't throw an exception when json has extra fields you are
        // not serializing on. This is useful when you want to use a pojo
        // for deserialization and only care about a portion of the json
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Person basicSerializeAndDeserializeExample() {
        Person person = new Person("Petras", 25);

        File personJsonFile = new File("person.json");
        try {
            objectMapper.writeValue(personJsonFile, person);
            Person personDeserialized = objectMapper.readValue(personJsonFile, Person.class);
            System.out.println(personDeserialized);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public Car basicDeserializationFromResourcesExample() {
        File carJsonFile = null;
        Car car = new Car();
        try {
            carJsonFile = FileUtils.getFileFromResource("car.json");
            car = objectMapper.readValue(carJsonFile, Car.class);
            System.out.println(car);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    public void basicCompositionExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personCar.json");

            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void missingClassVariableByJsonProperty() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personCar.json");
//            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);  //TODO: investigate why this doesn't work
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void compositionWithEnumTypeExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personAddress.json");
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsonWithArrayExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personFinOblg.json");
            PersonFinancialObligation personFinancialObligation =
                    objectMapper.readValue(json, PersonFinancialObligation.class);
            System.out.println(personFinancialObligation);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsonWithMapExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personChildrenMap.json");
            System.out.println(objectMapper.readValue(json, PersonChildrenMap.class));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsonWithMapObjectsExample() {
        File json = null;
        try {
            json = FileUtils.getFileFromResource("personObligationMap.json");
            System.out.println(objectMapper.readValue(json, PersonObligationMap.class));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

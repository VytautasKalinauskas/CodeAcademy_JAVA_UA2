package eu.codeacademy.javaua2;

import eu.codeacademy.javaua2.service.JsonExampleService;

public class JacksonJson {
    public static void main(String[] args) {
        JsonExampleService jsonExampleService = new JsonExampleService();
        jsonExampleService.basicSerializeAndDeserializeExample();
        jsonExampleService.basicDeserializationFromResourcesExample();
        jsonExampleService.basicCompositionExample();
        jsonExampleService.missingClassVariableByJsonProperty();
        jsonExampleService.compositionWithEnumTypeExample();
        jsonExampleService.jsonWithArrayExample();
        jsonExampleService.jsonWithMapExample();
        jsonExampleService.jsonWithMapObjectsExample();
    }
}

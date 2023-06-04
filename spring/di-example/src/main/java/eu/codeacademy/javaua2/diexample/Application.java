package eu.codeacademy.javaua2.diexample;

import eu.codeacademy.javaua2.diexample.config.SpringContextConfig;
import eu.codeacademy.javaua2.diexample.dao.InternalMarksDao;
import eu.codeacademy.javaua2.diexample.service.GradeInternalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
//        simplePlainJavaDIExample();
        diExampleWithSpringContext();
    }

    private static void diExampleWithSpringContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        final GradeInternalService gradeService = context.getBean(GradeInternalService.class);
        System.out.println("Pazymiu vidurkis: " + gradeService.avarageGrade());
    }

    private static void simplePlainJavaDIExample() {
        System.out.println("Pazymiu vidurkis: " + new GradeInternalService(new InternalMarksDao()).avarageGrade());
    }
}

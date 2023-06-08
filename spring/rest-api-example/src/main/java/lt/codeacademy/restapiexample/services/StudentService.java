package lt.codeacademy.restapiexample.services;

import lt.codeacademy.restapiexample.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentsList = new ArrayList<>();

    private void addTestStudents() {
        studentsList.add(new Student(1L, "Marius", "Jurkenas", 25));
        studentsList.add(new Student(2L, "Jonas", "Jonaitis", 35));
        studentsList.add(new Student(3L, "Antanas", "Antanaitis", 45));
        studentsList.add(new Student(4L, "Petras", "Petraitis", 55));
    }

    public List<Student> getAllStudents() {
        if (studentsList.isEmpty()) {
            addTestStudents();
        }
        return studentsList;
    }

    public Student addStudent(Student student) {
        this.studentsList.add(student);
        return student;
    }

    public Student deleteStudentById(Long id) {
        Student studentToDelete = findStudentById(id);
        studentsList.remove(studentToDelete);
        return studentToDelete;
    }

    public List<Student> replaceStudentById(Long id, Student student) {
        Student studentToReplace = findStudentById(id);
        int indexOfStudent = this.studentsList.indexOf(studentToReplace);
        this.studentsList.set(indexOfStudent, student);
        return this.studentsList;
    }

    public List<Student> patchStudentById(Long id, Student student) {
        Student studentToReplace = findStudentById(id);

        if (student.getId() != null) {
            studentToReplace.setId(student.getId());
        }

        if (student.getAge() != null) {
            studentToReplace.setAge(student.getAge());
        }

        if (student.getName() != null) {
            studentToReplace.setName(student.getName());
        }

        if (student.getLastname() != null) {
            studentToReplace.setLastname(student.getLastname());
        }
        int indexOfStudent = this.studentsList.indexOf(studentToReplace);
        this.studentsList.set(indexOfStudent, studentToReplace);
        return this.studentsList;
    }


    public Student findStudentById(Long id) {
//        for (Student student : this.studentsList) {
//            if (student.getId().equals(id)) {
//                return student;
//            }
//        }
//        throw new Exception();

        Student studentToGet =
                this.studentsList.stream()
                        .filter(stud -> stud.getId().equals(id))
                        .findFirst().orElseThrow();
        return studentToGet;
    }

}

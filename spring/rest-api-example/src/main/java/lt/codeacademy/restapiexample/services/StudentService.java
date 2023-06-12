package lt.codeacademy.restapiexample.services;

import lt.codeacademy.restapiexample.dto.CreateStudentDTO;
import lt.codeacademy.restapiexample.entities.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentsList = new ArrayList<>();

    private void addTestStudents() {
        studentsList.add(new Student(1L, "Marius", "Jurkenas", LocalDate.of(1997, 7, 16), "31111112233", "AAA111", "+37066611122", LocalDateTime.now(), LocalDateTime.now()));
        studentsList.add(new Student(2L, "Jonas", "Jonaitis", LocalDate.of(1987, 8, 18), "38811112233", "AAA222", "+37066611342", LocalDateTime.now(), LocalDateTime.now()));
        studentsList.add(new Student(3L, "Antanas", "Antanaitis", LocalDate.of(1977, 4, 1), "31132112233", "AAA321", "+37066644122", LocalDateTime.now(), LocalDateTime.now()));
        studentsList.add(new Student(4L, "Petras", "Petraitis", LocalDate.of(1967, 2, 11), "31113412233", "ABB444", "+37066634122", LocalDateTime.now(), LocalDateTime.now()));
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

    public List<Student> replaceStudentById(Long id, CreateStudentDTO createStudentDTO) {
        Student studentToReplace = findStudentById(id);
        int indexOfStudent = this.studentsList.indexOf(studentToReplace);
        this.studentsList.set(indexOfStudent, new Student(studentToReplace, createStudentDTO));
        return this.studentsList;
    }

//    public List<Student> patchStudentById(Long id, Student student) {
//        Student studentToReplace = findStudentById(id);
//
//        if (student.getId() != null) {
//            studentToReplace.setId(student.getId());
//        }
//
//        if (student.getBirthDate() != null) {
//            studentToReplace.setBirthDate(LocalDate.parse(student.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        }
//
//        if (student.getName() != null) {
//            studentToReplace.setName(student.getName());
//        }
//
//        if (student.getLastname() != null) {
//            studentToReplace.setLastname(student.getLastname());
//        }
//        int indexOfStudent = this.studentsList.indexOf(studentToReplace);
//        this.studentsList.set(indexOfStudent, studentToReplace);
//        return this.studentsList;
//    }


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

    public Student findStudentByPersonalCode(Long personalCode) {
        Student studentToGet =
                this.studentsList.stream()
                        .filter(stud -> stud.getPersonalCode().equals(personalCode))
                        .findFirst().orElseThrow();
        return studentToGet;
    }

}

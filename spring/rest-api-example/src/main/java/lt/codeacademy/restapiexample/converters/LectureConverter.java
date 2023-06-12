package lt.codeacademy.restapiexample.converters;

import lt.codeacademy.restapiexample.dto.LectureDTO;
import lt.codeacademy.restapiexample.entities.Lecture;
import lt.codeacademy.restapiexample.entities.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class LectureConverter extends LectureDTO {

    public static LectureDTO convertLectureToDTO(Lecture lecture) {
        LectureDTO result = null;
        if (lecture != null) {
            result = new LectureDTO();
            result.setTitle(lecture.getTitle());
            result.setAttendantList(convertStudentsToAttendants(lecture.getAttendants()));
        }
        return result;
    }

    private static List<AttendantDTO> convertStudentsToAttendants(List<Student> students) {
        List<AttendantDTO> attendants = null;
        if (students != null) {
            attendants = new ArrayList<>();
            for (Student s : students) {
                attendants.add(new AttendantDTO(s.getName(), s.getLastname()));
            }
        }
        return attendants;
    }
}

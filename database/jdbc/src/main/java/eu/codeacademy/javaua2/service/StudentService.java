package eu.codeacademy.javaua2.service;

import eu.codeacademy.javaua2.model.Student;
import eu.codeacademy.javaua2.util.JdbcUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentService {

    public void findAllStudents() {

        try {
            Connection conn = JdbcUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, vardas, pavarde, kursas, vidurkis FROM Studentas");

            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", vardas: " + rs.getString("vardas"));
                System.out.print(", pavarde: " + rs.getString("pavarde"));
                System.out.println(", kursas: " + rs.getInt("kursas"));
                System.out.println(", vidurkis: " + rs.getDouble("vidurkis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findAllStudentsByCourse(Integer course) {
        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT id, vardas, pavarde, kursas, vidurkis FROM Studentas where kursas = ? and vardas = ? ORDER BY pavarde");
            stmt.setInt(1, course);
            stmt.setString(2, "Vytautas");
            ResultSet rs = stmt.executeQuery();
            System.out.println(course + " kurso studentai: ");
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", vardas: " + rs.getString("vardas"));
                System.out.print(", pavarde: " + rs.getString("pavarde"));
                System.out.println(", kursas: " + rs.getInt("kursas"));
                System.out.println(", vidurkis: " + rs.getDouble("vidurkis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createStudent(Integer id, String name, String surname, Integer course, Double markAverage) {
        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Studentas values (?,?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.setInt(4, course);
            stmt.setDouble(5, markAverage);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentCourse(Integer courseFrom, Integer courseTo) {
        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("update Studentas set kursas = ? where kursas = ? and vardas = ?");
            stmt.setInt(1, courseTo);
            stmt.setInt(2, courseFrom);
            stmt.setString(3, "Antanas");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

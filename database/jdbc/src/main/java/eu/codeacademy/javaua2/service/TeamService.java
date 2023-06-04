package eu.codeacademy.javaua2.service;

import eu.codeacademy.javaua2.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeamService {

    public void findAllTeams() {

        try (
                Connection conn = JdbcUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, pavadinimas, ikurimo_metai FROM komanda");
        ) {
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", pavadinimas: " + rs.getString("pavadinimas"));
                System.out.print(", ikurimo metai: " + rs.getString("ikurimo_metai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void findAllTeamsByName(String name) {
        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, pavadinimas, ikurimo_metai FROM komanda where pavadinimas = ?");
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Pavadinimas: " + rs.getString("pavadinimas"));
                System.out.print(", ikurimo metai: " + rs.getInt("ikurimo_metai"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}

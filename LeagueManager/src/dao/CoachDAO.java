package dao;

import model.Coach;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class CoachDAO {
    
    public List<Coach> getAllCoaches() throws SQLException {
        List<Coach> coaches = new ArrayList<>();
        String query = "SELECT * FROM Coach";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Coach c = new Coach();
                c.setCoachNumber(rs.getInt("CoachNumber"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setTeamNumber(rs.getInt("TeamNumber"));
                c.setSpecialty(rs.getString("Specialty"));
                coaches.add(c);
            }
        }
        return coaches;
    }

    public List<Coach> getCoachesByTeam(int teamNumber) throws SQLException {
        List<Coach> coaches = new ArrayList<>();
        String query = "SELECT * FROM Coach WHERE TeamNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, teamNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Coach c = new Coach();
                    c.setCoachNumber(rs.getInt("CoachNumber"));
                    c.setFirstName(rs.getString("FirstName"));
                    c.setLastName(rs.getString("LastName"));
                    c.setTeamNumber(rs.getInt("TeamNumber"));
                    c.setSpecialty(rs.getString("Specialty"));
                    coaches.add(c);
                }
            }
        }
        return coaches;
    }

    public void addCoach(Coach coach) throws SQLException {
        String query = "INSERT INTO Coach (FirstName, LastName, TeamNumber, Specialty) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, coach.getFirstName());
            pstmt.setString(2, coach.getLastName());
            pstmt.setInt(3, coach.getTeamNumber());
            pstmt.setString(4, coach.getSpecialty());
            pstmt.executeUpdate();
        }
    }

    public void updateCoach(Coach coach) throws SQLException {
        String query = "UPDATE Coach SET FirstName = ?, LastName = ?, TeamNumber = ?, Specialty = ? WHERE CoachNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, coach.getFirstName());
            pstmt.setString(2, coach.getLastName());
            pstmt.setInt(3, coach.getTeamNumber());
            pstmt.setString(4, coach.getSpecialty());
            pstmt.setInt(5, coach.getCoachNumber());
            pstmt.executeUpdate();
        }
    }

    public void deleteCoach(int coachNumber) throws SQLException {
        String query = "DELETE FROM Coach WHERE CoachNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, coachNumber);
            pstmt.executeUpdate();
        }
    }

    public Coach getCoachById(int coachNumber) throws SQLException {
        String query = "SELECT * FROM Coach WHERE CoachNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, coachNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Coach c = new Coach();
                    c.setCoachNumber(rs.getInt("CoachNumber"));
                    c.setFirstName(rs.getString("FirstName"));
                    c.setLastName(rs.getString("LastName"));
                    c.setTeamNumber(rs.getInt("TeamNumber"));
                    c.setSpecialty(rs.getString("Specialty"));
                    return c;
                }
            }
        }
        return null;
    }
}
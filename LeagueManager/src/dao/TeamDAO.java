package dao;

import model.Team;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class TeamDAO {
    
    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM Team";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Team t = new Team();
                t.setTeamNumber(rs.getInt("TeamNumber"));
                t.setName(rs.getString("Name"));
                t.setCity(rs.getString("City"));
                t.setManagerName(rs.getString("ManagerName"));
                teams.add(t);
            }
        }
        return teams;
    }

    public void addTeam(Team team) throws SQLException {
        String query = "INSERT INTO Team (Name, City, ManagerName) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, team.getName());
            pstmt.setString(2, team.getCity());
            pstmt.setString(3, team.getManagerName());
            pstmt.executeUpdate();
        }
    }

    public void updateTeam(Team team) throws SQLException {
        String query = "UPDATE Team SET Name = ?, City = ?, ManagerName = ? WHERE TeamNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, team.getName());
            pstmt.setString(2, team.getCity());
            pstmt.setString(3, team.getManagerName());
            pstmt.setInt(4, team.getTeamNumber());
            pstmt.executeUpdate();
        }
    }

    public void deleteTeam(int teamNumber) throws SQLException {
        String query = "DELETE FROM Team WHERE TeamNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, teamNumber);
            pstmt.executeUpdate();
        }
    }

    public Team getTeamById(int teamNumber) throws SQLException {
        String query = "SELECT * FROM Team WHERE TeamNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, teamNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Team t = new Team();
                    t.setTeamNumber(rs.getInt("TeamNumber"));
                    t.setName(rs.getString("Name"));
                    t.setCity(rs.getString("City"));
                    t.setManagerName(rs.getString("ManagerName"));
                    return t;
                }
            }
        }
        return null;
    }
}
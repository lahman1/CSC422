package dao;

import model.Player;
import db.DBConnection;

import java.sql.*;
import java.util.*;

public class PlayerDAO {
    
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM Player";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Player p = new Player();
                p.setPlayerNumber(rs.getInt("PlayerNumber"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setTeamNumber(rs.getInt("TeamNumber"));
                p.setPosition(rs.getString("Position"));
                players.add(p);
            }
        }
        return players;
    }

    public List<Player> getPlayersByTeam(int teamNumber) throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM Player WHERE TeamNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, teamNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Player p = new Player();
                    p.setPlayerNumber(rs.getInt("PlayerNumber"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setTeamNumber(rs.getInt("TeamNumber"));
                    p.setPosition(rs.getString("Position"));
                    players.add(p);
                }
            }
        }
        return players;
    }

    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO Player (FirstName, LastName, TeamNumber, Position) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, player.getFirstName());
            pstmt.setString(2, player.getLastName());
            pstmt.setInt(3, player.getTeamNumber());
            pstmt.setString(4, player.getPosition());
            pstmt.executeUpdate();
        }
    }

    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE Player SET FirstName = ?, LastName = ?, TeamNumber = ?, Position = ? WHERE PlayerNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, player.getFirstName());
            pstmt.setString(2, player.getLastName());
            pstmt.setInt(3, player.getTeamNumber());
            pstmt.setString(4, player.getPosition());
            pstmt.setInt(5, player.getPlayerNumber());
            pstmt.executeUpdate();
        }
    }

    public void deletePlayer(int playerNumber) throws SQLException {
        String query = "DELETE FROM Player WHERE PlayerNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, playerNumber);
            pstmt.executeUpdate();
        }
    }

    public Player getPlayerById(int playerNumber) throws SQLException {
        String query = "SELECT * FROM Player WHERE PlayerNumber = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, playerNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Player p = new Player();
                    p.setPlayerNumber(rs.getInt("PlayerNumber"));
                    p.setFirstName(rs.getString("FirstName"));
                    p.setLastName(rs.getString("LastName"));
                    p.setTeamNumber(rs.getInt("TeamNumber"));
                    p.setPosition(rs.getString("Position"));
                    return p;
                }
            }
        }
        return null;
    }
}
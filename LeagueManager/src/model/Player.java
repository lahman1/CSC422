package model;

public class Player {
    private int playerNumber;
    private String firstName;
    private String lastName;
    private int teamNumber;
    private String position;

    // Default constructor
    public Player() {}

    // Constructor with parameters
    public Player(int playerNumber, String firstName, String lastName, int teamNumber, String position) {
        this.playerNumber = playerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamNumber = teamNumber;
        this.position = position;
    }

    // Getters and setters
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamNumber=" + teamNumber +
                ", position='" + position + '\'' +
                '}';
    }
}
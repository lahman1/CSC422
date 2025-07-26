package model;

public class Coach {
    private int coachNumber;
    private String firstName;
    private String lastName;
    private int teamNumber;
    private String specialty;

    // Default constructor
    public Coach() {}

    // Constructor with parameters
    public Coach(int coachNumber, String firstName, String lastName, int teamNumber, String specialty) {
        this.coachNumber = coachNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamNumber = teamNumber;
        this.specialty = specialty;
    }

    // Getters and setters
    public int getCoachNumber() {
        return coachNumber;
    }

    public void setCoachNumber(int coachNumber) {
        this.coachNumber = coachNumber;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachNumber=" + coachNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamNumber=" + teamNumber +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
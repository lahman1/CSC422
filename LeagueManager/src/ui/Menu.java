package ui;

import dao.TeamDAO;
import dao.PlayerDAO;
import dao.CoachDAO;
import model.Team;
import model.Player;
import model.Coach;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private TeamDAO teamDAO = new TeamDAO();
    private PlayerDAO playerDAO = new PlayerDAO();
    private CoachDAO coachDAO = new CoachDAO();

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n--- League Manager ---");
            System.out.println("1. View Teams");
            System.out.println("2. Add Team");
            System.out.println("3. View Players");
            System.out.println("4. Add Player");
            System.out.println("5. View Coaches");
            System.out.println("6. Add Coach");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> viewTeams();
                    case 2 -> addTeam();
                    case 3 -> viewPlayers();
                    case 4 -> addPlayer();
                    case 5 -> viewCoaches();
                    case 6 -> addCoach();
                    case 7 -> {
                        System.out.println("Exiting League Manager. Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    private void viewTeams() {
        try {
            List<Team> teams = teamDAO.getAllTeams();
            if (teams.isEmpty()) {
                System.out.println("No teams found.");
            } else {
                System.out.println("\n--- Teams ---");
                for (Team team : teams) {
                    System.out.println(team.getTeamNumber() + ": " + team.getName() + 
                                     " (" + team.getCity() + ") - Manager: " + team.getManagerName());
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving teams: " + e.getMessage());
        }
    }

    private void addTeam() {
        System.out.print("Enter team name: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter manager name: ");
        String manager = scanner.nextLine();

        Team t = new Team();
        t.setName(name);
        t.setCity(city);
        t.setManagerName(manager);

        try {
            teamDAO.addTeam(t);
            System.out.println("Team added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding team: " + e.getMessage());
        }
    }

    private void viewPlayers() {
        try {
            List<Player> players = playerDAO.getAllPlayers();
            if (players.isEmpty()) {
                System.out.println("No players found.");
            } else {
                System.out.println("\n--- Players ---");
                for (Player player : players) {
                    System.out.println(player.getPlayerNumber() + ": " + player.getFirstName() + 
                                     " " + player.getLastName() + " (Team: " + player.getTeamNumber() + 
                                     ", Position: " + player.getPosition() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving players: " + e.getMessage());
        }
    }

    private void addPlayer() {
        System.out.print("Enter first name: ");
        scanner.nextLine(); // consume newline
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter team number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter position: ");
        String position = scanner.nextLine();

        Player p = new Player();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setTeamNumber(teamNumber);
        p.setPosition(position);

        try {
            playerDAO.addPlayer(p);
            System.out.println("Player added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding player: " + e.getMessage());
        }
    }

    private void viewCoaches() {
        try {
            List<Coach> coaches = coachDAO.getAllCoaches();
            if (coaches.isEmpty()) {
                System.out.println("No coaches found.");
            } else {
                System.out.println("\n--- Coaches ---");
                for (Coach coach : coaches) {
                    System.out.println(coach.getCoachNumber() + ": " + coach.getFirstName() + 
                                     " " + coach.getLastName() + " (Team: " + coach.getTeamNumber() + 
                                     ", Specialty: " + coach.getSpecialty() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving coaches: " + e.getMessage());
        }
    }

    private void addCoach() {
        System.out.print("Enter first name: ");
        scanner.nextLine(); // consume newline
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter team number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();

        Coach c = new Coach();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setTeamNumber(teamNumber);
        c.setSpecialty(specialty);

        try {
            coachDAO.addCoach(c);
            System.out.println("Coach added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding coach: " + e.getMessage());
        }
    }
}
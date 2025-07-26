# League Manager - Java + JDBC Application

A tennis league management system built with Java and JDBC for database operations.

## Project Structure

```
LeagueManager/
├── src/
│   ├── db/
│   │   └── DBConnection.java      # Database connection management
│   ├── model/
│   │   ├── Team.java             # Team model class
│   │   ├── Player.java           # Player model class
│   │   └── Coach.java            # Coach model class
│   ├── dao/
│   │   ├── TeamDAO.java          # Team data access operations
│   │   ├── PlayerDAO.java        # Player data access operations
│   │   └── CoachDAO.java         # Coach data access operations
│   ├── ui/
│   │   └── Menu.java             # Text-based user interface
│   └── Main.java                 # Application entry point
├── build/                        # Compiled class files
├── lib/                          # JDBC driver jars (optional)
└── README.md                     # This file
```

## Features

- **Team Management**: Add, view, update, and delete teams
- **Player Management**: Add, view, update, and delete players
- **Coach Management**: Add, view, update, and delete coaches
- **Text-based UI**: Interactive menu-driven interface
- **JDBC Integration**: Database operations using JDBC

## Database Setup

The application is configured to connect to a MySQL database named `TennisLeague`. 

**Default Connection Settings:**
- URL: `jdbc:mysql://localhost:3306/TennisLeague`
- Username: `root`
- Password: `yourpassword`

### Database Schema

The application expects the following tables:

```sql
-- Team table
CREATE TABLE Team (
    TeamNumber INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    City VARCHAR(100) NOT NULL,
    ManagerName VARCHAR(100) NOT NULL
);

-- Player table
CREATE TABLE Player (
    PlayerNumber INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    TeamNumber INT,
    Position VARCHAR(50),
    FOREIGN KEY (TeamNumber) REFERENCES Team(TeamNumber)
);

-- Coach table
CREATE TABLE Coach (
    CoachNumber INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    TeamNumber INT,
    Specialty VARCHAR(100),
    FOREIGN KEY (TeamNumber) REFERENCES Team(TeamNumber)
);
```

## Compilation and Execution

### Compile the application:
```bash
cd LeagueManager/src
javac -d ../build -cp . Main.java ui/Menu.java dao/*.java model/*.java db/DBConnection.java
```

### Run the application:
```bash
cd LeagueManager/build
java -cp . Main
```

## Configuration

To configure the database connection, edit the `DBConnection.java` file:

```java
private static final String URL = "jdbc:mysql://localhost:3306/TennisLeague";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword"; // update with your password
```

## Usage

Once the application starts, you'll see a menu with the following options:

1. **View Teams** - Display all teams in the league
2. **Add Team** - Add a new team
3. **View Players** - Display all players
4. **Add Player** - Add a new player
5. **View Coaches** - Display all coaches
6. **Add Coach** - Add a new coach
7. **Exit** - Close the application

## Dependencies

- Java 17 or higher
- MySQL JDBC Driver (mysql-connector-java)
- MySQL Database Server

## Notes

- Make sure MySQL is running and the `TennisLeague` database exists
- Update the database connection parameters in `DBConnection.java` to match your setup
- The JDBC driver jar should be in your classpath when running the application
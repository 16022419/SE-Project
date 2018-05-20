package DataAccess;

import Business.Note;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Business.Activities;
import Business.Users;

public class Operation {
    private static final String USER = "xuanthanh121998";
    private static final String PASSWORD = "16121998";
    private static final String URL = "jdbc:mysql://localhost/timetable";

    private static Connection connection;
    private static Statement statement;
    private static Operation operation;

    private static ArrayList<Users> listUser;
    private static ArrayList<Activities> listActivities;
    private static ArrayList<Note> listNote;

    private Operation() {
        listUser = new ArrayList<>();
        listActivities = new ArrayList<>();
        System.out.println("Created Object");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            statement = (Statement) connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Cannot connect to Database");
            e.printStackTrace();
        }
    }

    public static Operation getOperation() {
        if (operation == null) {
            operation = new Operation();
            System.out.println("Object created");
        } else {
            System.out.print("Object exited");
        }
        return operation;
    }

    public static ArrayList<Users> getAllUsers() {
        ArrayList<Users> Users = new ArrayList<>();
        return  Users;
    }

    public static ArrayList<Activities> getAllActivities() {
        ArrayList<Activities> Activities = new ArrayList<>();
        return  Activities;
    }

    public static ArrayList<Note> getAllNotes() {
        ArrayList<Note> Note = new ArrayList<>();
        return Note;
    }

    public ArrayList<Users> getAllUser() {
        ArrayList<Users> result = new ArrayList<>();
        String getAllQuery  = "SELECT * FROM `users`;";
        ResultSet resultSet;
        String id;
        String name;
        int gender;
        String email;
        String password;
        try {
            resultSet =  statement.executeQuery(getAllQuery);
            while(resultSet.next()) {
                id = resultSet.getString("id");
                name = resultSet.getString("name");
                password = resultSet.getString("password");
                gender = resultSet.getInt("gender");
                email =resultSet.getString("email");

                result.add(new Users(id, name, password, gender, email));
                listUser.add(new Users(id, name, password, gender, email));
            }
        } catch (SQLException e) {
            System.out.println("Data not found");
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Activities> getAllActivitie() {
        ArrayList<Activities> result = new ArrayList<>();
        String getAllQuery  = "SELECT * FROM `activities`;";
        ResultSet resultSet;
        String id;
        String userId;
        String name;
        /*int priority;
        int ranking;
        int status;*/
        Timestamp startTime;
        Timestamp endTime;
        try {
            resultSet =  statement.executeQuery(getAllQuery);
            while(resultSet.next()) {
                id = resultSet.getString("id");
                name = resultSet.getString("name");
                userId = resultSet.getString("userId");
                /*priority = resultSet.getInt("priority");
                ranking = resultSet.getInt("ranking");
                status = resultSet.getInt("status");*/
                startTime = resultSet.getTimestamp("startTime");
                endTime = resultSet.getTimestamp("endTime");

                result.add(new Activities(id, userId, name,  /*priority, ranking, status,*/ startTime, endTime));
                listActivities.add(new Activities(id, userId, name, /*priority, ranking, status,*/ startTime, endTime));
            }
        } catch (SQLException e) {
            System.out.println("Data not found");
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Note> getAllNote() {
        ArrayList<Note> result = new ArrayList<>();
        String getAllQuery  = "SELECT * FROM `notes`;";
        ResultSet resultSet;
        String id;
        String userId;
        String name;
        /*int priority;
        int status;*/
        Timestamp time;
        try {
            resultSet =  statement.executeQuery(getAllQuery);
            while(resultSet.next()) {
                id = resultSet.getString("id");
                userId = resultSet.getString("userId");
                name = resultSet.getString("name");
                /*priority = resultSet.getInt("priority");
                status = resultSet.getInt("status");*/
                time = resultSet.getTimestamp("time");

                result.add(new Note(id, name, userId, /*priority, status,*/ time));
                listNote.add(new Note(id, name, userId, /*priority, status,*/ time));
            }
        } catch (SQLException e) {
            System.out.println("Data not found");
            e.printStackTrace();
        }
        return result;
    }

    public boolean pushUser(Users users) {
        String PUSH_USER = "INSERT INTO `users` VALUES ('" + users.getId() + "', '" + users.getName() + "',  '" + users.getPassword() + "', '" + users.getGender() + "', '" +
        users.getEmail() + "');";
        try {
            statement.execute(PUSH_USER);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pushActivities(Activities activity) {
        String PUSH_ACTIVITIES = "INSERT INTO `activities` (id,userId,name,startTime,endTime) VALUES  ('" + activity.getId() + "', '" + activity.getUserId() + "','" + activity.getName() + "',  '" + activity.getStartTime() + "', '" + activity.getEndTime() + "');";
        try {
            statement.execute(PUSH_ACTIVITIES);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean pushNote(Note note) {
        String PUSH_NOTE = "INSERT INTO `notes` VALUES  ('" + note.getId() + "', '" + note.getUserId() + "','" + note.getName() + "',  '" + note.getTime() + "');";
        try {
            statement.execute(PUSH_NOTE);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

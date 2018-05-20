package Business;

import DataAccess.Operation;

import java.sql.Timestamp;

public class Controller {

    private String userId;

    public void createNewUser (String username, String password, int gender, String email) {
        Operation operation = Operation.getOperation();
        String id = System.currentTimeMillis() + username;
        Users user = new Users (id, username, password, gender, email);
        operation.pushUser(user);
        userId = id;
    }

    public void createNewActivities (String userId, String name, Timestamp startTime, Timestamp endTime) {
        Operation operation = Operation.getOperation();
        String id = System.currentTimeMillis() + name;
        Activities activities = new Activities(id, userId, name, startTime, endTime);
        operation.pushActivities(activities);
    }

    public void createNewNote (String name, String userId, Timestamp time) {
        Operation operation = Operation.getOperation();
        String id = System.currentTimeMillis() + name;
        Note note = new Note(id, name,  userId, time);
        operation.pushNote(note);
    }

    public String getUserId() { return userId; }
}
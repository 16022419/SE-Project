package Business;

import java.sql.Timestamp;

public class Note {
    private String id;
    private String userId;
    private String name;
    /*private int priority;
    private int status;*/
    private Timestamp time;

    public Note (String id, String name, String userId, /*int priority, int status,*/ Timestamp time) {
        super();
        this.id = id;
        this.name = name;
        this.userId = userId;
        /*this.priority = priority;
        this.status = status;*/
        this.time = time;
    }

    public String getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getUserId () {
        return userId;
    }

    /*public int getPriority () { return priority; }

    public  int getStatus() { return status; }*/

    public Timestamp getTime() { return time;}

    public void setId (String id) { this.id = id; }

    public void setName (String name) {
        this.name = name;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    /*public void setPriority(int priority) { this.priority = priority; }

    public void setStatus(int status) { this.status = status; }*/

    public void setTime(Timestamp time) { this.time = time; }
}

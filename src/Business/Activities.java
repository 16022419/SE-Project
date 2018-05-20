package Business;

import java.sql.Timestamp;

public class Activities {
    private String id;
    private String userId;
    private String name;
    /*private int priority;
    private int ranking;
    private int status;*/
    private Timestamp startTime;
    private Timestamp endTime;


    public Activities (String id, String userId,String name, /*int priority, int ranking, int status,*/ Timestamp startTime, Timestamp endTime) {
        super();
        this.id = id;
        this.name = name;
        this.userId = userId;
        /*this.priority = priority;
        this.ranking = ranking;
        this.status = status;*/
        this.startTime = startTime;
        this.endTime = endTime;

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

    public  int getRanking() { return  ranking; }

    public  int getStatus() { return status; }*/

    public Timestamp getStartTime() { return startTime; }

    public Timestamp getEndTime() { return endTime;}

    public void setId (String id) { this.id = id; }

    public void setName (String name) {
        this.name = name;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    /*public void setPriority(int priority) { this.priority = priority; }

    public void setRanking(int ranking) { this.ranking = ranking; }

    public void setStatus(int status) { this.status = status; }*/

    public void setStartTime(Timestamp startTime) { this.startTime = startTime; }

    public void setEndTime(Timestamp endTime) { this.endTime = endTime; }
}

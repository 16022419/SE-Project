package Business;

public class Reminder {
    private String id;
    private String activityID;
    private String message;
    private int timeLeft;
    private int priority;
    private int status;

    public Reminder(String id, String activityID, String message, int timeLeft, int priority, int status) {
        this.id = id;
        this.activityID = activityID;
        this.message = message;
        this.timeLeft = timeLeft;
        this.priority = priority;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
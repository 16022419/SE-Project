package Business;

public class Users {
    private String id;
    private String name;
    private int gender;
    private String email;
    private String password;

    public Users (String id, String name, String password, int gender, String email) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getId() { return id;}

    public String getPassword() { return password; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getGender() {
        return gender;
    }

    public void setPassword(String password) { this.password = password; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
}

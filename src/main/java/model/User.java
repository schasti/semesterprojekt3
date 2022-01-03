package model;

public class User {
    private String username;
    private String password;

    public User(){

    }
    public User(String user, String s) {
        setUsername(user);
    }

    public User(LoginData loginData) {
        setUsername(loginData.getUsername());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

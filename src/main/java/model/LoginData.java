package model;

public class LoginData {
    private String username;
    private String password;

    public LoginData(String user, String pass) {
        setUsername(user);
        setPassword(pass);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

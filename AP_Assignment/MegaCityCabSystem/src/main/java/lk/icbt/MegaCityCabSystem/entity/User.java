package lk.icbt.MegaCityCabSystem.entity;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String userrole;

    public User() {
    }

    public User(String userId, String userName, String password, String userrole) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userrole = userrole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
}

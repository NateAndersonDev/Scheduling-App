package Model;

/**
 * User class Declaration
 */
public class User {
    private long userId;
    private String userName;
    private String password;

    /**
     * User Class constructor
     * @param userId the user's ID
     * @param userName the user's Name
     * @param password the user's Password
     */
    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    /**
     *
     * @return the user's id
     */
    public long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId the user's id;
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return the user's userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName the user's userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}


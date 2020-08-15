package Model;

public abstract class BaseUser {

    protected String login;
    protected String password;
    protected AccountType type;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getType() {
        return type;
    }
}
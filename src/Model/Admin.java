package Model;

public class Admin extends BaseUser {

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
        type = AccountType.ADMIN;
    }
}
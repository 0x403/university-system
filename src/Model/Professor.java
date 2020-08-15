package Model;

public class Professor extends BaseUser {

    public Professor(String login, String password) {
        this.login = login;
        this.password = password;
        type = AccountType.PROFESSOR;
    }

}
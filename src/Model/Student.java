package Model;

public class Student extends BaseUser {

    public Student(String login, String password) {
        this.login = login;
        this.password = password;
        type = AccountType.STUDENT;
    }

}
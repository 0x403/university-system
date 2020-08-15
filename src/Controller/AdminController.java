package Controller;

import Model.AccountType;
import View.AdminView;

public class AdminController {
    static public void createUser() {
        String[] loginPasswordType = AdminView.createAccount();
        String login = loginPasswordType[0];
        String password = loginPasswordType[1];
        String accType = loginPasswordType[2];
        if(accType.equals("professor")) {
            DbHandler.addUser(login, password, AccountType.PROFESSOR);
        }
        else if(accType.equals("student")) {
            DbHandler.addUser(login, password, AccountType.STUDENT);
        }
        else {
            System.out.println("Wrong given account type.");
        }
    }

    static public void deleteUser() {
        String delLogin = AdminView.deleteAccount();
        if(DbHandler.isUserExist(delLogin)) {
            DbHandler.removeUser(delLogin);
        } else {
            System.out.println("Given login doesn't exist.");
        }
    }
}

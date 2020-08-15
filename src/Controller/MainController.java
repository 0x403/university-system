package Controller;

import Model.*;
import View.*;

public class MainController {

    MenuStates menu;
    BaseUser loggedUser;

    public MainController() {
        menu = MenuStates.MAIN_MENU;
    }

    public void run() {
        DbHandler.init();
        while(true) {
            if(menu == MenuStates.MAIN_MENU) {
                String[] loginAndPassword = MainMenuView.mainMenu();
                if (DbHandler.isUserExist(loginAndPassword[0])) {
                    BaseUser user = DbHandler.getUser(loginAndPassword[0]);
                    if (user.getPassword().equals(loginAndPassword[1])) {
                        loggedUser = user;
                        AccountType accType = user.getType();
                        switch (accType) {
                            case ADMIN:
                                menu = MenuStates.ADMIN;
                                break;
                            case PROFESSOR:
                                menu = MenuStates.PROFESSOR;
                                break;
                            case STUDENT:
                                menu = MenuStates.STUDENT;
                                break;
                            default:
                                System.out.println("Wrong account type");
                        }
                    } else {
                        System.out.println("Wrong password.");
                    }
                } else {
                    System.out.println("Given user doesn't exist.");
                }
            }
            else if(menu == MenuStates.ADMIN) {
                int optionAdmin = AdminView.adminMenu();
                switch (optionAdmin) {
                    case 1:
                        AdminController.createUser();
                        break;
                    case 2:
                        AdminController.deleteUser();
                        break;
                    case 9:
                        menu = MenuStates.MAIN_MENU;
                        break;
                    default:
                        System.out.println("Wrong option.");
                }
            }
            else if(menu == MenuStates.PROFESSOR) {
                int optionProf = ProfessorView.professorMenu();
                switch (optionProf) {
                    case 1:
                        ProfessorController.addSemesterSubject();
                        break;
                    case 2:
                        ProfessorController.deleteSemesterSubject();
                        break;
                    case 3:
                        ProfessorController.getStudentMark();
                        break;
                    case 4:
                        ProfessorController.getAvgStudentMarks();
                        break;
                    case 5:
                        ProfessorController.setStudentMark();
                        break;
                    case 9:
                        menu = MenuStates.MAIN_MENU;
                        break;
                    default:
                        System.out.println("Wrong option.");
                }
            }
            else if(menu == MenuStates.STUDENT) {
                int optionStudent = StudentView.studentMenu();
                switch (optionStudent) {
                    case 1:
                        StudentController.getMarks(loggedUser.getLogin());
                        break;
                    case 2:
                        StudentController.registerToSubject((Student) loggedUser);
                        break;
                    case 9:
                        menu = MenuStates.MAIN_MENU;
                        break;
                    default:
                        System.out.println("Wrong option.");
                }
            }
        }
    }
}

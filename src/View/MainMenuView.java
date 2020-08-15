package View;

public class MainMenuView extends BaseView {

    static public String[] mainMenu() {

        System.out.println("========== UNIVERSITY SYSTEM ==========");
        System.out.println("=======================================");
        System.out.println("LOGIN: ");
        String login = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String password = scanner.nextLine();
        System.out.println("=======================================");

        return (new String[]{login, password});
    }
}

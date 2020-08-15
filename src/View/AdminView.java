package View;

public class AdminView extends BaseView {

    static public int adminMenu() {
        System.out.println("1. CREATE NEW ACCOUNT");
        System.out.println("2. DELETE ACCOUNT");
        System.out.println("9. BACK");
        return Integer.parseInt(scanner.nextLine());
    }

    static public String[] createAccount() {
        System.out.println("ENTER LOGIN FOR NEW ACCOUNT: ");
        String login = scanner.nextLine();
        System.out.println("ENTER PASSWORD: ");
        String password = scanner.nextLine();
        System.out.println("IS IT STUDENT OR PROFESSOR ACCOUNT? (enter 'student' or 'professor')");
        String accType = scanner.nextLine();
        return (new String[]{login, password, accType});
    }

    static public String deleteAccount() {
        System.out.println("ENTER LOGIN OF THE ACCOUNT TO BE DELETED: ");
        return scanner.nextLine();
    }
}

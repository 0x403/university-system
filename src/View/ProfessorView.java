package View;

public class ProfessorView extends BaseView {
    static public int professorMenu() {
        System.out.println("1. ADD NEW SUBJECT TO SEMESTER");
        System.out.println("2. DELETE EXISTING SUBJECT FROM SEMESTER");
        System.out.println("3. GET SPECIFIC STUDENT'S MARK");
        System.out.println("4. GET AVERAGE STUDENT'S MARKS");
        System.out.println("5. SET STUDENT'S MARK");
        System.out.println("9. BACK");
        return Integer.parseInt(scanner.nextLine());
    }

    static public String[] addNewSubject() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE NEW SUBJECT: ");
        String subject = scanner.nextLine();
        return (new String[]{semester, subject});
    }

    static public String[] deleteSubject() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE SUBJECT: ");
        String subject = scanner.nextLine();
        return (new String[]{semester, subject});
    }

    static public String[] getStudentMark() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE SUBJECT: ");
        String subject = scanner.nextLine();
        System.out.println("ENTER THE STUDENT'S LOGIN: ");
        String login = scanner.nextLine();
        return (new String[]{semester, subject, login});
    }

    static public String[] getAvgStudentMarks() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE STUDENT'S LOGIN: ");
        String login = scanner.nextLine();
        return (new String[]{semester, login});
    }

    static public String[] setStudentMark() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE SUBJECT: ");
        String subject = scanner.nextLine();
        System.out.println("ENTER THE STUDENT'S LOGIN: ");
        String login = scanner.nextLine();
        System.out.println("ENTER MARK FOR THE STUDENT: ");
        String mark = scanner.nextLine();
        return (new String[]{semester, subject, login, mark});
    }
}

package View;

import java.util.HashMap;

public class StudentView extends BaseView {
    static public int studentMenu() {
        System.out.println("1. GET MY MARKS");
        System.out.println("2. REGISTER TO THE SUBJECT");
        System.out.println("9. BACK");
        return Integer.parseInt(scanner.nextLine());
    }

    static public void getMarks(HashMap marks) {
        marks.forEach((subject, mark) -> {
            System.out.println(subject + ": " + mark);
        });
    }

    static public String[] registerToSubject() {
        System.out.println("ENTER SEMESTER: ");
        String semester = scanner.nextLine();
        System.out.println("ENTER THE SUBJECT: ");
        String subject = scanner.nextLine();
        return (new String[]{semester, subject});
    }
}

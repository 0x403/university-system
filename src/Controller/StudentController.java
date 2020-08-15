package Controller;

import Model.Student;
import View.StudentView;

import java.util.HashMap;

public class StudentController {

    static public void getMarks(String login) {
        HashMap<String, Integer> studentMarks = DbHandler.getAllStudentMarks(login);

        if(studentMarks.size() == 0) {
            System.out.println("You didn't register to any subject.");
        } else {
            StudentView.getMarks(studentMarks);
        }
    }

    static public void registerToSubject(Student student) {
        String[] semesterSubject = StudentView.registerToSubject();
        int semester = Integer.parseInt(semesterSubject[0]);
        String subject = semesterSubject[1];
        if(DbHandler.containsSubjectInSemester(semester, subject)) {
            HashMap givenSubject = (HashMap<String, Integer>) DbHandler.getSubject(semester, subject);
            givenSubject.put(student.getLogin(), 0);
        } else {
            System.out.println("Semester or subject doesn't exist.");
        }
    }

}

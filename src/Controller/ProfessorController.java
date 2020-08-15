package Controller;

import View.ProfessorView;

public class ProfessorController {

    static public void addSemesterSubject() {
        String[] semesterNewSubject = ProfessorView.addNewSubject();
        int semesterNumber = Integer.parseInt(semesterNewSubject[0]);
        if (DbHandler.containsSemester(semesterNumber)) {
            DbHandler.addSemesterSubject(semesterNumber, semesterNewSubject[1]);
        } else {
            System.out.println("Given semester doesn't exist.");
        }
    }

    static public void deleteSemesterSubject() {
        String[] semesterDelSubject = ProfessorView.deleteSubject();
        int semesterNumber = Integer.parseInt(semesterDelSubject[0]);
        if (DbHandler.containsSemester(semesterNumber)) {
            String subjectToBeDeleted = semesterDelSubject[1];
            if(DbHandler.containsSubjectInSemester(semesterNumber, subjectToBeDeleted)) {
                DbHandler.removeSubject(semesterNumber, subjectToBeDeleted);
            } else {
                System.out.println("Given subject doesn't exist.");
            }
        } else {
            System.out.println("Given semester doesn't exist.");
        }
    }

    static public void getStudentMark() {
        String[] semesterSubjectLogin = ProfessorView.getStudentMark();
        int semesterNumber = Integer.parseInt(semesterSubjectLogin[0]);
        String subject = semesterSubjectLogin[1];
        String login = semesterSubjectLogin[2];
        if(DbHandler.containsSemester(semesterNumber)) {
            if(DbHandler.containsSubjectInSemester(semesterNumber, subject)) {
                if(DbHandler.isStudentRegisterToTheSubject(semesterNumber, subject, login)) {
                    int studentMark = DbHandler.getRegisteredStudentMark(semesterNumber, subject, login);
                    System.out.println(login + " got " + studentMark + " in " + subject);
                } else {
                    System.out.println("Given user doesn't exist.");
                }
            } else {
                System.out.println("Given subject doesn't exist.");
            }
        } else {
            System.out.println("Given semester doesn't exist.");
        }
    }

    static public void getAvgStudentMarks() {
        String[] semesterLogin = ProfessorView.getAvgStudentMarks();
        int semesterNumber = Integer.parseInt(semesterLogin[0]);
        if(DbHandler.containsSemester(semesterNumber)) {
            String login = semesterLogin[1];
            double average = DbHandler.getAvgStudentMarks(semesterNumber, login);
            String strAvg = String.format("%.2f", average);
            System.out.println(login + " got " + strAvg + " average.");
        } else {
            System.out.println("Given semester doesn't exist.");
        }
    }

    static public void setStudentMark() {
        String[] semesterSubjectLoginMark = ProfessorView.setStudentMark();
        int semester = Integer.parseInt(semesterSubjectLoginMark[0]);
        String subject = semesterSubjectLoginMark[1];
        String login = semesterSubjectLoginMark[2];
        int mark = Integer.parseInt(semesterSubjectLoginMark[3]);

        if(DbHandler.isStudentRegisterToTheSubject(semester, subject, login)) {
            DbHandler.setMark(semester, subject, login, mark);
        } else {
            System.out.println("There's no student registered to given subject");
        }
    }

}

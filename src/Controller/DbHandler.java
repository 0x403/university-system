package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DbHandler {
    static DbModel db = new DbModel();

    static public void init() {
        db.users.put("admin", new Admin("admin", "admin"));
        db.marks.put(1, new HashMap<String, HashMap<String, Integer>>());
        db.marks.put(2, new HashMap<String, HashMap<String, Integer>>());
        db.marks.put(3, new HashMap<String, HashMap<String, Integer>>());
        db.marks.put(4, new HashMap<String, HashMap<String, Integer>>());
        db.marks.put(5, new HashMap<String, HashMap<String, Integer>>());
        db.marks.put(6, new HashMap<String, HashMap<String, Integer>>());
    }

    static public boolean containsSemester(int semester) {
        return db.marks.containsKey(semester);
    }

    static public boolean containsSubjectInSemester(int semester, String subject) {
        if(containsSemester(semester)) {
            HashMap givenSemester = (HashMap<String, HashMap<String, Integer>>) getSemester(semester);
            return givenSemester.containsKey(subject);
        } else {
            return false;
        }
    }

    static public boolean isStudentRegisterToTheSubject(int semester, String subject, String login) {
        if(containsSubjectInSemester(semester, subject)) {
            HashMap givenSubject = (HashMap<String, Integer>) getSubject(semester, subject);
            return givenSubject.containsKey(login);
        } else {
            return false;
        }
    }

    static public HashMap getSemester(int semester) throws NoSuchElementException {
        if(containsSemester(semester)) {
            return (HashMap<String, HashMap<String, Integer>>) db.marks.get(semester);
        } else {
            throw new NoSuchElementException();
        }
    }

    static public HashMap getSubject(int semester, String subject) {
        if(containsSubjectInSemester(semester, subject)) {
            HashMap givenSemester = (HashMap<String, HashMap<String, Integer>>) getSemester(semester);
            return (HashMap<String, Integer>) givenSemester.get(subject);
        } else {
            throw new NoSuchElementException();
        }
    }

    static public int getRegisteredStudentMark(int semester, String subject, String login) {
        if(isStudentRegisterToTheSubject(semester, subject, login)) {
            HashMap givenSubject = (HashMap<String, Integer>) getSubject(semester, subject);
            return (int) givenSubject.get(login);
        } else {
            throw new NoSuchElementException();
        }
    }

    static public double getAvgStudentMarks(int semester, String login) {
        ArrayList marks = new ArrayList<Integer>();

        HashMap currentSemester = (HashMap<String, HashMap<String, Integer>>) getSemester(semester);
        currentSemester.forEach((k, v) -> {
            HashMap studentsInSubject = (HashMap<String, Integer>) v;
            if(studentsInSubject.containsKey(login)) {
                marks.add(studentsInSubject.get(login));
            }
        });

        if(marks.size() == 0) {
            System.out.println("There's no marks for " + login);
            throw new NoSuchElementException();
        } else {
            double sum = 0;
            for(Object mark: marks) {
                sum += (double) ((Integer) mark).intValue();
            }
            return sum / (double) marks.size();
        }
    }

    static public HashMap getAllStudentMarks(String login) {
        HashMap marks = new HashMap<String, Integer>();

        db.marks.forEach((semester, subject) -> {
            HashMap currentSubject = (HashMap<String, HashMap<String, Integer>>) subject;
            currentSubject.forEach((subjectName, users) -> {
                HashMap subjectUsers = (HashMap<String, Integer>) users;
                if(subjectUsers.containsKey(login)) {
                    int mark = (int) subjectUsers.get(login);
                    marks.put(subjectName, mark);
                }
            });
        });

        return marks;
    }

    static public void setMark(int semester, String subject, String login, int mark) {
        if(isStudentRegisterToTheSubject(semester, subject, login)) {
            HashMap givenSubject = (HashMap<String, Integer>) getSubject(semester, subject);
            givenSubject.replace(login, mark);
        } else {
            throw new NoSuchElementException();
        }
    }

    static public void addSemesterSubject(int semester, String subject) {
        HashMap givenSemester = (HashMap<String, HashMap<String, Integer>>) getSemester(semester);
        givenSemester.put(subject, new HashMap<String, Integer>());
    }

    static public void removeSubject(int semester, String subject) {
        HashMap givenSemester = (HashMap<String, HashMap<String, Integer>>) getSemester(semester);
        givenSemester.remove(subject);
    }

    static public boolean isUserExist(String login) {
        return db.users.containsKey(login);
    }

    static public BaseUser getUser(String login) throws NoSuchElementException {
        if(isUserExist(login)) {
            return (BaseUser) db.users.get(login);
        } else {
            throw new NoSuchElementException();
        }
    }

    static public void addUser(String login, String password, AccountType accType) {
        if(accType == AccountType.PROFESSOR) {
            db.users.put(login, new Professor(login, password));
        }
        else if(accType == AccountType.STUDENT) {
            db.users.put(login, new Student(login, password));
        }
        else {
            System.out.println("Wrong given account type.");
        }
    }

    static public void removeUser(String login) {
        if(isUserExist(login)) {
            db.users.remove(login);
        } else {
            throw new NoSuchElementException();
        }
    }
}

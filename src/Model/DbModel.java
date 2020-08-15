package Model;

import java.util.HashMap;

public class DbModel {
    public HashMap users = new HashMap<String, BaseUser>();
    // marks == HM<String(semester), HM<String(subjectName), HM<loginUser, mark>>>
    public HashMap marks = new HashMap<Integer, HashMap<String, HashMap<String, Integer>>>();
}

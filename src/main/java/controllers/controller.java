package controllers;
import classes.DBAccess;
import classes.statuses;
import classes.task;
import classes.friends;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class controller {
    public static DBAccess db=new DBAccess();
    public static void invokeThreads(int taskCode, statuses taskStatus){
        UpdateStatus updateStatus=new UpdateStatus(taskCode,taskStatus);
        CheckStatus checkStatus=new CheckStatus(taskCode,taskStatus);
        updateStatus.start();
        checkStatus.start();
    }
    //start from DBAccess getTaskByDM
    public List<task> getTaskFor(int code)
    {
        return db.getTaskByDM(code);
    }

    //details for all friends
    public  List<String> getAllDetails()
    {
        List<String> str=new ArrayList<String>();
        List<friends> newF= db.GetAllFriends();
        for(int i=0;i<newF.size();i++)
        {
            str.add(newF.get(i).toString());
        }
        Collections.sort(str);
        return str;
    }
    //checking if user exits-map
    public String ifExit(String fullName, String email) {
        List<friends> myFriends = db.GetAllFriends();
        Map<String, String> myMap = new HashMap<String, String>();
        for (friends f : myFriends)
            myMap.put(f.getFullName(), f.getEmail());
        String getMail=myMap.get(fullName);
        if(getMail.equals(email)){
            return "exist team member";
        }
        else return "the member team isn't exist";
    }
    public static  void initial() throws SQLException, ClassNotFoundException{
        db.initializing();
    }
}





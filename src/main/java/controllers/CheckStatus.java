package controllers;

import classes.DBAccess;
import classes.statuses;

public class CheckStatus extends Thread
{
    private int taskCode;
    private statuses taskStatus;

    public CheckStatus(int taskCode, statuses taskStatus) {
        this.taskCode = taskCode;
        this.taskStatus = taskStatus;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(int taskCode) {
        this.taskCode = taskCode;
    }

    public statuses getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(statuses taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public void run() {
        DBAccess myDb=new DBAccess();
        try {
            myDb.updateStatus(taskStatus,taskCode);
            System.out.println("check status");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

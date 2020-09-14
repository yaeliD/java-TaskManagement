package classes;

import java.util.Date;

public class task {
    private int code;
    private String taskTitle;
    private String taskDescription;
    private statuses taskStatus;
    private int belongTo;
    private double estimatedHour;
    private Date startDate;
    private Date endDate;

    public void setCode(int code) {
        this.code = code;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setStatus(statuses taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setBelongTo(int belongTo) {
        this.belongTo = belongTo;
    }

    public void setEstimatedHour(double estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCode() {
        return code;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public statuses istaskStatus() {
        return taskStatus;
    }

    public int getBelongTo() {
        return belongTo;
    }

    public double getEstimatedHour() {
        return estimatedHour;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public task(int code, String taskTitle, String taskDescription, statuses taskStatus, int belongTo, double estimatedHour, Date startDate, Date endDate) {
        this.code = code;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.belongTo = belongTo;
        this.estimatedHour = estimatedHour;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}


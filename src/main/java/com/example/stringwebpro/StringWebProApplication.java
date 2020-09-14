package com.example.stringwebpro;

import classes.friends;
import classes.statuses;
import classes.task;
import controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StringWebProApplication {
    public static controller controller = new controller();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(StringWebProApplication.class, args);
        controller.initial();
    }
    //http://localhost:8080/getallTeamMember
    @GetMapping("/getAllFriends")
    public List<friends> getTeammember() throws ClassNotFoundException {

        List<friends> friendsList = new ArrayList<friends>();
        friendsList = controller.db.GetAllFriends();
        return friendsList;
    }
    @GetMapping(value = "/getTaskFor/{code}")
    public List<task> getallTaskByMemberCode(@PathVariable int code) throws ClassNotFoundException {
        return  controller.getTaskFor(code);
    }
    @GetMapping(value = "/ifExit/{name}/{mail}")
    public String ifExit(@PathVariable String name,@PathVariable String mail) throws ClassNotFoundException {
        return  controller.ifExit(name,mail);
    }
    @GetMapping(value = "/invokeThreads/{taskCode}/{taskStatus}")
    public void invokeTheareds(@PathVariable int taskCode,@PathVariable statuses taskStatus) throws ClassNotFoundException {
        controller.invokeThreads(taskCode,taskStatus);
    }
}

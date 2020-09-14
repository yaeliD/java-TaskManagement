package classes;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class DBAccess {
    static final String db_URL="jdbc:sqlserver://(LocalDB)\\MSSQLLocalDB;DatabaseName=javaSql";
    static final String User="DESKTOP-N81M0SQ/user";
    static final String PASS= null;
    static Connection connection=null;
    Statement statement=null;

    static List<friends> f=new ArrayList<friends>();
    static List<task> t=new ArrayList<task>();
    public static void fillF() {
        f.add(new friends(1,"shalom lach","shalomlach@gmail.com"));
        f.add(new friends(2,"israel levi","israellevi@gmail.com"));
        f.add(new friends(3,"yosef cohen","yosefcohen@gmail.com"));
    }
    public static void fillT()
    {
        t.add(new task(1,"clean","clean all rooms",statuses.NEW,1,1,new Date(String.valueOf(LocalDate.now())),new Date("23/8/2020")));
        t.add(new task(2,"cook","cooking a cake",statuses.INPROGRES,2,1,new Date("20/8/2020"),new Date("23/8/2020")));
        t.add(new task(3,"buy","buying bread",statuses.DONE,3,1,new Date(String.valueOf(LocalDate.now())),new Date("23/8/2020")));
    }

    public List<friends> getF() {
        return f;
    }

    public void setF(List<friends> f) {
        this.f = f;
    }

    public List<task> getT() {
        return t;
    }

    public void setT(List<task> t) {
        this.t = t;
    }

    //get all tasks
    public List<task> GetAllTask()
    {
        String sql= "select * from task";
        try{
            connection = DriverManager.getConnection(db_URL, User, PASS);
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<task> taskList= new ArrayList<task>();
            return taskList;
        }
        catch (SQLException throwables)
        {
            return this.getT();
            //throwables.printStackTrace();
        }
    }

    //get all tasks belong to
    public List<task> getTaskByDM(int dmCode)
    {
        List<task> taskList= new ArrayList<task>();
        String sql= "select * from task where belongTo="+dmCode;
        try{
            connection = DriverManager.getConnection(db_URL, User, PASS);
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            return taskList;
        }
        catch (SQLException throwables)
        {
            for(int i=0;i<t.size();i++)
                if(this.t.get(i).getBelongTo()==dmCode)
                    taskList.add(this.t.get(i));
            return taskList;
           // throwables.printStackTrace();
        }
    }
    //insert new task
    public void insertTask(task t)
    {
        String sql= "insert into task values("+t.getCode()+","+t.getTaskTitle()+","+t.getTaskDescription()+","+t.istaskStatus()+ ","+t.getBelongTo()+","+t.getEstimatedHour()+","+t.getStartDate()+","+t.getEndDate()+")";
        try{
            connection = DriverManager.getConnection(db_URL, User, PASS);
            PreparedStatement ps=connection.prepareStatement(sql);
             int rs=ps.executeUpdate();
        }
        catch (SQLException throwables)
        {
            this.t.add(t);
            //throwables.printStackTrace();
        }
    }
    //update status
    public void updateStatus(statuses s,int taskCode)
    {
        String sql= "update task set taskStatus= "+s+" where code="+taskCode;
        try{
            connection = DriverManager.getConnection(db_URL, User, PASS);
            PreparedStatement ps=connection.prepareStatement(sql);
            int rs=ps.executeUpdate();
        }
        catch (SQLException throwables)
        {
            for(int i=0;i<this.t.size();i++)
                if(t.get(i).getCode()==taskCode)
                    this.t.get(i).setStatus(s);
            //throwables.printStackTrace();
        }
    }
    //get all friends
    public List<friends> GetAllFriends()
    {
        String sql= "select * from friends";
        try{
            connection = DriverManager.getConnection(db_URL, User, PASS);
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<friends> friendsList= new ArrayList<friends>();
            return friendsList;
        }
        catch (SQLException throwables)
        {
            return this.getF();
            //throwables.printStackTrace();
        }
    }
    public static void initializing() throws ClassNotFoundException, SQLException {
        fillF();
        fillT();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Connecting to a selected database...");
        try {
            connection = DriverManager.getConnection(db_URL, User, PASS);
            Statement sta = connection.createStatement();
            String Sql1 = "select * from Tasks";
            String Sql2 = "select * from TeamMember";

            ResultSet rs1 = sta.executeQuery(Sql1);
            ResultSet rs2 = sta.executeQuery(Sql2);
            String strSt = rs1.getString("taskStatus");
            statuses s = statuses.valueOf(strSt);
            while (rs1.next()) {
                int mCode = rs1.getInt("MemberCode");
                friends x1 = new friends();
                x1.setCode(
                        (Integer) mCode
                );
                t.add(new task(rs1.getInt("code"), rs1.getString("taskTitle"), rs1.getString("taskDescription"),
                        s, rs1.getInt("belongTo"), rs1.getDouble("estimatedHour"), rs1.getDate("startDate"),
                        rs1.getDate("endDate")));
            }
            while (rs2.next()) {
                f.add(new friends(rs2.getInt("code"), rs2.getString("fullName"), rs2.getString("email")));
            }

        } catch (Exception e) {
            System.out.println("cannot connect to sql");

        }
    }

}

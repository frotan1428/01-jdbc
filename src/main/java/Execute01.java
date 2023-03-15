import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1.step Register Driver
        Class.forName("org.postgresql.Driver");
        // 2 create connection
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev_paractice","dev_user","dev_pass");
       // 3  create a statements // to execute Sql query
        Statement stmnt=  con.createStatement();
       //
       // System.out.println("connection is successfully ...");

        // 4. execute sql query
        //TASK:1. create a table named "employee" with column names of : "employee_id", "employee_name", "salary"

//        boolean sql1 =stmnt.execute("CREATE TABLE employee(employee_id INT,employee_name VARCHAR(50),salary REAL)");
//        System.out.println("sql1 is :" +sql1);

        //execute () returns boolean value and can be used for DDL data definition language or Data Query Language
        //if it is used for DDL(create/update table) returns false
        //if it is used for  DQL (Select ...) returns true/false and gets ResultSet obj
        /*
          execute() method can be used in DDL(Data Definition Language --> Crate Table,
                Drop Table, Alter Table) and DQL (Data Query Language --> Select)
            1) If you use execute() method with DDL everytime you will get false.
            2) If you use execute() method with DQL  you will get false or true.
            If you get the resultSet object as return you will get true otherwise you will get false.
         */

        //TASK 2: add Varchar (20) column name "city" to employee table

//        String query= "ALTER TABLE employee ADD COLUMN city VARCHAR(20)";
//        boolean sql2 =   stmnt.execute(query);
//        System.out.println(sql2);

        //TASK 3: Delete employee table from SCHEMA

        String query1= "DROP TABLE employee";
        boolean sql3=  stmnt.execute(query1);
        System.out.println(sql3);

        // 5 step  close connection
        stmnt.close();
        con.close();


    }
}

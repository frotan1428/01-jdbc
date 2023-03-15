import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException {
        // after jDBC 4.0 or after JDK 7 no need to use Class.ForName() in side of your class.
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev_paractice","dev_user","dev_pass");
        // 3  create a statements // to execute Sql query
        Statement stmnt=  con.createStatement();

        //TASK-1. GET/SELECT  "country_name" from countries table with ID between 5 and 10

        String query1= "SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
        boolean sql1= stmnt.execute(query1);
        System.out.println("sql1 :"+sql1);

        // to view the query result we use executeQuery();
         ResultSet resultSet=  stmnt.executeQuery(query1);
//         resultSet.next();
        while (resultSet.next()){
            System.out.println("country_name : "+ resultSet.getString("country_name"));
        }

        //TASK - 2: Get "phone_code" and "country_name" from countries table
        // / whose phone code is greater than 600
        System.out.println("======================Task -2 ===================");

        String query2= "SELECT phone_code, country_name FROM countries WHERE phone_code < 600";

        ResultSet resultSet2=  stmnt.executeQuery(query2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("phone_code")+
                    "--"+resultSet2.getString("country_name"));
        }


        //TASK - 3 : Display students' name and grade  grades are higher than passing grade of studnets ..
        System.out.println("--------------------- Task-3 ");

        String query3= "SELECT name, grade FROM students WHERE grade > (SELECT AVG(grade) FROM students)";
        ResultSet resultSet3= stmnt.executeQuery(query3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getString("name")+"----"+resultSet3.getInt("grade"));
        }
        /// continue from  here !!!!!!!

        stmnt.close();
        con.close();


    }
}

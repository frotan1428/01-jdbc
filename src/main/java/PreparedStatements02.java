import java.sql.*;

public class PreparedStatements02 {

    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev_paractice",
                "dev_user","dev_pass");
        // 3  create a statements // to execute Sql query
        Statement stmnt=  con.createStatement();
        System.out.println("************ TASK-1 **************");
        //TASK-1. Using preparedstatement, delete students who are from Mathematics department, from students table.
        String query="DELETE FROM students WHERE department LIKE ?";
        PreparedStatement prs1= con.prepareStatement(query);
        prs1.setString(1,"Psychology");
        int Updated=   prs1.executeUpdate();
        System.out.println(Updated);

        //TASK-2. Insert software engineering department using prepared statement into departments table.

        String query2="INSERT INTO departments  VALUES(?,?,?,?)";
        PreparedStatement prs2 =  con.prepareStatement(query2);
        prs2.setInt(1,6006);
        prs2.setString(2,"fronted dev");
        prs2.setInt(3,5000);
        prs2.setString(4,"North");
        int numOdInsertRows=  prs2.executeUpdate();
        System.out.println("NumOdInsertRows: " + numOdInsertRows);


        prs2.close();
        stmnt.close();
        con.close();

    }
}

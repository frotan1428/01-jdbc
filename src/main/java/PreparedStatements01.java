import java.sql.*;

public class PreparedStatements01 {


    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev_paractice",
                "dev_user","dev_pass");
        // 3  create a statements // to execute Sql query
        Statement stmnt=  con.createStatement();

        System.out.println("************** TASK-1 ***************");
        //TASK-1. Update pass_grade to 455 to  475 of Mathematics department (use PreparedStatement)
       // String query1="UPDATE departments  SET pass_grade =475 WHERE departments ILIKE 'Mathematics'";
        String query1="UPDATE departments  SET pass_grade =? WHERE department LIKE ?";
       PreparedStatement prs1= con.prepareStatement(query1);
       prs1.setInt(1,475);
       prs1.setString(2, "Mathematics");


       int numOfUpdatedRows =  prs1.executeUpdate();
        System.out.println("numOfUpdatedRows: " +numOfUpdatedRows);

        System.out.println("************** TASK-2 ***************");
        //TASK-2. Update pass_grade to 455 of Literature department (use PreparedStatement)

        prs1.setInt(1,600);
        prs1.setString(2, "Literature");

        int numOfUpdatedRows1 =  prs1.executeUpdate();
        System.out.println("numOfUpdatedRows: " +numOfUpdatedRows1);


    }
}

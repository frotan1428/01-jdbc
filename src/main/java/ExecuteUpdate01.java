import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev_paractice",
                "dev_user","dev_pass");
        // 3  create a statements // to execute Sql query
        Statement stmnt=  con.createStatement();
        //TASK-1. view All data from developers
        String query1="SELECT * FROM developers";
         ResultSet rs1 =stmnt.executeQuery(query1);
         while (rs1.next()){
             System.out.println(rs1.getInt("id")+"--"+
                     rs1.getString("name")+"--"
                     +rs1.getInt("salary")
                     +"--"+rs1.getString("prog_lang"));
         }

        System.out.println("--------------Tasks 2--------------------------------");
        //TASK-2. Update salaries of developers whose salaries are less than average salary with average salary
        String query2="UPDATE developers SET salary =(SELECT AVG(salary) FROM developers) " +
                "WHERE salary<(SELECT AVG(salary) FROM developers)";
        int updatedRow = stmnt.executeUpdate(query2);
        System.out.println("updatedRow: "+updatedRow);
        System.out.println("************** Task-3 **************");
//        //TASK-3. Add new developer to developers table

        String query3="INSERT INTO developers (name,salary,prog_lang) VALUES ('fatih',7000,'frontend')";
        int numberOfRecordAd=   stmnt.executeUpdate(query3);
        System.out.println("numberOfRecordAd : "+numberOfRecordAd);
//        System.out.println("************** Task-4 **************");
//        //TASK-4. DELETE row which has id of 14

        System.out.println("************** Task-4 **************");
        String query4="DELETE FROM developers WHERE prog_lang ILIKE 'jAva'";
        int numOfDeletedRecord =  stmnt.executeUpdate(query4);
        System.out.println("numOfDeletedRecord "+ numOfDeletedRecord);

        stmnt.close();
        con.close();




    }
}

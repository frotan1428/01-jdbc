import java.sql.*;

public class Transactions01 {
    public static void main(String[] args) throws Exception {
        // -- Create Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        // -- Create Statement (to execute sql queries)
        Statement stmnt = con.createStatement();

        //TASK-1. Transfer amount of 1000 from account_nu:1234 to account_nu:5678

        String query = "UPDATE accounts SET amount = amount + ? WHERE account_nu=?";

        PreparedStatement prs = con.prepareStatement(query);
        con.setAutoCommit(false); //i will commit myself

        try {
            prs.setDouble(1, -1000);
            prs.setInt(2, 1234);
            prs.executeUpdate();
            //suppose there is an issue in the system
            if (false) {
                throw new Exception();
            }
            prs.setDouble(1, 1000);
            prs.setInt(2, 5678);
            prs.executeUpdate();
            con.commit(); //makes data persistent
            prs.close();
            con.close();
        }catch (Exception e){
            con.rollback(); //cancel  all previous activities
        }




    }
}

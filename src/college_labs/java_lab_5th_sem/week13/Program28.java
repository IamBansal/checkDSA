package college_labs.java_lab_5th_sem.week13;

import java.sql.*;

public class Program28 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:swing");
            String sql = "INSERT INTO employee (name, rollNo, course, subject, marks) VALUES" + "('Akshat', 08, 'BTech', 'ITE', 90)";
            stmt = con.prepareStatement(sql);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("Record Added Into Table Successfully.");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getNextException());
            System.out.println("here");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getException());
            System.out.println("here 2");
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("here 3");
            }
        }
    }
}
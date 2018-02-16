package com.project.tutorial.jdbcdemo;

import static com.project.tutorial.jdbcdemo.ConnectionManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public JdbcDemo() {
        super();
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        try {
            Statement st = con.createStatement();
            //   con.setAutoCommit(false);

            StringBuilder sb = new StringBuilder("insert into t1 values");
            sb.append("('" + args[0] + "'" + "," + args[1] + ")");

            st.execute(sb.toString());
            st.execute("Update t1 set Name = 'Hiralal K' where Name ='Aboli'");
            ResultSet rs = st.executeQuery("Select * from t1");
            while (rs.next()) {

                System.out.println("Name : " + rs.getString("Name") + "ID : " + rs.getInt("ID"));
            }
            PreparedStatement ps = con.prepareStatement("Insert into t1 values(?,?)");
            ps.setString(1, "Shabot");
            ps.setInt(2, 45);
            ps.execute();
            PreparedStatement psUpd = con.prepareStatement("Update t1 set Name = ? where ID = ? ");
            psUpd.setString(1, "Shlokya");
            psUpd.setInt(2, 123);

            psUpd.execute();
            int x = 0;
            while (x < 4) {
                st.addBatch("insert into t1 values('Aboli'," + x + ")");
                x++;
            }
            st.addBatch("delete from t1 where ID= 123");
            int[] t = st.executeBatch();
            for (int i = 0; i < t.length; i++) {
                System.out.println(t[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

}

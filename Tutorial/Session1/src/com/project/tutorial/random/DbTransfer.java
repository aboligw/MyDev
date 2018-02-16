package com.project.tutorial.random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTransfer {
    //Connection instance for source & destination database
    Connection SourceCon;
    Connection DestCon;
    //
    public DbTransfer() //constructor
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Geting connection to source database
            SourceCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "vb", "vb");

            //Geting connection to destination database
            DestCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class not found" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error in geting connection" + e.getMessage());
        }
    }
    //**************************************************************************************************************
    void transferTable(String SourceTable, String DestTable) {
        try {
            //geting data from source table
            Statement SourceSelect = SourceCon.createStatement();
            ResultSet rs = SourceSelect.executeQuery("select * from " + SourceTable);

            //Result set metadata for source result set
            ResultSetMetaData rsm = rs.getMetaData();

            //creating dynamic query to insert into destination table
            String DestQuery = "insert into " + DestTable + " values(";
            for (int i = 1; i < rsm.getColumnCount(); i++)
                DestQuery += "?, ";
            DestQuery += "?)";

            PreparedStatement InsertIntoDest = DestCon.prepareStatement(DestQuery);

            //transfer of each row in source table
            while (rs.next()) {
                //checking each column type while creating query
                for (int i = 1; i <= rsm.getColumnCount(); i++) {

                    //geting column type
                    String cType = rsm.getColumnTypeName(i);
                    if (cType.contains("INT") || cType.contains("SMALLINT") || cType.contains("NUMERIC") ||
                        cType.contains("DECIMAL") || cType.contains("NUMBER"))
                        InsertIntoDest.setInt(i, rs.getInt(i));
                    if (cType.contains("CHAR"))
                        InsertIntoDest.setString(i, rs.getString(i));
                    if (cType.contains("DATE"))
                        InsertIntoDest.setDate(i, rs.getDate(i));
                    if (cType.contains("BLOB"))
                        InsertIntoDest.setBlob(i, rs.getBlob(i));
                    if (cType.contains("BINARY"))
                        InsertIntoDest.setBoolean(i, rs.getBoolean(i));
                    if (cType.contains("FLOAT"))
                        InsertIntoDest.setFloat(i, rs.getFloat(i));

                }
                //Excuting insert query in destination table
                InsertIntoDest.executeUpdate();
            }
            System.out.println("Table Transfered");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error in transfering table" + e.getMessage());
        } finally {
            try {
                //closing connections
                SourceCon.close();
                DestCon.close();
            } catch (SQLException e) {

                System.out.println("Error in closing connection" + e.getMessage());
            }

        }

    }
    //**************************************************************************************************************
    public static void main(String[] args) {
        DbTransfer databaseTransfer = new DbTransfer();

        //Transfering tables from source to destination database assuming their dependancy.
        databaseTransfer.transferTable("student", "student");
        /*databaseTransfer.transferTable("sourceemp", "destemp");
        databaseTransfer.transferTable("sourcecompetancy", "destcompetancy");
        databaseTransfer.transferTable("sourcepractice", "destpractice");
*/
    }

}

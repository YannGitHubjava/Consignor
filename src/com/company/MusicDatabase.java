package com.company;

import javax.swing.*;
import java.sql.*;

public class MusicDatabase {
//    private static String driver ="org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    private static String DbName = "VinylRecord";


    private static final String USER = "username";
    private static final String PASS = "pasword";

    public  final static String MUSIC_TABLE_NAME = "musicRecords";
    public final static String CON_NAME = "consignor";
    public final static String CON_PHONE = "cellphone";
    public final static String ARTIST_NAME = "artist";


    private static MusicDataModel musicDataModel;

    static Connection con = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static PreparedStatement psInsert = null;


    public static void main(String[] args) {
        // write your code here

        setup();
        loadAllRecords();


        // Start GUI

        MusicStore tableGUI = new MusicStore(musicDataModel);



        // set up the connection to the database.
    }

    public static void setup() {

        try {

            con = DriverManager.getConnection(protocol + DbName + ";create=true", USER, PASS);
            statement = con.createStatement();


            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


            // creating a table

            String createRecordTable = "CREATE TABLE " + MUSIC_TABLE_NAME + " ( " + CON_NAME + " varchar(30), " + CON_PHONE + " varchar(30), " + ARTIST_NAME + " varchar(30)) ";
            statement.executeUpdate(createRecordTable);
            System.out.println("The database is created");


            //Add some data to the table

            String addTest1 = "INSERT INTO musicRecords VALUES ('Rashidi', '612-245-1567', 'Jhon Legend')";
            statement.executeUpdate(addTest1);


            String[] consignorName = {"Yannick", "Idrissa"};
            String[] phone = {"612-242-5794", "612-245-5733"};
            String[] artist = {"Usher", "Rihana"};

            String prepStatInsert = "INSERT INTO  musicRecords VALUES (?,?,?)";
            psInsert = con.prepareStatement(prepStatInsert);

            for (int i = 0; i < consignorName.length; i++) {

                psInsert.setString(1, consignorName[i]);
                psInsert.setString(2, phone[i]);
                psInsert.setString(3, artist[i]);
                psInsert.executeUpdate();
            }

            System.out.println("Added data");

        } catch (SQLException se) {
            System.out.println("The Music table probably already exist");
            System.out.println(se);
        }

    }

     public static void loadAllRecords () {


         try {

             if (rs != null) {
                 rs.close();
             }
             //let display and fetch some data

             String fetchRecords = "SELECT * FROM musicRecords";
             rs = statement.executeQuery(fetchRecords);





         } catch (SQLException e) {
             System.out.println("Error loading or reloading music records");
             System.out.println(e);
         }
     }

//            String deleteConsignor = "DROP TABLE Consignor";
//            statement.executeUpdate(deleteConsignor);
//            System.out.println("The table was deleted");

    public static void shutdown() {


            // catch all the exception h

        try {

            if (rs != null) {
                rs.close();
                System.out.println("Result closed");
            }
        } catch (SQLException se) {
            se.printStackTrace();

        }

        try {

            if (statement != null) {
                statement.close();
                System.out.println("Statement closed");
            }
        } catch (SQLException se) {
            se.printStackTrace();

        }

        try {

            if (psInsert != null) {
                psInsert.close();
                System.out.println("Statement closed");
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }


        try {

            if (con != null) {
                con.close();
                System.out.println("Connection Closed");

            }
        } catch (SQLException se) {
            se.printStackTrace();


        }


        System.out.println("End of program ");


    }
}


package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class MusicDatabase {
//    private static String driver ="org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    private static String DbName = "VinylRecord2";


    private static final String USER = "username";
    private static final String PASS = "pasword";


    public final static String CON_TABLE = "conRecords";
    public final static String CON_NAME = "consignor";
    public final static String CON_PHONE = "cellphone";
    public final static String MONEY_OWED = "money_owed";
    public final static String ARTIST = "artist";
    public final static String TITLE = "title";
    public final static String PRICE = "price";
    public final static String DATE = "date";
    public static  java.util.Date Date = new java.util.Date();
    public static ArrayList <Integer> idRecordList = new ArrayList<Integer>();;


    public static double money;



    public final static String ID = "id";
    public final static String RECORD_ID = "rID";

    private static MusicStore music;
    private static MusicDataModel musicDataModel;
    private static RecordView recordView;
    private static MoneyOwedView moneyInfo;
    private static BargainList bargain;
//    private static MusicDataModel searchMusicDataModel;

    static Connection con = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static ResultSet ls;
    static PreparedStatement psInsert = null;


    public static void main(String[] args) {
        // write your code here

        setup();
        loadAllRecords();

//        searchRecords();

        musicDataModel = new MusicDataModel(rs);


        // Start GUI

        music = new MusicStore(musicDataModel);

    }




        // set up the connection to the database.


    public static void setup() {

        try {

            con = DriverManager.getConnection(protocol + DbName + ";create=true", USER, PASS);


            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


            // creating a table

//            String createRecordTable = "CREATE TABLE " + MUSIC_TABLE_NAME + " ( " + CON_NAME + " varchar(30), " + CON_PHONE + " varchar(30), " + ARTIST_NAME + " varchar(30)) ";
//            String createRecordTableSQL = "CREATE TABLE records ( " + RECORD_ID + " int, " + ARTIST + " varchar(30), " + TITLE + " varchar(30)," + PRICE + " double, " + ID + " int, " + DATE + " date)";
            String createConsTableSQL = "CREATE TABLE " + CON_TABLE + " ( id int, " + CON_NAME + " varchar(30), " + CON_PHONE + " varchar(30), money_owed double," + RECORD_ID + " int, " +  ARTIST + " varchar(30), " + TITLE + " varchar(30)," + PRICE + " double, " + DATE + " Date)";
//            String createConsTableSQL = "CREATE TABLE consigners (id int, name varchar(30), phone varchar(30), money_owed double)";
            String dropTable = "DROP TABLE " + CON_TABLE;
            String dropRecord = "DROP TABLE records";


            try {
//                System.out.println("The database is created");
//                statement.executeUpdate(createRecordTableSQL);
//                System.out.println("Created record table");
                statement.executeUpdate(createConsTableSQL);
                System.out.println("Created consigner table");
            } catch (SQLException e) {
                System.out.println("Consignor tables already exist");
                statement.executeUpdate(dropTable);
                statement.executeUpdate(createConsTableSQL);
//                System.out.println("Records table already exist");
//                statement.executeUpdate(dropRecord);
//                statement.executeUpdate(createRecordTableSQL);


            }

        } catch (Exception e) {
            e.printStackTrace();


        }


            try {
                //Add some data to the table

                String addRecord1 = "INSERT INTO conRecords VALUES (3, 'Bob', '6121231234', 4.50, 1 , 'Led Zep 2', 'Led Zeppelin', 4.50, '2014-04-03' )" ;
                statement.executeUpdate(addRecord1);
                String addRecord2 = "INSERT INTO conRecords VALUES (3, 'Bob', '6121231234', 4.50, 2 , 'Led Zep 3', 'Led Zeppelin', 4.50, '2014-04-05' )" ;
                statement.executeUpdate(addRecord2);
                String addRecord3 = "INSERT INTO conRecords VALUES (3, 'Bob', '6121231234', 4.50, 3 , 'Led Zep 4', 'Led Zeppelin', 4.25, '2014-02-03' )" ;
                statement.executeUpdate(addRecord3);
                String addRecord4 = "INSERT INTO conRecords VALUES (4, 'Diana', '65113413234', 67.50, 4 , 'White Album', 'Beatles', 5.00, '2014-05-03' )" ;
                statement.executeUpdate(addRecord4);
                String addRecord5 = "INSERT INTO conRecords VALUES (4, 'Diana', '65113413234', 67.50, 5 , 'Blue Album', 'Beatles', 3.50, '2014-05-03' )" ;
                statement.executeUpdate(addRecord5);
//                System.out.println("Added test record data to database");
//                String addConsigner1 = "INSERT INTO conRecords VALUES (3, 'Bob', '6121231234', 4.50)";
//                statement.executeUpdate(addConsigner1);
//                String addConsigner2 = "INSERT INTO conRecords VALUES (4, 'Diana', '65113413234', 67.50)";
//                statement.executeUpdate(addConsigner2);
                System.out.println("Added test consigner data to database");


//                String addTest1 = "INSERT INTO musicRecords VALUES ('Rashidi', '612-245-1567', 'Jhon Legend')";
//                statement.executeUpdate(addTest1);
//
//
//                String[] consignorName = {"Yannick", "Idrissa"};
//                String[] phone = {"612-242-5794", "612-245-5733"};
//                String[] artist = {"Usher", "Rihana"};
//
//                String prepStatInsert = "INSERT INTO  musicRecords VALUES (?,?,?)";
//                psInsert = con.prepareStatement(prepStatInsert);
//
//                for (int i = 0; i < consignorName.length; i++) {
//
//                    psInsert.setString(1, consignorName[i]);
//                    psInsert.setString(2, phone[i]);
//                    psInsert.setString(3, artist[i]);
//                    psInsert.executeUpdate();


                System.out.println("Added data");

            } catch (SQLException se) {
                System.out.println("Error inserting data to the table");
                System.out.println(se);
            }

        }

     public static void loadAllRecords () {


         try {

             if (rs != null) {
                 rs.close();
             }
             //let display and fetch some data


             String fetchRecords = "SELECT * FROM conRecords";

             rs = statement.executeQuery(fetchRecords);

            // let update the data if more data are added

             if (musicDataModel == null) {
                 musicDataModel = new MusicDataModel(rs);


             } else {
                 musicDataModel.updateResultSet(rs);
             }





         } catch (SQLException e) {
             System.out.println("Error loading or reloading music records");
             System.out.println(e);
         }
     }

    public static void searchRecords () {


        try {

            if (ls != null) {
                ls.close();
            }
            //let display and fetch some data



            String test1 = MusicStore.getValue;

            int test2 = Integer.parseInt(test1);


            //Fetch search data

            String searchRecords = "SELECT * FROM conRecords WHERE id = " + test2 + " ";


            ls = statement.executeQuery(searchRecords);
            System.out.println("Searching for " + test2);

            while (ls.next()) {



                int id = ls.getInt("id");
                String name = ls.getString(CON_NAME);
                String phone = ls.getString(CON_PHONE);
                double money = ls.getDouble("money_owed");
                int record = ls.getInt(RECORD_ID);
                String artist = ls.getString(ARTIST);
                String title = ls.getString(TITLE);
                double price = ls.getDouble(PRICE);
                Date  = ls.getDate(DATE);

                System.out.println( id + "; " + name  + "; " + phone  + "; " + money  + "; " + record + "; " + artist  + "; " + title  + "; " + price  + "; " + Date);


            }




            //TODO display the search result on the same window

            if (musicDataModel != null) {



                MusicDataModel musicDataModel1 = new MusicDataModel(ls);




                recordView = new RecordView (musicDataModel1);




            }



//                musicDataModel.updateResultSet(ls);
//
//
//            } else {
//                musicDataModel.updateResultSet(ls);
//            }





        } catch (SQLException e) {
            System.out.println("Error loading or reloading music records");
            System.out.println(e);
        }
    }

//            String deleteConsignor = "DROP TABLE Consignor";
//            statement.executeUpdate(deleteConsignor);
//            System.out.println("The table was deleted");


    //TODO compute what you owe the cosigner
    public static void moneyMade () {

        try {

            if (ls != null) {
                ls.close();
            }
            String totalMoneyOwed = "SELECT SUM(money_owed) AS TotalMoneyOwed FROM conRecords";

            ls = statement.executeQuery(totalMoneyOwed);
            while (ls.next()) {
                money = ls.getDouble("TotalMoneyOwed");
                System.out.println("My money" + money);
            }


            moneyInfo = new MoneyOwedView();



        } catch (SQLException se) {
            System.out.println("Hello" + se.getStackTrace());


        }
    }

    public static double getMoneyOwed () {

        return money;
    }





    //TODO Display error Message for multiple copies of a record
    public static void multipleCopies() {

        try {

            if ( ls != null) {
                ls.close();
            }
            String idRecord = "SELECT rID FROM conRecords" ;

            ResultSet ns = statement.executeQuery(idRecord);


            while (ns.next()) {
                int recordID = ns.getInt("rID");
                idRecordList.add(recordID);
                System.out.println("Adding VAlues" + recordID);
            }



//            loadAllRecords();




        } catch (SQLException se) {
            System.out.println("Hi" + se.getStackTrace());

        }




    }



    public static void closeResult() {
        try {
            rs.close();

        }
        catch (SQLException se) {
            se.printStackTrace();

        }
    }




    //TODO send data to bargain basement after 30 days

    public static void countingDays () {


        try {
            if (rs != null) {
                rs.close();
            }
            String dateDifference = "SELECT * FROM conRecords WHERE CURRENT_DATE = 30";
            rs = statement.executeQuery(dateDifference);

            while (rs.next()) {
                Date = rs.getDate("date");

                System.out.println(" less than 30 days" + Date);

            }

            if (musicDataModel != null) {

                MusicDataModel musicDataModelBag = new MusicDataModel(rs);

                bargain = new BargainList(musicDataModelBag);




            }

        }

        catch (SQLException se) {
            System.out.println("countingDays" + se);
        }

    }



    //TODO Send the record to the thrift store

    public static void thriftStore () {}




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

            if (ls != null) {
                ls.close();
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

    public static MusicStore getMusic() {
        return music;
    }

    public static RecordView getRecordView() {
        return recordView;
    }



    public static MoneyOwedView getMoneyView() {
        return moneyInfo;
    }
}


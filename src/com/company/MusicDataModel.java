package com.company;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Yanirash on 4/28/2015.
 */
public class MusicDataModel extends AbstractTableModel {

    private int rowCount = 0;
    private int colCount = 0;
    ResultSet resultSet;

    MusicDataModel(ResultSet rs) {
        this.resultSet = rs;
        setup();

    }
    // Setup the information that will appear on the GUI

    private void setup () {
        countRows();

        try {
            colCount = resultSet.getMetaData().getColumnCount();

        } catch (SQLException se) {
            System.out.println("Error counting columns" + se);
        }
    }


    //Update the resultset after adding new data

    public void updateResultSet (ResultSet newRS) {
        resultSet = newRS;
        setup();
    }

    //Method that allows to use the AbstractTableModel

    private void countRows() {

        rowCount = 0;
        try {
            //Move cursor to the start.

            resultSet.beforeFirst();
            // next() method moves the cursor forward one row and returns true if there is another row ahead

            while (resultSet.next()) {
                rowCount ++;
            }

            resultSet.beforeFirst();


        } catch (SQLException se) {
            System.out.println("Error counting rows " + se);
        }
    }

    @Override
    public int getRowCount() {
        countRows();
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }


    @Override
    public Object getValueAt (int row, int col) {
        try {
            resultSet.absolute(row+1);
            Object o = resultSet.getObject(col+1);
            return o.toString();
        } catch (SQLException se) {
            System.out.println("HERE" + se);
            return se.toString();

        }
    }



    public boolean insertRow(int id, String consignor, String num, double money,int recordID, String artist, String title, double price, String date) {

        try {
            //Move to insert row, insert the appropriate data in each column, insert the row, move cursor back to where it was before we started
            resultSet.moveToInsertRow();
            resultSet.updateInt(MusicDatabase.ID, id);
            resultSet.updateString(MusicDatabase.CON_NAME, consignor);
            resultSet.updateString(MusicDatabase.CON_PHONE, num);
            resultSet.updateDouble(MusicDatabase.MONEY_OWED, money);
            resultSet.updateInt(MusicDatabase.RECORD_ID,recordID);
            resultSet.updateString(MusicDatabase.ARTIST, artist);
            resultSet.updateString(MusicDatabase.TITLE, title);
            resultSet.updateDouble(MusicDatabase.PRICE, price);
            resultSet.updateString(MusicDatabase.DATE, date);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            fireTableDataChanged();
            //This change goes to DB but is *not* reflected in this result set
            //So need to close and re-open result set to see latest data
            //Return true to the calling method so we know that the ResultSet
            //was successfully updated, and it can request a new ResultSet for this tablemodel.
            return true;


        } catch (SQLException e) {
            System.out.println("Error adding row");
            System.out.println(e);
            return false;
        }

    }
    // Set columns titles

    @Override
    public String getColumnName(int col){
        //Get from ResultSet metadata, which contains the database column names
        //TODO translate DB column names into something nicer for display, so "YEAR_RELEASED" becomes "Year Released"
        try {
            return resultSet.getMetaData().getColumnName(col + 1);
        } catch (SQLException se) {
            System.out.println("Error fetching column names" + se);
            return "?";
        }
    }

}

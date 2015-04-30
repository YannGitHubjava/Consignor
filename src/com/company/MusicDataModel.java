package com.company;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yanirash on 4/28/2015.
 */
public class MusicDataModel extends AbstractTableModel {

    private int rowCount = 0;
    private int colCount;
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

//            colCount = resultSet.getMetaData().getColumnCount();

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

}

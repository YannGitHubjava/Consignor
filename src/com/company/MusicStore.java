package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.util.Date;
/**
 * Created by Yanirash on 4/23/2015.
 */
public class MusicStore extends JFrame implements WindowListener{
    private JPanel rootpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton firstUseButton;
    private JTable table1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField3;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField10;
    private JButton Search;
    private JComboBox actionSelect;
    private JButton goButton;

    public static String getValue;
    public static Date date = new Date();


    MusicStore (final MusicDataModel musicDataTableModel) {



        setContentPane(rootpanel);
        pack();
        setTitle("Music Database Application");
        addWindowListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        final String MONEY_INFO = "Total Money Owed";
        final String BARGAIN_LIST = "Records 30 days old ";

        actionSelect.addItem(MONEY_INFO);
        actionSelect.addItem(BARGAIN_LIST);






        //TODO try to display the database on the GUI JTable

        // Setup JTable

        table1.setGridColor(Color.BLACK);
        table1.setModel(musicDataTableModel);
        table1.getColumnModel().getColumn(0).setWidth(400);

        //TODO

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        textField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        textField5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        textField7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

            }
        });
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        textField6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

            }
        });


        textField8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);



            }
        });




        textField10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        //TODO create add button, delete button, and other features that will query the table
        loginButton.addActionListener(new ActionListener() {
            @Override


            public void actionPerformed(ActionEvent e) {

                String id = textField4.getText();
                String consignor = textField1.getText();
                String conNum = textField2.getText();
                String artist = textField3.getText();
                String moneyOwed = textField5.getText();
                String recordId = textField7.getText();
                String title = textField6.getText();
                String price = textField8.getText();
//              date = textField9.getText();


                int id1 = Integer.parseInt(id);
                int recordId1 = Integer.parseInt(recordId);
                double moneyOwed1 = Double.parseDouble(moneyOwed);
                double price1 = Double.parseDouble(price);

                java.sql.Date currentDate = new java.sql.Date(date.getTime());


                while (id.) )





                while  (ViewController.CopyList().contains(recordId1)) {



                       String newValue = JOptionPane.showInputDialog(rootpanel, "Copy of the record is already in the database. Please enter a new one");

                        recordId1 = Integer.parseInt(newValue);





                }



                ViewController.resetResultSet();

//              System.out.println("Adding " + consignor + " " + conNum + " " + artist);
                boolean insertedRow = musicDataTableModel.insertRow(id1, consignor, conNum, moneyOwed1, recordId1, artist, title, price1,currentDate);
                if (insertedRow) {

                    MusicDatabase.loadAllRecords();
                } else {
                    JOptionPane.showMessageDialog(rootpanel, "Error adding new data");
                }



            }


        });


        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getValue = textField10.getText();
                MusicDatabase.searchRecords();
                ViewController.hideMusicStore();
//                ViewController.destroyRecordView();
//                ViewController.getSum();

//                ViewController.getSum();
//                table1.setModel(musicDataTableModel);

            }
        });
        firstUseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.shutDownGUI();

            }
        });


        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actionChoice = (String)actionSelect.getSelectedItem();

                if (actionChoice == MONEY_INFO) {
                    MusicDatabase.moneyMade();
                    ViewController.hideMusicStore();
                }

                if (actionChoice == BARGAIN_LIST) {
                    MusicDatabase.countingDays();
                    ViewController.hideMusicStore();
                }
            }
        });
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("closing");
    }


    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}



    }

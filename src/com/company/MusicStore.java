package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowListener;
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
//    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField3;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton Search;

    public static String getValue;


    MusicStore (final MusicDataModel musicDataTableModel) {
        boolean firstTime = true;
        while  (firstTime) {

            setContentPane(rootpanel);
            pack();
            setTitle("Music Database Application");
            addWindowListener(this);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            firstTime = false;
            break;


        }


        //TODO try to display the database on the GUI JTable

        // Setup JTable

        table1.setGridColor(Color.BLACK);
        table1.setModel(musicDataTableModel);
        table1.getColumnModel().getColumn(0).setWidth(400);

        //TODO get user input and store in database

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
        firstUseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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


        textField9.addKeyListener(new KeyAdapter() {
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
                String date = textField9.getText();


                int id1 = Integer.parseInt(id);
                int recordId1 = Integer.parseInt(recordId);
                double moneyOwed1 = Double.parseDouble(moneyOwed);
                double price1 = Double.parseDouble(price);


//                System.out.println("Adding " + consignor + " " + conNum + " " + artist);
                boolean insertedRow = musicDataTableModel.insertRow(id1,consignor, conNum,moneyOwed1,recordId1,artist,title,price1,date);
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





//                table1.setModel(musicDataTableModel);

            }
        });
        firstUseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusicDatabase.shutdown();
                System.exit(0);
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

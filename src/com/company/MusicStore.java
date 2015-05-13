package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.util.Date;
/**
 * Created by Yanirash on 4/23/2015.
 * Program that create a Database
 * Let user add their own data
 * Compute the money owed by the consignor
 * Still need more work : Bargain List and Thrift Store
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
    private JLabel myID;
    private JLabel myNumb;
    private JLabel myName;
    private JLabel myMoney;
    private JLabel myRecord;
    private JLabel myArtist;
    private JLabel myTitle;
    private JLabel myPrice;

    public static String getValue;
    public static int id1;
    public static int recordId1;
    public static double moneyOwed1;
    public static double price1;
    public static String consignor1;

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




                java.sql.Date currentDate = new java.sql.Date(date.getTime());



                //Error Handling and Validation

                //Validation of id

                try {
                    id1 = Integer.parseInt(id);
                }

                catch (NumberFormatException ne){
                    String corrID = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myID.getText());
                    while (true) {
                        try {
                            id1 = Integer.parseInt(corrID);
                            break;
                        } catch (NumberFormatException se) {
                            corrID = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myID.getText());

                        }
                    }
                }



                //Validation of record ID

                try {
                    recordId1 = Integer.parseInt(recordId);
                }

                catch (NumberFormatException ne) {
                    String check1 = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myRecord.getText());
                    while (true) {
                        try {
                            recordId1 = Integer.parseInt(check1);
                            break;
                        } catch (NumberFormatException se) {
                            check1 = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myRecord.getText());

                        }
                    }
                }



                //Validation of money owed


                try {
                    moneyOwed1 = Double.parseDouble(moneyOwed);
                }

                catch (NumberFormatException le) {
                    String check2 = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myMoney.getText());
                    while (true) {
                        try {
                            moneyOwed1 = Double.parseDouble(check2);
                            break;
                        } catch (NumberFormatException se) {
                            check2 = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myMoney.getText());

                        }
                    }
                }


                //Validation of Price

                try {
                    price1 = Double.parseDouble(price);
                }

                catch (NumberFormatException xe) {
                    String corrID = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myPrice.getText() );
                    while (true) {
                        try {
                            price1 = Double.parseDouble(corrID);
                            break;
                        } catch (NumberFormatException se) {
                            corrID = JOptionPane.showInputDialog(rootpanel, "Please enter a correct value for " + myPrice.getText());

                        }
                    }
                }




                //Validation of Consignor
                while (consignor.equals("") ) {
                    String test = JOptionPane.showInputDialog(null, myName.getText() +" field is empty!");
                    consignor = test;
                    }





                //Validation of Consignor Number







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

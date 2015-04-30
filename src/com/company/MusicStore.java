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


    MusicStore (MusicDataModel musicDataTableModel) {

        setContentPane(rootpanel);
        pack();
        setTitle("Music Database Application");
        addWindowListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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


        //TODO create add button, delete button, and other features that will query the table
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String conName = textField1.getText();
                String conNum = textField2.getText();


                JOptionPane.showMessageDialog(null, " your name " + conName +"\n" + " Your number " + conNum, " Create a Database" , 3);
            }
        });



        firstUseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 * Created by Yanirash on 5/8/2015.
 */
public class RecordView extends JFrame implements WindowListener {
    private JPanel rootpanel;
    private JTable table1;
    private JButton btnGoBack;
    private JButton saleRecordButton;
    ResultSet resultSet;
    Integer recordID;


    RecordView (final MusicDataModel musicDataTableModel) {

        super ("Record Result");
        setContentPane(rootpanel);
        pack();
        addWindowListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //TODO try to display the database on the GUI JTable

        // Setup JTable

        table1.setGridColor(Color.BLACK);
        table1.setModel(musicDataTableModel);
        table1.getColumnModel().getColumn(0).setWidth(100);








        btnGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.showMusicStore();
                ViewController.destroyRecordView();
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


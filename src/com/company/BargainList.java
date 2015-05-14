package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by Yanirash on 5/12/2015.
 */
public class BargainList extends JFrame implements WindowListener  {
    private JTable table1;
    private JPanel rootpanel;
    private JButton goBackButton;
    private JLabel myText;
    private JButton Send;
    public static String myTextUpdate = null;
    public static String myButtonUpdate = null;


    BargainList (MusicDataModel musicDataTableModel) {

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
    table1.getColumnModel().getColumn(0).setWidth(400);

    //Setting the JLabel
        if (myTextUpdate != null) {

            myText.setText(myTextUpdate);

            myTextUpdate = null;

        }

        if (myButtonUpdate != null) {
            Send.setText(myButtonUpdate);
        }




//        rootpanel.add(new JScrollPane(textArea1));



    goBackButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewController.showMusicStore();
            ViewController.destroyBargain();
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


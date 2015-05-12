package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowListener;

/**
 * Created by Yanirash on 5/9/2015.
 */
public class MoneyOwedView extends JFrame  {
    private JTextArea textArea1;
    private JButton button1;
    private JPanel rootpanel;

    public MoneyOwedView() {

        super ("Money Owed info");
        setContentPane(rootpanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        double money = ViewController.getSum();
        textArea1.append("The Total amount of record in your store is  " + money  + "\n" +
                            "The Total money owed is " + money/2);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.showMusicStore();
                ViewController.destroyMoneyOwed();

            }
        });
    }
}

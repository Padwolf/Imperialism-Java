package com.padwolf.school.imperialism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * Created by 970098955 on 2/10/2016.
 */
public class Choices extends JPanel{
    File choices, choice;
    JPanel choosePane;
    BufferedReader in;
    PrintWriter ot;
    Frame frame;

    public Choices(Frame parent){
        System.out.println("Initializing 'Choices'");
        frame = parent;
        choices = new File("../choices.chs");
        choice = new File("../choice.chs");
        choosePane = new JPanel();
        choosePane.setLayout(null);
        choosePane.setBackground(Frame.BACKGROUND);
        setLayout(new BorderLayout());
        add(new JLabel(""));
        add(choosePane);
        if (!choices.exists())
        {
            try {
                choices.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!choice.exists())
        {
            try {
                choice.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in = new BufferedReader(new FileReader(choices));
            ot = new PrintWriter(new BufferedWriter(new FileWriter(choice)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        setBackground(Frame.BACKGROUND);
        setBorder(BorderFactory.createEtchedBorder());

        System.out.println("'Choices' Initialized");
    }

    public JPanel recreateChoosePane(int numOfChoices){
        JPanel op = new JPanel();
        op.setLayout(new GridLayout(1, numOfChoices));
        op.setBackground(Frame.BACKGROUND);

        return op;
    }

    public BufferedReader resetBuffer(BufferedReader br, File inputFile) throws FileNotFoundException{
        return new BufferedReader(new FileReader(inputFile));
    }

    public class Choose implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel){
                System.out.println(((JLabel) e.getSource()).getText());
                ot.println(((JLabel) e.getSource()).getText());
                ot.flush();
                frame.buttonPressed = true;

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() instanceof JLabel){
                ((JLabel) e.getSource()).setForeground(Frame.TEXT_SECONDARY);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() instanceof JLabel){
                ((JLabel) e.getSource()).setForeground(Frame.TEXT_FOREGROUND);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

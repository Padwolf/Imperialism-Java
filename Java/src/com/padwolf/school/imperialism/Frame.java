package com.padwolf.school.imperialism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

/**
 * Created by 970098955 on 2/1/2016.
 */
public class Frame extends JFrame {
    final Panel panel = new Panel();
    JLabel title, quit;
    static Color BACKGROUND, TEXT_FOREGROUND, TEXT_SECONDARY;
    private MouseListener mse = new Listen();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args){
        BACKGROUND = new Color (100, 100, 100);
        TEXT_SECONDARY = new Color(30, 30, 30);
        TEXT_FOREGROUND = new Color(0, 0, 0);
        new Frame();
    }

    public Frame(){
        System.out.println("Initializing Frame");
        System.out.println("Screen Size: " + Integer.toString(screenSize.width)
                + ", " + screenSize.height);
        setSize(getToolkit().getScreenSize());
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);

    }

    public class Panel extends JPanel {
        public Panel(){
            title = new JLabel("American Imperialism");
            quit = new JLabel("Quit");
            setBackground(BACKGROUND);
            setLayout(new BorderLayout());
            title.setFont(title.getFont().deriveFont(screenSize.width/21.34375f));
            quit.setFont(quit.getFont().deriveFont(48.0f));
            quit.setBackground(getBackground());
            quit.addMouseListener(mse);
            setBorder(BorderFactory.createEmptyBorder());
            add(title, BorderLayout.NORTH);
            add(quit, BorderLayout.SOUTH);
        }
    }

    private class Listen implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == quit){
                System.exit(0);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == quit){
                quit.setForeground(TEXT_SECONDARY);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() == quit){
                quit.setForeground(TEXT_FOREGROUND);
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
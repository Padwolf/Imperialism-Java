package com.padwolf.school.imperialism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.io.*;

/**
 * Created by 970098955 on 2/1/2016.
 */
public class Frame extends JFrame {
    final Panel panel;
    static JLabel title, quit;
    static Color BACKGROUND, TEXT_FOREGROUND, TEXT_SECONDARY;
    private static MouseListener mse;
    public  static Dimension screenSize;
    public boolean buttonPressed;
    PrintWriter ot;
    BufferedReader in;

    public Choices choices;

    public static void main(String[] args){
        BACKGROUND = new Color (100, 100, 100);
        TEXT_SECONDARY = new Color(30, 30, 30);
        TEXT_FOREGROUND = new Color(0, 0, 0);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        new Frame();
    }

    private boolean fileUpdatedFrom(String original) throws IOException {
        if (original == null) return true;
        in = choices.resetBuffer(in, choices.choices);
        String message = in.readLine();
        in.close();
        return !message.equals(original);
    }

    public Frame(){
        System.out.println("Initializing Frame");
        mse = new Listen();
        choices = new Choices(this);
        panel = new Panel();
        System.out.println("Screen Size: " + Integer.toString(screenSize.width)
                + ", " + screenSize.height);
        setSize(getToolkit().getScreenSize());
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        System.out.println("Frame Initialized. Making Visible");
        setVisible(true);
        System.out.println("Frame Visible");
        System.out.println();
        System.out.println();
        System.out.println();
        updateFrame();
    }

    void updateFrame(){
        System.out.println("Entering Frame Checking");
        buttonPressed = false;

        String line, lastMessage = null;
        JPanel choosePane = choices.choosePane;
        JLabel[] buttons;
        JLabel message;
        int numOfChoices;

        choosePane.setLayout(null);
        try {
            while (true) {
                if (fileUpdatedFrom(lastMessage)) {
                    buttonPressed = false;
                    System.out.println("File has been updated");
                    in = choices.resetBuffer(in, choices.choices);
                    line = in.readLine();
                    lastMessage = line;
                    choices.removeAll();
                    choices.revalidate();
                    if (line.equals("EOG")){
                        line = in.readLine();
                        message = new JLabel(line, JLabel.CENTER);
                        message.setForeground(TEXT_SECONDARY);
                        message.setFont(message.getFont().deriveFont(screenSize.width/30f));
                        JLabel endLabel = new JLabel("Game Over", JLabel.CENTER);
                        endLabel.setForeground(Color.BLACK);
                        endLabel.setFont(endLabel.getFont().deriveFont(screenSize.width/15.0f));
                        choices.add(message, BorderLayout.NORTH);
                        choices.add(endLabel, BorderLayout.CENTER);
                        break;
                    }
                    message = new JLabel(line, JLabel.CENTER);
                    message.setForeground(TEXT_SECONDARY);
                    message.setFont(message.getFont().deriveFont(screenSize.width/30f));
                    choices.add(message, BorderLayout.NORTH);
                    numOfChoices = 0;
                    in.close();
                    in = choices.resetBuffer(in, choices.choices);
                    in.readLine();
                    while (in.readLine() != null) {
                        numOfChoices++;
                    }
                    in.close();
                    in = choices.resetBuffer(in, choices.choices);
                    in.readLine();
                    choosePane = choices.recreateChoosePane(numOfChoices);
                    buttons = new JLabel[numOfChoices];
                    for (int i = 0; i < numOfChoices; i++) {
                        line = in.readLine();
                        buttons[i] = new JLabel(line, JLabel.CENTER);
                        buttons[i].setFont(buttons[i].getFont().deriveFont(screenSize.width/35f));
                        buttons[i].addMouseListener(mse);
                        System.out.println(buttons[i].getText());
                        choosePane.add(buttons[i]);
                    }
                    in.close();
                    choices.add(choosePane, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    System.out.println("Sleeping");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //while (!buttonPressed) {
                    //}
                    System.out.println("Waking Up");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Panel extends JPanel {
        public Panel(){
            System.out.println("Initializing Main Panel");
            title = new JLabel("American Imperialism", JLabel.CENTER);
            quit = new JLabel("Quit", JLabel.CENTER);
            setBackground(BACKGROUND);
            setLayout(new BorderLayout());
            title.setFont(title.getFont().deriveFont(screenSize.width/21.34375f));
            quit.setFont(quit.getFont().deriveFont(48.0f));
            quit.setBackground(getBackground());
            quit.addMouseListener(mse);
            setBorder(BorderFactory.createEmptyBorder());
            add(title, BorderLayout.NORTH);
            add(quit, BorderLayout.SOUTH);
            add(choices, BorderLayout.CENTER);
            System.out.println("Main Panel Initialized");
        }
    }

    private class Listen implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == quit){
                System.exit(0);
            } else if (e.getSource() instanceof JLabel){
                try {
                    ot = new PrintWriter(new BufferedWriter(new FileWriter(choices.choice)));
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                System.out.println(((JLabel) e.getSource()).getText());
                ot.println(((JLabel) e.getSource()).getText());
                ot.flush();
                ot.close();
                buttonPressed = true;

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
            if (e.getSource() == quit){
                quit.setForeground(TEXT_FOREGROUND);
            }
        }
    }
}
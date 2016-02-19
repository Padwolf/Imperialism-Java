package com.padwolf.school.imperialism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * American Imperialism crated by Patrick Duane and William Morlan for a school project.
 */
public class Frame extends JFrame {
    final Panel panel;
    static JLabel title, quit, start;
    static Color BACKGROUND, TEXT_FOREGROUND, TEXT_SECONDARY, TEXT_BUTTONS;
    private static MouseListener mse;
    public  static Dimension screenSize;
    int choiceNum;
    String[] lines;

    public Choices choices;

    public static void main(String[] args){
        BACKGROUND = new Color (100, 100, 100);
        TEXT_SECONDARY = new Color(30, 30, 30);
        TEXT_FOREGROUND = new Color(0, 0, 0);
        TEXT_BUTTONS = new Color(15, 15, 15);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        new Frame();
    }

    public Frame(){
        System.out.println("Initializing Frame");
        mse = new Listen();
        choiceNum = -1;
        choices = new Choices(this);
        System.out.println("Screen Size: " + Integer.toString(screenSize.width)
                + ", " + screenSize.height);
        setSize(getToolkit().getScreenSize());
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        start = new JLabel("Start", JLabel.CENTER);
        start.setFont(start.getFont().deriveFont(screenSize.width/12f));
        start.addMouseListener(mse);
        choices.add(start, BorderLayout.CENTER);
        choices.add(new JLabel("NOTE: Sometimes you have to click your option multiple times for it to respond.  If it doesn't work when you click it,  just keep clicking.", JLabel.CENTER), BorderLayout.SOUTH);

        panel = new Panel();
        add(panel);
        System.out.println("Frame Initialized. Making Visible");
        setVisible(true);
        System.out.println("Frame Visible");
        System.out.println();
        System.out.println("Initializing Files");
        System.out.println();
        System.out.println();
        lines = choices.discernFate("Start Over");
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
            }else if (e.getSource() instanceof JLabel){
                System.out.println(((JLabel) e.getSource()).getText());

                if (e.getSource() == start){
                    lines = choices.discernFate("Start Over");
                } else {
                    lines = choices.discernFate(((JLabel) e.getSource()).getText());
                }

                choices.removeAll();
                choices.revalidate();

                JLabel message;
                if (lines[0].equals("death")){
                    message = new JLabel("<html><p align=center>" + lines[1] + "</p></html>", JLabel.CENTER);
                    message.setFont(message.getFont().deriveFont(screenSize.width/30f));
                    message.setForeground(TEXT_SECONDARY);
                    choices.add(message, BorderLayout.NORTH);
                    JLabel go = new JLabel("Game Over", JLabel.CENTER);
                    go.setFont(go.getFont().deriveFont(screenSize.width/15f));
                    go.setForeground(Color.BLACK);
                    go.addMouseListener(mse);
                    choices.add(go);

                } else {
                    message = new JLabel("<html><p align=center>" + lines[0] + "</p></html>", JLabel.CENTER);
                    message.setFont(message.getFont().deriveFont(screenSize.width/30f));
                    message.setForeground(TEXT_SECONDARY);
                    choices.add(message, BorderLayout.NORTH);

                    JLabel[] buttons = new JLabel[lines.length - 1];
                    JPanel choosePane = choices.recreateChoosePane(buttons.length);
                    for (int i = 0; i < buttons.length; i++){
                        buttons[i] = new JLabel(lines[i+1], JLabel.CENTER);
                        buttons[i].setFont(buttons[i].getFont().deriveFont(screenSize.width/25f));
                        buttons[i].setForeground(TEXT_BUTTONS);
                        buttons[i].addMouseListener(mse);
                        choosePane.add(buttons[i]);
                    }

                    choices.add(choosePane, BorderLayout.CENTER);
                    choices.revalidate();
                    choices.repaint();
                }


            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == quit){
                quit.setForeground(TEXT_SECONDARY);
            } else if (e.getSource() instanceof JLabel){
                ((JLabel) e.getSource()).setForeground(Frame.TEXT_SECONDARY);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() == quit){
                quit.setForeground(TEXT_FOREGROUND);
            } else if (e.getSource() instanceof JLabel){
                ((JLabel) e.getSource()).setForeground(Frame.TEXT_FOREGROUND);
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
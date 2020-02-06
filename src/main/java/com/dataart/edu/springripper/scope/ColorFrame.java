package com.dataart.edu.springripper.scope;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Random;

public abstract class ColorFrame extends JFrame {

    public ColorFrame() throws HeadlessException {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(1000));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}

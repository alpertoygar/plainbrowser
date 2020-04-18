package main;

import logging.LoggerFactory;
import ui.Tab;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Plain Browser.");
        JFrame appFrame = getMainAppFrame();

        Tab p = getInitialTab();

        appFrame.add(p);
        appFrame.setVisible(true);
    }

    private static JFrame getMainAppFrame(){
        JFrame appFrame = new JFrame("Plain Browser");
        appFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return appFrame;
    }

    private static Tab getInitialTab(){
        return new Tab("First Tab");
    }
}

package main;

import ui.Tab;

import javax.swing.*;
import java.awt.*;

public class Startup {

    public static void main(String[] args) {
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

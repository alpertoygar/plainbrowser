package main;

import ui.Tab;

import javax.swing.*;
import java.awt.*;

public class Startup {

    public static void main(String[] args) {
        JFrame appFrame = new JFrame("Plain Browser");
        appFrame.setExtendedState(Frame.MAXIMIZED_BOTH);

        // create a panel to add buttons
        Tab p = new Tab("First Tab");

        // add panel to frame
        appFrame.add(p);

        appFrame.setVisible(true);
    }
}

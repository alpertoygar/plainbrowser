package ui;

import javax.swing.*;

public class Tab extends JPanel {

    private String title;
    private JLabel titleLabel;

    public Tab(String title) {
        this.title = title;
        createAndPlaceTitleLabel();

    }

    private void createAndPlaceTitleLabel(){
        createTitleLabel();
        placeTitleLabel();
    }

    private void createTitleLabel(){
        titleLabel = new JLabel();
        titleLabel.setText(title);
    }

    private void placeTitleLabel(){
        add(titleLabel);
    }
}

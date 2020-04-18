package ui;

import javax.swing.*;
import java.awt.*;

public class Tab extends JPanel {

    private String title;
    private JLabel titleLabel;
    private JTextArea content;

    public Tab(String title) {
        this.title = title;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createAndPlaceTitleLabel();
        createAndPlaceContent("Content");
    }

    private void createAndPlaceTitleLabel(){
        createTitleLabel();
        placeTitleLabel();
    }

    private void createAndPlaceContent(String content){
        createContent(content);
        placeContent();
    }

    private void createTitleLabel(){
        titleLabel = new JLabel();
        titleLabel.setPreferredSize(new Dimension(100, 30));
        titleLabel.setText(title);
    }

    private void placeTitleLabel(){
        add(titleLabel);
    }

    private void createContent(String content){
        this.content = new JTextArea();
        this.content.setLineWrap(true);
        this.content.setEditable(false);
        this.content.setText(content);
    }

    private void placeContent(){
        add(content);
    }

}

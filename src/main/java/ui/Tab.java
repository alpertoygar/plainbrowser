package ui;

import networking.Networking;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class Tab extends JPanel {

    private String title;
    private JLabel titleLabel;
    private JTextArea content;
    private JTextArea addressBar;

    public Tab(String title) {
        this.title = title;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createAndPlaceTitleLabel();
        createAndPlaceAddressBar();
        JButton goToUrl = new JButton("Go");
        goToUrl.addActionListener(actionEvent -> {
            try {
                String pageContent = Networking.doGetRequest(addressBar.getText());
                content.setText(pageContent);
                updateUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        add(goToUrl);
        createAndPlaceContent();
    }

    private void createAndPlaceTitleLabel(){
        createTitleLabel();
        placeTitleLabel();
    }

    private void createAndPlaceContent(){
        createContent("Please enter a URL and press Go");
        placeContent();
    }

    private void createAndPlaceAddressBar(){
        createAddressBar();
        placeAddressBar();
    }

    private void createTitleLabel(){
        titleLabel = new JLabel();
        titleLabel.setPreferredSize(new Dimension(100, 30));
        titleLabel.setText(title);
    }

    private void placeTitleLabel(){
        add(titleLabel);
    }

    private void createAddressBar(){
        addressBar = new JTextArea();
        addressBar.setMaximumSize(new Dimension(1900, 100));
        addressBar.setBorder(new LineBorder(Color.BLACK, 1));
        addressBar.setText("http://google.com");
    }

    private void placeAddressBar(){
        add(addressBar);
    }

    private void createContent(String content){
        this.content = new JTextArea();
        this.content.setEditable(false);
        this.content.setLineWrap(true);
        this.content.setText(content);
    }

    private void placeContent(){
        add(content);
    }
}

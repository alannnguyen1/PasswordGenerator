
import com.sun.source.tree.UsesTree;

import java.awt.*;
import javax.swing.*;


public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel reqLabel;
    private JLabel resultLabel;
    private JLabel passLen;
    private JCheckBox letterBox;
    private JCheckBox symbolBox;
    private JCheckBox numBox;
    private JCheckBox uppercaseBox;
    private JTextField textPassLen;
    private JTextField passResult;
    private JTextArea raterResult;
    private JButton generatorBtn;
    private JButton raterBtn;


    public void createGUI(){
        //Create frame
        frame = new JFrame("Password Generator");
        frame.setLocation(300,300);
        frame.setPreferredSize(new Dimension(300, 310));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        //add component
        //panel
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // label
        reqLabel = new JLabel("Choose requirements");
        reqLabel.setBounds(20,10,200,25);
        panel.add(reqLabel);

        //check box
        letterBox = new JCheckBox("Letter a-z");
        letterBox.setBounds(45, 35, 200, 25);
        panel.add(letterBox);

        symbolBox = new JCheckBox("Use symbol (@#$%%^...)");
        symbolBox.setBounds(45, 55, 200, 25);
        panel.add(symbolBox);

        numBox = new JCheckBox("Use number (1-9)");
        numBox.setBounds(45, 75, 200, 25);
        panel.add(numBox);

        uppercaseBox = new JCheckBox("Capitalize letters (A-Z) ");
        uppercaseBox.setBounds(45,95,200,25);
        panel.add(uppercaseBox);

        passLen = new JLabel("Length:");
        passLen.setBounds(55, 120, 50,25);
        panel.add(passLen);

        textPassLen = new JTextField(30);
        textPassLen.setBounds(105, 120, 70,25);
        panel.add(textPassLen);

        generatorBtn = new JButton("Generate");
        generatorBtn.setBounds(30, 150, 100, 30);
        panel.add(generatorBtn);

        raterBtn = new JButton(("Rate"));
        raterBtn.setBounds(150, 150, 100, 30);
        panel.add(raterBtn);

        resultLabel = new JLabel("Your generated password");
        resultLabel.setBounds(20, 170, 200, 30);
        panel.add(reqLabel);

        // Display generated password
        passResult = new JTextField(200);
        //user can type other passwords from here to rate their own password
        passResult.setText("Show password here");
        passResult.setBounds(10, 190, 280, 25);
        panel.add(passResult);

        //display rater result
        // get password from passResult text field to rate
        raterResult = new JTextArea(10, 100);
        raterResult.setText("Your password is: Weak/Strong \nTime to crack your pass word: 10 years");
        raterResult.setEnabled(false);
        raterResult.setBounds(10, 225, 280, 50);
        panel.add(raterResult);


        frame.setVisible(true);

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createGUI();
    }
}


import com.sun.source.tree.UsesTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.setPreferredSize(new Dimension(340, 340));
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
        letterBox.setBounds(65, 35, 200, 25);
        panel.add(letterBox);

        symbolBox = new JCheckBox("Use symbol (@#$%%^...)");
        symbolBox.setBounds(65, 55, 200, 25);
        panel.add(symbolBox);

        numBox = new JCheckBox("Use number (1-9)");
        numBox.setBounds(65, 75, 200, 25);
        panel.add(numBox);

        uppercaseBox = new JCheckBox("Capitalize letters (A-Z) ");
        uppercaseBox.setBounds(65,95,200,25);
        panel.add(uppercaseBox);

        passLen = new JLabel("Length:");
        passLen.setBounds(74, 120, 50,25);
        panel.add(passLen);

        textPassLen = new JTextField(30);
        textPassLen.setBounds(124, 120, 70,25);
        panel.add(textPassLen);

        resultLabel = new JLabel("Your generated password");
        resultLabel.setBounds(20, 170, 200, 30);
        panel.add(reqLabel);

        // Display generated password
        passResult = new JTextField(200);
        //user can type other passwords from here to rate their own password
        passResult.setText("Show password here");
        passResult.setBounds(10, 190, 320, 25);
        panel.add(passResult);

        //display rater result
        // get password from passResult text field to rate
        raterResult = new JTextArea(10, 100);
        raterResult.setEnabled(false);
        raterResult.setBounds(10, 225, 320, 80);
        panel.add(raterResult);

        generatorBtn = new JButton("Generate");
        generatorBtn.setBounds(55, 150, 100, 30);
        panel.add(generatorBtn);
        generatorBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String length = textPassLen.getText();
                int lengthPass;
                if (length.isEmpty()){
                    lengthPass = 0;
                }
                else{
                    lengthPass = Integer.parseInt(length);
                }

                boolean useLetter = letterBox.isSelected();
                boolean useSymbol = symbolBox.isSelected();
                boolean useNumb = numBox.isSelected();
                boolean useCap = uppercaseBox.isSelected();
                String pass = PasswordGenerator.generate(useLetter, useSymbol, useNumb, useCap, lengthPass);
                passResult.setText(pass);
            }
        });

        raterBtn = new JButton(("Rate"));
        raterBtn.setBounds(175, 150, 100, 30);
        panel.add(raterBtn);
        raterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = passResult.getText();
                String passRate = PasswordRater.rate(pass);
                String timeEst = PasswordRater.timeEstimationDictionary(pass);
                String bruteF;
                if(PasswordRater.bruteForce(pass).equals("Computational Infeasible")){
                    bruteF = "Computational Infeasible";
                }
                else{
                    bruteF = "Password can be cracked in "+ PasswordRater.bruteForce(pass);
                }
                raterResult.setText("");
                raterResult.setText(passRate + "\n" + timeEst + "\n" + bruteF);
                /*raterResult.append(passRate);
                raterResult.append("\n");
                raterResult.append(timeEst);
                raterResult.append("\n");
                raterResult.append("Password can be cracked in "+ bruteF);*/
            }
        });

        frame.setVisible(true);

    }

    public static void main(String[] args){
        GUI gui = new GUI();
        gui.createGUI();
    }


}

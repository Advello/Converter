import java.awt.Color;
import java.awt.event.*;
import java.util.Base64;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicEditorPaneUI;
import javax.swing.text.JTextComponent;

public class App {

    public static void main(String[] args) throws Exception {

        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        // combobox
        String choices[] = { "Base64/encode", "ascii", "Base64/decode" };
        JComboBox comboBox = new JComboBox(choices);
        comboBox.setBounds(190, 90, 70, 25);
        comboBox.setVisible(true);
        // textbox first one
        JTextField textField = new JTextField();
        textField.setBounds(120, 90, 70, 25);
        textField.setVisible(true);
        // textbox sec one
        JTextField jTextField = new JTextField();
        jTextField.setBounds(155, 160, 70, 25);
        jTextField.setVisible(true);
        // button
        JButton jButton = new JButton();
        jButton.setBackground(Color.GRAY);
        jButton.setVisible(true);
        jButton.setBounds(150, 120, 80, 30);
        jButton.setText("Convert");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ev) {
                if (textField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(jFrame, "You must enter something into the textbox",
                            "An error has occured", JOptionPane.WARNING_MESSAGE);
                } else if (textField.getText().length() != 0) {
                    if (comboBox.getSelectedItem() == "Base64/encode") {

                        String encoded = Base64.getEncoder().encodeToString(textField.getText().getBytes());
                        jTextField.setText(encoded);

                    }
                    if (comboBox.getSelectedItem() == "Base64/decode") {
                        try {
                        byte[] decodedBytes = Base64.getDecoder().decode(textField.getText().getBytes());
                        String s = new String(decodedBytes);
                        jTextField.setText(s);
                        }
                        catch(Exception e) {
                            JOptionPane.showMessageDialog(jFrame, "Could not find character for the input", "An erron has occured", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                    if (comboBox.getSelectedItem() == "ascii") {
                        try {
                        int asciiVal = Integer.parseInt(textField.getText());
                        String str = new Character((char)asciiVal).toString();
                        jTextField.setText(str);
                        }
                        catch (Exception e) {
                            
                        }
                    }

                }
            }
        });
        ///////////////////////////////////////////
        jFrame.add(textField);
        jFrame.add(jButton);
        jFrame.add(comboBox);
        jFrame.add(jTextField);
    }

}

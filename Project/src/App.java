import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class App {

    private static JFrame jFrame;
    private static JTextField jInputTextField;
    private static JTextField jOutputTextField;

    private static final String[] choices = {
            "Base64/encode",
            "ascii",
            "Base64/decode",
            "unicode"
    };

    public static void main(String[] args) {

        setupMainFrame();
        Encoder.setMainFrame(jFrame);

        JComboBox choicesComboBox = setupChoicesComboBox();

        setupInputTextBox();
        setupOutputTextBox();

        JButton jConvertButton = setupConvertButton();

        jConvertButton.addActionListener(actionEvent -> {

            if (jInputTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        jFrame, "You must enter something into the TextBox",
                        "An error has occurred", JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (choicesComboBox.getSelectedItem() == "Base64/encode") {
                String textToEncode = jInputTextField.getText();
                String textEncodedFromBase64 = Encoder.toBase64(textToEncode);
                jOutputTextField.setText(textEncodedFromBase64);

            }
            if (choicesComboBox.getSelectedItem() == "Base64/decode") {
                String textToDecode = jInputTextField.getText();
                String textDecodedFromBase64 = Decoder.fromBase64(textToDecode);
                jOutputTextField.setText(textDecodedFromBase64);

            }
            if (choicesComboBox.getSelectedItem() == "ascii") {
                char charFromAscii = getCharacterByAsciiValue();
                jOutputTextField.setText(Character.toString(charFromAscii));
            }
            if (choicesComboBox.getSelectedItem() == "unicode") {
                String textToEncode = jInputTextField.getText();
                String textEncodedFromUnicode = Encoder.toUnicode(textToEncode);
                jOutputTextField.setText(textEncodedFromUnicode);
            }

        });

        jFrame.add(jConvertButton);
        jFrame.add(choicesComboBox);
        jFrame.add(jInputTextField);
        jFrame.add(jOutputTextField);
    }

    private static void setupOutputTextBox() {
        jOutputTextField = new JTextField();
        jOutputTextField.setBounds(155, 160, 70, 25);
        jOutputTextField.setVisible(true);
    }

    private static void setupInputTextBox() {
        jInputTextField = new JTextField();
        jInputTextField.setBounds(120, 90, 70, 25);
        jInputTextField.setVisible(true);
    }

    private static void setupMainFrame() {
        jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
    }

    private static JComboBox setupChoicesComboBox() {
        JComboBox choicesComboBox = new JComboBox(choices);
        choicesComboBox.setBounds(190, 90, 70, 25);
        choicesComboBox.setVisible(true);
        return choicesComboBox;
    }

    private static JButton setupConvertButton() {
        JButton jButton = new JButton();
        jButton.setBackground(Color.GRAY);
        jButton.setVisible(true);
        jButton.setBounds(150, 120, 80, 30);
        jButton.setText("Convert");
        return jButton;
    }

    private static char getCharacterByAsciiValue() {

        int asciiVal = 0;

        try {
            asciiVal = Integer.parseInt(jInputTextField.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jFrame, "Unable to convert, input must be integer",
                                    "An error has occured", JOptionPane.INFORMATION_MESSAGE);
        }

        return (char) asciiVal;
    }

}


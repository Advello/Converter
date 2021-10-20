import javax.swing.*;
import java.util.Base64;

public class Encoder {

    private static JFrame mainFrame;

    public static void setMainFrame(JFrame jFrame) {
        mainFrame = jFrame;
    }

    public static String toBase64(String textToEncode) {
        String encodedText = "";

        try {
            encodedText = Base64.getEncoder().encodeToString(textToEncode.getBytes());
        }
        catch (Exception e) {
            throwExceptionWithMessage("Unable to convert", "An error has occurred");
        }

        return encodedText;
    }

    public static String toUnicode(String textToEncode) {

        StringBuilder encodedStringBuilder = new StringBuilder();

        try {
            String str = textToEncode.split(" ")[0];
            str = str.replace("\\", "");
            String[] arr = str.split("u");

            for (int i = 1; i < arr.length; i++) {
                int idk = Integer.parseInt(arr[i], 16);
                encodedStringBuilder.append((char) idk);
            }
        }
        catch (Exception e) {
            throwExceptionWithMessage("Unable to convert", "An error has occurred");
        }

        return encodedStringBuilder.toString();
    }

    private static void throwExceptionWithMessage(String errorMessage, String errorTitle) {
        JOptionPane.showMessageDialog(
                mainFrame, errorMessage, errorTitle,JOptionPane.INFORMATION_MESSAGE
        );
    }
}


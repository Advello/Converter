import java.util.Base64;

public class Decoder {
    public static String fromBase64(String textToDecode) {
        byte[] decodedBytes = Base64.getDecoder().decode(textToDecode.getBytes());
        return new String(decodedBytes);
    }
}

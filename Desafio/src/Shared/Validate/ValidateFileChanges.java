package Shared.Validate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateFileChanges {

    private static Map<String,String> mapMD5 = new HashMap<String,String>();
    public static boolean hasChanged(String filename, List<String> content){
        String msgDecode="";
        try {
            byte[] bytesOfMessage = content.toString().getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            msgDecode = toHexString(thedigest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(mapMD5.get(filename) != null && msgDecode.equals(mapMD5.get(filename))) {
            return false;
        }
        mapMD5.put(filename, msgDecode);
        return true;
    }
    public static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

}

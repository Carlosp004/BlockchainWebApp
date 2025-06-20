package util;

import java.security.MessageDigest;

public class SHA256Util {

    public static String aplicarSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al aplicar SHA-256: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String ppassSHA512 = SHA256Util.aplicarSHA256("1238");
        System.out.println(ppassSHA512);
    }
}

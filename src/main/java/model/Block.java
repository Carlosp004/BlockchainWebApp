package model;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Block {
    private int index;
    private String data;
    private String previousHash;
    private String hash;
    private long nonce;
    private String timestamp;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String input = index + timestamp + data + previousHash + nonce;
        return applySHA256(input);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // ej: "0000"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Bloque minado: " + hash);
    }

    public static String applySHA256(String input) {
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
            throw new RuntimeException(e);
        }
    }

    // Getters y Setters

    public int getIndex() {
        return index;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public long getNonce() {
        return nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

package com.tme.it;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacSha256 {
    public static String hmacSHA256(String data, String secret) {
        try {
            // Create HMAC-SHA256 key from the given secret
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

            // Get an instance of Mac object implementing HMAC-SHA256
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            // Calculate the HMAC value
            byte[] hmacBytes = mac.doFinal(data.getBytes());

            // Convert result into a hexadecimal string
            StringBuilder sb = new StringBuilder(hmacBytes.length * 2);
            for (byte b : hmacBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to calculate HMAC-SHA256", e);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two integers as arguments.");
            return;
        }
        try {
//            String message = args[0];
            String message = "021{\"appId\":\"021\",\"appSecret\":\"021\"}1597302405123132";
//            String secret = args[1];
            String secret = "021";

            String hmacSha256Hex = hmacSHA256(message, secret);
            System.out.println(hmacSha256Hex);
        } catch (NumberFormatException e) {
            System.out.println("The arguments must be integers.");
        }
    }

}

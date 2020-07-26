package ru.cti.TestOmiliaBot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    FileInputStream fileInputStream;

    public static void main(String[] args) {
        String host = new String();
        String accessToken = new String();
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/app.properties");
            properties.load(fileInputStream);
            host = properties.getProperty("host").intern();
            accessToken = properties.getProperty("access_token");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Property file not found!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Creating new user");
 //       String gsonUser = GsonConvertation.convertUserToGson();
        System.out.println("New user created:");
//        System.out.println(gsonUser);

        System.out.println("\nTesting - Send Https GET request");
        HttpsConnectGetURL connectionGet = new HttpsConnectGetURL();
        try {
            connectionGet.sendHttpGETRequest(host, accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nTesting - Send Https POST request");
        HttpsConnectPostURL connectionPost = new HttpsConnectPostURL();
        try {
 //           connectionPost.sendPOST(host, gsonUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

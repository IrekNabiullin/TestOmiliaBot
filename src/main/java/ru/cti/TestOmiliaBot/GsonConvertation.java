package ru.cti.TestOmiliaBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Properties;

public class GsonConvertation {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String convertUserToGson() {
        /*
        PostRequest postRequest = new PostRequest();
        postRequest.setProperties();
        String gsonPostRequest = GSON.toJson(postRequest);
        System.out.println(gsonPostRequest);
        return gsonPostRequest;
         */

        Properties properties = new Properties();
        User user = new User();
        getProperties(properties, user);
        String gsonPostRequest = GSON.toJson(user);
        System.out.println(gsonPostRequest);
        return gsonPostRequest;
    }

        static void getProperties(Properties properties, User user) {
            user.setUser_id(properties.getProperty("user_id"));
            user.setEmail(properties.getProperty("email"));
            user.setFirst_name(properties.getProperty("first_name"));
            user.setLast_name(properties.getProperty("last_name"));
            user.setFullname(properties.getProperty("fullname"));
            user.setPhone_number(properties.getProperty("phone_number"));
            user.setUsername(properties.getProperty("username"));
        }

    public static void extractUserFromGson(String receivedGson) {
        User userReceivedFromApi = GSON.fromJson(receivedGson, User.class);
        String user_id = userReceivedFromApi.getUser_id();
        String email = userReceivedFromApi.getEmail();
        String first_name = userReceivedFromApi.getFirst_name();
        String last_name = userReceivedFromApi.getLast_name();
        String fullname = userReceivedFromApi.getFullname();
        String phone_number = userReceivedFromApi.getPhone_number();
        String username = userReceivedFromApi.getUsername();
        System.out.println("user_id: " + user_id);
        System.out.println("email: " + email);
        System.out.println("first_name: " + first_name);
        System.out.println("last_name: " + last_name);
        System.out.println("fullname: " + fullname);
        System.out.println("phone_number: " + phone_number);
        System.out.println("username: " + username);
    }
}

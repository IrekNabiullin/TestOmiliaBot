package ru.cti.TestOmiliaBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class HttpsConnectPostURL {

    public static String sendPOST(String url, String gson) throws IOException {
        URL obj = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) obj.openConnection();
        httpsURLConnection.setRequestMethod("POST");


        // POST - Send request
        httpsURLConnection.setDoOutput(true);
        OutputStream os = httpsURLConnection.getOutputStream();
        String post = gson;
        os.write(gson.getBytes());
        os.flush();
        os.close();

        // POST  - get response
        int responseCode = httpsURLConnection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpsURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            String result = response.toString();
            GsonConvertation.extractUserFromGson(result);
            return result;
        } else {
            System.out.println("POST request not worked");
        }
        return "Connection failed.";
    }
}

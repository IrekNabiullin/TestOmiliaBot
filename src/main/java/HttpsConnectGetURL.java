import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class HttpsConnectGetURL {
//    private static final String USER_AGENT = "Mozilla/5.0";

    public static void sendHttpGETRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) obj.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.setRequestProperty("accept", "application/json");
        int responseCode = httpsURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpsURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(httpsURLConnection.getHeaderFieldKey(i) + " = " + httpsURLConnection.getHeaderField(i));
        }

    }
}

public class Main {
    public static void main(String[] args) {
        String apiAddress = "https://api/internal/dialogsCopy";
        System.out.println("Creating new user");
        String gsonUser = GsonConvertation.convertUserToGson();
        System.out.println("New user created:");
        System.out.println(gsonUser);

        System.out.println("\nTesting - Send Https GET request");
        HttpsConnectGetURL connectionGet = new HttpsConnectGetURL();
        try {
            connectionGet.sendHttpGETRequest(apiAddress);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nTesting - Send Https POST request");
        HttpsConnectPostURL connectionPost = new HttpsConnectPostURL();
        try {
            connectionPost.sendPOST(apiAddress, gsonUser);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

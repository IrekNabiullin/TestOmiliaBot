import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConvertation {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static String convertUserToGson () {
        User user = new User();
        user.setUser_id("user_id");
        user.setEmail("testmail@cti.ru");
        user.setFirst_name("Name");
        user.setLast_name("Surname");
        user.setFullname("FullName");
        user.setPhone_number("+79001112233");
        user.setUsername("Username");

        String gsonUser = GSON.toJson(user);
        System.out.println(gsonUser);
        return gsonUser;
    }

    public static void extractUserFromGson (String receivedGson) {
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

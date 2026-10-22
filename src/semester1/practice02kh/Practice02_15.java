package semester1.practice02kh;

public class Practice02_15 {
    public static void main(String[] args) {
        String protocol = "https://";
        String host = "api.emample.com";
        String endpoint = "/users";
        int userId = 42;
        System.out.println("Запит відправлено на: " + protocol + host + endpoint + userId);
    }
}

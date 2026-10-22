package semester1.practice02kh;

public class Practice02_31 {
    public static void main(String[] args) {
        boolean hasPassworld = true;
        boolean hasSmsCode = true;
        boolean isAccountBlocked = false;
        boolean canLogin = hasPassworld && hasSmsCode && !isAccountBlocked;
        System.out.println(canLogin);
    }
}

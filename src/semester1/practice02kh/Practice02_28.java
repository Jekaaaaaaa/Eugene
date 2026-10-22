package semester1.practice02kh;

public class Practice02_28 {
    public static void main(String[] args) {
        int personAge = 70;
        boolean hasFreePass = (personAge < 7) || (personAge >= 65);
        System.out.println("Вік: " + personAge + ". " + "Право на безкоштовний проїзд: " + hasFreePass);
    }
}

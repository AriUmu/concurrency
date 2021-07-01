package lesson1;

public class Utils {

    public static void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        byte b = 5;
//        char c = '4';
//
//        System.out.println(charExpression(2));
//    }
//
//    public static char charExpression(int a) {
//        char slash = '\\';
//        int i = slash + a;
//        return (char) i;
//    }
}

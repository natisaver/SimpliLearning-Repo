public class typeCasting {
    public static void main(String[] args) {

        //implicit conversion, expansion
        char a = 'A'; //for char must use single quote, string use double quote
        int b = a;
        float c = b;
        System.out.println("Implicit Type Casting: " + c);

        //explicit conversion, narrowing
        double x = 55.9; //x=55.9
        int y = (int)x; //y=55

        System.out.println("value x: " + x);
        System.out.println("value y: " + y);

    }
}

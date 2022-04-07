public class Lab3 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("ASD");
        System.out.println(s);
        s.append("B");
        System.out.println(s);
        for (int i = 0; i < 100000; i++) {
            s.append("B");
        }
        System.out.println(s);

        /*String s = "ASD";
        System.out.println(s);
        s += "B";
        System.out.println(s);
        for (int i = 0; i < 100000; i++) {
            s += "B";
        }
        System.out.println(s);*/

        /*for (int i = 0; i < 1000000; i++) {
            System.out.println("Done!");
        }*/
    }
}

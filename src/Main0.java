import myPackage.LogicOperations;

public class Main0 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(args[0]);
        System.out.println(args[3]);

        int a;
        a = 1;
        System.out.println("a = " + a);

        char c = 49;
        System.out.println("c = " + c);
        System.out.println("c+1 = " + c + 1);
        System.out.println("(c+1) = " + (c + 1));
        System.out.println("(char)(c+1) = " + (char)(c + 1));
        System.out.println("(int)c = " + (int) c);

        char c1 = '1';
//        char c1 = '\u1a23';
        System.out.println("c1 = " + c1);
        System.out.println("(int)c1 = " + (int) c1);

        String s1 = "ASD";
//        String s1 = "ASD", s2 = "ASD";
        System.out.println(s1);
        String s2 = "ASD";
//        s1 += "B";
        System.out.println("s1 == s2" + (s1 == s2));

        LogicOperations logicOperations;
    }
}

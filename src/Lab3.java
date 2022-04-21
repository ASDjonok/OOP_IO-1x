public class Lab3 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("ASD987");
        System.out.println(stringBuffer);
        stringBuffer.append("QWER");
        System.out.println(stringBuffer);
        stringBuffer.appendCodePoint(56);
        System.out.println(stringBuffer);
//        stringBuffer.
        /*StringBuilder s = new StringBuilder("ASD");
        StringBuilder s2 = new StringBuilder("ASD");
        System.out.println(s);
        s.append("B");
        System.out.println(s);
        for (int i = 0; i < 100000; i++) {
            s.append("B");
        }
        System.out.println(s);*/

        String s = "ASD";
        String s2 = "AS";
        String s3 = s2 + "D";
        final String[] s1 = s.split("[SA]");
        System.out.println(s);
        s += "B";
        System.out.println(s);
        /*for (int i = 0; i < 100000; i++) {
            s += "B";
        }*/
        System.out.println(s);

        /*for (int i = 0; i < 1000000; i++) {
            System.out.println("Done!");
        }*/
    }
}

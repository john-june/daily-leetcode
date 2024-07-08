public class FormatArrayString {
    public static void main(String[] args) {
        String s = "[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]";

        s= s.replaceAll("]", "}");
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("\"", "'");

        System.out.println(s);
    }

}

public class OuterClass {
    int a=10;
    static int b=20;
    private static int c=30;
    
    static class InnerClass {
        void print(){
            // System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }
}

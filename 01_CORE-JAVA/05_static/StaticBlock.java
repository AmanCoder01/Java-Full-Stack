public class StaticBlock {
    static int x;

    // StaticBlock() {
    // x = 40;
    // }

    static {
        x = 40;
    }

    public static void main(String[] args) {
        // StaticBlock staticBlock = new StaticBlock();
        System.out.println(x);
    }
}
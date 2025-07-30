public class Demo implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo instanceof Cloneable); // true

        try {
            Demo d2 = (Demo) demo.clone();
            System.out.println("Cloning successful.");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

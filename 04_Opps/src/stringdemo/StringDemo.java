package stringdemo;

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "Aman";
        String s4 = "Aman";
        String s2 = new String("Aman");
        String s3 = new String("Aman");

        s2 = s2.concat("maurya");

        System.out.println(s2);

//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s3.hashCode());
//        System.out.println(s4.hashCode());

        if(s1==s2){
            System.out.println("Equals with ==");
        }

        if(s1.equals(s2)){
            System.out.println("Equals with equals");
        }
    }
}

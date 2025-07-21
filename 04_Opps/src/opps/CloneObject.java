package opps;


public class CloneObject{
    public static void main(String[] args) {
        try{
            Students s1=new Students(101,"amit");
            Students s2=(Students)s1.clone();

//            System.out.println(s1.rollno+" "+s1.name);
//
//            System.out.println(s2.rollno+" "+s2.name);
//            s2.name = "aman";
//            System.out.println(s2.rollno+" "+s1.name);

            System.out.println(Math.floor(Math.random()*10));
            System.out.println((int)(Math.random()*10));

        }catch(CloneNotSupportedException c){}

    }
}


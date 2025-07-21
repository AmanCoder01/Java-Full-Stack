package opps;

public class Students implements Cloneable {
    int rollno;
    String name;

    Students(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

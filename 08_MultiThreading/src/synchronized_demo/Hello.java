package synchronized_demo;

public class Hello {
    int sum = 0;

   synchronized void addition(){
        for(int i=1; i<=5;i++){
            System.out.println(Thread.currentThread().getName()+ ", i = "+ i);
            sum += i;

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("jhdg");
            }
        }
    }

    int getSum(){
        return this.sum;
    }
}

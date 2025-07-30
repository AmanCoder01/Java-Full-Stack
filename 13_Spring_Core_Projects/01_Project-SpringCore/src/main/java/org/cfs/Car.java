package org.cfs;

public class Car {
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        int start = engine.start();
        if(start>=1){
            System.out.println("Driving");
        }else{
            System.out.println("Not started");
        }
    }
}

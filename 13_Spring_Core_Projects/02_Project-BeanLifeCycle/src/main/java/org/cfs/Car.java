package org.cfs;

public class Car {

    private Engine engine;

    public void setEngine(Engine engine) {
        System.out.println("setEngine() method called");
        this.engine = engine;
    }

    public Car(){
        System.out.println("Default const");
    }

    public Car(Engine engine) {
        System.out.println("Arg const");

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

package JavaExample;

import org.apache.commons.math3.analysis.function.Abs;

abstract class baseclass1{
    baseclass1(){
        System.out.println("inside baseclass1 constructor");
    }
    final void finalMethod(){
        System.out.println("in base final method");
    }
    static void staticMethod(){
        System.out.println("in base static method");
    }
    abstract void abstractMethod1();
    void concreteMethod1(){
        System.out.println("In baseclass1 concrete method");
    }
}
public class AbstractClassExample extends baseclass1 {
    AbstractClassExample(){
        System.out.println("inside AbstractClassExample constructor");
    }
    void abstractMethod1() {
        System.out.println("inside abstractMethod1 implementation");
    }
    public static void main(String[] args){
        AbstractClassExample acexample = new AbstractClassExample();
        acexample.abstractMethod1();
        acexample.finalMethod();
        AbstractClassExample.staticMethod();
        baseclass1 cls = new AbstractClassExample();
        cls.abstractMethod1();
        cls.finalMethod();
        baseclass1.staticMethod();
    }
}

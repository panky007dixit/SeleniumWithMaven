package JavaExample;
interface testinterface{
    final  int a = 10;
    static void staticMethod(){
        System.out.println("in static implementation of interface");
    }
    default void defaultMethod(){
        System.out.println("in default implementation of interface");
    }
}
interface testinterface2{
     int a = 20;    // By default a is public static final
    void print();   // By default print is public
    static void staticMethod2(){
        System.out.println("in static implementation of interface2");
    }
    default void defaultMethod2(){
        System.out.println("in default implementation of interface2");
    }
}
public class InterfaceExample implements testinterface,testinterface2 {
    public void print(){
        System.out.println("In class");
    }
    public static void main(String[] args) {
        InterfaceExample example = new InterfaceExample();
        example.defaultMethod();
        example.defaultMethod2();
        testinterface.staticMethod();
        testinterface2.staticMethod2();
        example.print();
    }
}


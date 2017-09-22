package cn.imaq.helloservice;

public class HelloService {
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }

    public void sayHello() {
        sayHello("Module");
    }
}

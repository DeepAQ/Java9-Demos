package cn.imaq.hello;

import cn.imaq.helloservice.HelloService;

public class Hello {
    public static void main(String[] args) {
        if (args.length > 0) {
            new HelloService().sayHello(args[0]);
        } else {
            new HelloService().sayHello();
        }
    }
}

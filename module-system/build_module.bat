rd /s /q build
javac -d build --module-source-path . helloservice/module-info.java helloservice/cn/imaq/helloservice/HelloService.java hellomod/module-info.java hellomod/cn/imaq/hello/Hello.java

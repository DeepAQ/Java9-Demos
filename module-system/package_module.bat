cmd /c build_module.bat
md build\jar
jar --create --file=build/jar/helloservice.jar --module-version=1.0 -C build/helloservice .
jar --create --file=build/jar/hellomod.jar --module-version=1.0 --main-class=cn.imaq.hello.Hello -C build/hellomod .
md build\jmod
jmod create --class-path build/helloservice build/jmod/helloservice.jmod
jmod create --class-path build/hellomod build/jmod/hellomod.jmod

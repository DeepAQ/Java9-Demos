cmd /c build_module.bat
jlink --module-path="%JAVA_HOME%/jmods;build" --add-modules hellomod --output build/helloapp
build\helloapp\bin\java --list-modules

# Java 9 新特性速览

## 重大更新

### Module System (Jigsaw)
- 在编译和运行之间加入新的可选阶段链接 (link)，可将多个模块 (module) 链接成一个运行时镜像 (runtime image)。
- 模块的 jar 包中需包含 `module-info.class`
- 新增 jmod 文件格式，与 jar 相比可加入二进制程序和配置文件等。
    - 典型的 jmod 文件结构：
        - classes\ 存放编译后的字节码
        - conf\ 存放配置文件
        - bin\ 存放二进制程序
        - include\ 存放引用的头文件
        - lib\ 存放动态链接库
        - legal\ 存放协议及版权声明等文档
- 新工具 [jlink](https://docs.oracle.com/javase/9/tools/jlink.htm) / [jmod](https://docs.oracle.com/javase/9/tools/jmod.htm)
    - `jlink [options] --module-path modulepath --add-modules mods --output path`
    - `jmod (create|extract|list|describe|hash) [options] jmod-file`
- `rt.jar` / `tools.jar` 不再存在，由各个模块替代。
- **[多模块 Demo](module-system/)**

### JShell
- 位于 `%JAVA_HOME%/bin` 目录中
- 提供交互式 REPL 命令行 (终于可以快速执行 Java 代码片段了！)
- **Demo:**
```
> jshell
|  欢迎使用 JShell -- 版本 9
|  要大致了解该版本, 请键入: /help intro

jshell> Arrays.asList(2, 3, 5, 7, 11)
$1 ==> [2, 3, 5, 7, 11]

jshell> $1.stream().mapToInt(x -> x).average()
$2 ==> OptionalDouble[5.6]

jshell> /exit
|  再见
```
- [在程序中调用 JShell 的 Demo](mini-demos/src/cn/imaq/java9demo/jshell/MyJShell.java)

## 其它更新
TODO
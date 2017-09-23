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
- [**在程序中调用 JShell 的 Demo**](mini-demos/src/cn/imaq/java9demo/JShellDemo.java)

## 其它更新

### 基础 API 更新

| JEP 编号 | 更新内容 |
| --- | --- |
| JEP 102 | Process API Updates / 操作系统进程管理 API 更新<br>[**Demo: 获取系统进程信息 & Pipeline 演示**](mini-demos/src/cn/imaq/java9demo/ProcessAPIDemo.java) |
| JEP 110 | HTTP 2 Client / HTTP2 客户端<br>支持 HTTP/2 (并向下兼容 HTTP/1.1) 的异步 HTTP 客户端，位于 Incubator 包内。<br>[**Demo: 异步执行 HTTP/1.1 及 HTTP/2 请求**](mini-demos/src/cn/imaq/java9demo/HttpClientDemo.java) |
| JEP 193 | Variable Handles / 变量引用<br>用于在部分场合替代 Unsafe (然而 JDK 貌似没把坑填完，目前的 Atomic 系列还是在用 Unsafe 实现)<br>[**Demo: 用 VarHandle 实现简易版 AtomicInteger**](mini-demos/src/cn/imaq/java9demo/VarHandleDemo.java) |
| JEP 254 | Compact Strings / 字符串存储方式变更<br>String 再也不用 char[] 来存储啦，改成了 byte[] 加上编码标记，节约了一些空间。 |
| JEP 259 | Stack-Walking API / 堆栈跟踪接口更新<br>[**Demo: 利用新接口获取当前运行时堆栈**](mini-demos/src/cn/imaq/java9demo/StackWalkDemo.java) |
| JEP 264 | Platform Logging API and Service / 统一日志接口<br>提供统一的日志服务接口，可自行编写日志记录器。<br>[**Demo: 提供自定义日志记录器**](platform-logging/) |
| JEP 266 | More Concurrency Updates / 并发包更新<br>_这坑看上去有点大，日后再填_ |
| JEP 269 | Convenience Factory Methods for Collections / 简化集合创建方法<br>终于可以快速创建(只读)集合对象了！ [**Demo**](mini-demos/src/cn/imaq/java9demo/CollectionsDemo.java) |
| JEP 274 | Enhanced Method Handles / 方法引用更新<br>_日后再填_ |
| JEP 285 | Spin-Wait Hints / 自旋指示<br>提供 API 用于指示自旋循环以提高自旋时的性能。<br>[**Demo: 用自旋锁实现生产者-消费者模式**](mini-demos/src/cn/imaq/java9demo/SpinWaitDemo.java) |

### 客户端技术 (AWT / Swing / JavaFX) 更新

TODO

### Java 语法更新

TODO

### JDK 更新

TODO

### JVM 更新

TODO
